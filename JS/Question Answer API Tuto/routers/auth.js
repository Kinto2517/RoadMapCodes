const express = require("express");
const {register,getUser, login, logout, imageUpload, forgotPassword, resetPassword } = require("../controllers/auth");
const {getAccessToRoute} = require("../middlewares/authorization/auth");
const profileImageUpload = require("../middlewares/libraries/profileImageUpload");
const {editDetails} = require("../controllers/auth");
const router = express.Router();

router.post("/login", login);

router.post("/register", register);
router.get("/profile", getAccessToRoute, getUser);
router.get("/logout", getAccessToRoute, logout);
router.post("/forgotpassword", forgotPassword);
router.put("/resetpassword", resetPassword)
router.post("/upload", [getAccessToRoute,profileImageUpload.single("profile_image")],imageUpload)
router.put("/edit",getAccessToRoute, editDetails);

module.exports = router;
