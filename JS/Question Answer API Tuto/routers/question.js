const express = require("express");
const {getAllQuestions} = require("../controllers/question"); 
const router = express.Router();
const {getAccessRoute} = require("../middleware/authorization/auth");
const {askNewQuestion} = require ("../controllers/question");


router.get("/",getAllQuestions);

router.post("/ask",askNewQuestion);


module.exports = router;