const express = require("express");
const router = express.Router();
const { getSingleUser, getAllUsers } = require("../controllers/user.js");
const { checkUserExists } = require("../database/databaseErrorHelpers.js");

router.get("/", getAllUsers); 
router.get("/:id", checkUserExists, getSingleUser);



module.exports = router;