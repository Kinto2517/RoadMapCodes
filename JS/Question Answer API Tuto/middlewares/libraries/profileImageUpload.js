const multer = require("multer");

const path = require("path");

const CustomError = require("../../helpers/error/CustomError");

const storage = multer.diskStorage({
  destination: function (req, file, cb) {
    const rootDir = path.dirname(require.main.filename);
    cb(null, path.join(rootDir, "public/uploads"));
  },
  filename: function (req, file, cb) {
    const extension = file.mimetype.split("/")[1];
    req.savedFileName = `image_${req.user.id}${extension}`;
    cb(null, req.savedFileName);
  },
});

const fileFilter = (req, file, cb) => {
  if (
    file.mimetype === "image/jpeg" ||
    file.mimetype === "image/png" ||
    file.mimetype === "image/jpg"
  ) {
    cb(null, true);
  } else {
    cb(new CustomError("Invalid file type", 400), false);
  }
};

const profileImageUpload = multer({
  storage,
  fileFilter,
});

module.exports = profileImageUpload;