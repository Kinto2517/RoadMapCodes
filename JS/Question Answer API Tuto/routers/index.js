const express = require("express");
const router = express.Router();
const questions = require("../routers/question");
const auth = require("../routers/auth");
const users = require("../routers/user");

router.use("/questions", questions);
router.use("/auth", auth);
 router.use("/users", users);

module.exports = router;
 