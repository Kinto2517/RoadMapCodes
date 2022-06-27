const CustomError = require("../../helpers/error/CustomError");
const {
  isTokenIncluded,
  getAccesTokenFromHeader,
} = require("../../helpers/authorization/tokenHelpers");
const jwt = require("jsonwebtoken");
const asyncErrorWrapper = require("express-async-handler");


const getAccessToRoute =  asyncErrorWrapper((req, res, next) => {
  if (!isTokenIncluded(req)) {
    throw new CustomError("No token included", 401);
  }

  const token = getAccesTokenFromHeader(req);

  jwt.verify(token, process.env.JWT_SECRET_KEY, (err, decoded) => {
    if (err) {
        return next(new CustomError("Invalid token", 401));
    }
    console.log(decoded)
    req.user = {
        id: decoded._id,
        name: decoded.name,
    };
    console.log(req.user);

    next();
  });

  next();
});

module.exports = {
  getAccessToRoute,
};
