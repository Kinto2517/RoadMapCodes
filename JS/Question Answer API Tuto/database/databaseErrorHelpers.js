const User = require("../models/User");
const CustomError = require("../helpers/error/CustomError");
const asyncErrorWrapper = require("express-async-handler");

const checkUserExists = asyncErrorWrapper(async (req, res, next) => {

    const user = await User.findById(req.params.id);
    if (!user) {
        return next(new CustomError("User not found", 404));
    }
    res.json({
        success: true,
        data: user,
    });
    next();

})


module.exports = {
    checkUserExists
}
