const User = require("../models/User");
const CustomError = require("../helpers/error/CustomError");
const asyncErrorWrapper = require("express-async-handler");
const { sendJwtToClient } = require("../helpers/authorization/tokenHelpers");
const {
  validateUserInput,
  comparePassword,
} = require("../helpers/authorization/inputHelpers");

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
 
  return res.status(200).cookie({
  
    httpOnly: true,
    expires: new Date(Date.now()),
    secure: process.env.NODE_ENV === "development" ? false : true,
  }).json({
    success: true,
    message: "Logout successful",
  });
  })
  
  const imageUpload = asyncErrorWrapper(async (req, res, next) => {

    await User.findByIdAndUpdate(req.user.id, {
      "profile_image": req.savedFileName,
    }, { new: true, runValidators: true });

  });

  const forgotPassword = asyncErrorWrapper(async (req, res, next) => {

    const resetEmail = req.body.email;

    const user = await User.findOne({ email: resetEmail });

    if (!user) {
      return next(new CustomError("User not found", 404));
    }

    const resetPasswordToken = user.getResetPasswordToken();


    await user.save();
    
    res.json({
      success: true,
      message: "Token sent to email",
    });


  })

module.exports = {
  register,
  getUser,
  login,
  logout,
  imageUpload,
  forgotPassword
};
