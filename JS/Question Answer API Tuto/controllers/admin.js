const User = require("../models/User");
const CustomError = require("../helpers/error/CustomError");
const asyncErrorWrapper = require("express-async-handler");

const blockUser = asyncErrorWrapper(async (req, res, next) => {

    const user = await User.findById(req.params.id);
    if (!user) {
        return next(new CustomError("User not found", 404));
    }
    user.blocked = !user.blocked;
    await user.save();
    res.json({
        success: true,
        data: user, 
    });
    next();


})

const deleteUser = asyncErrorWrapper(async (req, res, next) => {

    const user = await User.findById(req.params.id);
    if (!user) {
        return next(new CustomError("User not found", 404));
    }
    await user.remove();
    res.json({
        success: true,
        data: user,
    });
    next();


})

module.exports = {
    blockUser,
    deleteUser
}