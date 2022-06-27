const express = require("express");
const { getAccessToRoute, getAdminAccess } = require("../middlewares/authorization/auth");
//Block User
const {blockUser} = require("../controllers/admin.js");
const {deleteUser} = require("../controllers/admin.js");
//Delete User

const router = express.Router();

router.use([getAccessToRoute, getAdminAccess]);
router.get("/block/:id",blockUser);
router.delete("user/:id", deleteUser);



module.exports = router;
