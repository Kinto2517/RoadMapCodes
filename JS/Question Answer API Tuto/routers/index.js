const express = require("express");
const router = express.Router();
const questions = require("../routers/question");
const auth = require("../routers/auth");

router.use("/questions", questions);
router.use("/auth", auth);
 

module.exports = router;
 