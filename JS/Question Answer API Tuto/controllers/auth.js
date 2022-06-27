const User = require("../models/User");
const CustomError = require("../helpers/error/CustomError");
const asyncErrorWrapper = require("express-async-handler");
const { sendJwtToClient } = require("../helpers/authorization/tokenHelpers");
const {
  validateUserInput,
  comparePassword,
} = require("../helpers/authorization/inputHelpers");
const sendEmail = require("../helpers/libraries/sendEmail");
const register = asyncErrorWrapper(async (req, res, next) => {
  const { name, email, password } = req.body;
  const user = await User.create({
    name: req.body.name,
    email: req.body.email,
    password: req.body.password,
  });

  sendJwtToClient(user, res);
});

const getUser = (req, res, next) => {
  console.log(req.user);
  res.json({
    success: true,
    data: {
      id: req.user.id,
      name: req.user.name,
    },
  });
};

const login = asyncErrorWrapper(async (req, res, next) => {
  const { email, password } = req.body;
  console.log(email, password);
  if (!validateUserInput(email, password)) {
    throw new CustomError("Invalid input", 400);
  }

  console.log(email, password);
  const user = await User.findOne({ email }).select("+password");
  console.log(user);
  if (!comparePassword(password, user.password)) {
    return next(new CustomError("Invalid credentials", 400));
  }

  sendJwtToClient(user, res);
});

const logout = asyncErrorWrapper(async (req, res, next) => {
  return res
    .status(200)
    .cookie({
      httpOnly: true,
      expires: new Date(Date.now()),
      secure: process.env.NODE_ENV === "development" ? false : true,
    })
    .json({
      success: true,
      message: "Logout successful",
    });
});

const imageUpload = asyncErrorWrapper(async (req, res, next) => {
  await User.findByIdAndUpdate(
    req.user.id,
    {
      profile_image: req.savedFileName,
    },
    { new: true, runValidators: true }
  );
});

const forgotPassword = asyncErrorWrapper(async (req, res, next) => {
  const resetEmail = req.body.email;

  const user = await User.findOne({ email: resetEmail });

  if (!user) {
    return next(new CustomError("User not found", 404));
  }

  const resetPasswordToken = user.getResetPasswordToken();

  await user.save();

  const resetPasswordUrl = `http://localhost:3000/api/auth/resetpassword?resetPasswordToken=${resetPasswordToken}`;

  const emailTemplate = `
    <h1>Reset Password</h1>
    <p>Click the link below to reset your password:</p>
    <a href="${resetPasswordUrl}">${resetPasswordUrl}</a>
    `;

  try {
    await sendEmail({
      from: process.env.SMTP_USER,
      to: resetEmail,
      subject: "Reset Password",
      html: emailTemplate,
    });

    res.json({
      success: true,
      message: "Token sent to email",
    });
  } catch {
    user.resetPasswordToken = undefined;
    user.resetPasswordExpire = undefined;

    await user.save();
    return next(new CustomError("Email could not be sent", 500));
  }
});

const resetPassword = asyncErrorWrapper(async (req, res, next) => {

  const { resetPasswordToken } = req.query;

  const user = await User.findOne({
    resetPasswordToken,
    resetPasswordExpire: { $gt: Date.now() },
  });

  if (!user) {
    return next(new CustomError("Invalid token", 400));
  }

  user.password = req.body.password;
  user.resetPasswordToken = undefined;
  user.resetPasswordExpire = undefined;

  await user.save();

});

const editDetails = asyncErrorWrapper(async (req, res, next) => {

  const { name, email } = req.body;

  const user = await User.findByIdAndUpdate(req.user.id, {
    name,
    email,
  }, { new: true, runValidators: true });

  res.json({
    success: true,
    data: user,
  });

})

module.exports = {
  register,
  getUser,
  login,
  logout,
  imageUpload,
  forgotPassword,
  resetPassword,
  editDetails
};
