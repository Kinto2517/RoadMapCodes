const mongoose = require("mongoose");
const Schema = mongoose.Schema;
const bcrypt = require("bcryptjs");
const jwt = require("jsonwebtoken");
const crypto = require("crypto");


const userSchema = new Schema({
    name: {
        type: String,
        required: [true, "Name is required"],
        minlength: 3,

    },
    email: {   
        type: String,
        required: true,
        minlength: 3,
        unique: [true, "Email is required"],
        match: /^([a-zA-Z0-9_\-.]+)@([a-zA-Z0-9_\-.]+)\.([a-zA-Z]{2,5})$/,
        
    },
    role: {
        type: String,
        enum: ["user", "admin"],
        default: "user",
    },
    password: {
        type: String,
        required: true,
        minlength: 6,
        select: false,
    },

    createdAt: {
        type: Date,
        default: Date.now,

    },
    title: {
        type: String,
    
    },
    about: {
        type: String,

    
    },
    place: {
        type: String,


    },
    website: {
        type: String,

    },
    profile_image: {
        type: String,
        default: "https://res.cloudinary.com/dzqbzqgjw/image/upload/v1599098981/profile_image_default_qjqjqj.png",
    },
    blocked: {
        type: Boolean,
        default: false,
    
    },
    resetPasswordToken: {
        type: String,
      
    },
    resetPasswordExpire: {
        type: Date,

    },
});

userSchema.methods.getResetPasswordToken = function () {

    const resetToken = crypto.randomBytes(20).toString("hex");
    
const resetPasswordToken = crypto.createHash("sha256").update(resetToken).digest("hex");

 this.resetPasswordToken = resetPasswordToken;
 this.resetPasswordExpire = Date.now() + 10 * 60 * 1000;


    return resetToken;
}

userSchema.methods.generateJwtToken = function () {

    const {JWT_SECRET_KEY, JWT_EXPIRE} = process.env;
    const payload = {
        _id: this._id,
        name: this.name
    };
    const token = jwt.sign(payload, JWT_SECRET_KEY, {expiresIn: JWT_EXPIRE});
    return token;

}

userSchema.pre("save",function (next) {
    
    if(!this.isModified("password")){
        return next();
    }

    bcrypt.genSalt(10, (err, salt) => {
        if (err) next(err);
        bcrypt.hash(this.password, salt, (err, hash) => {
            if (err) next(err);
            this.password = hash;
            next();
        });
    });
});


module.exports = mongoose.model("User", userSchema);

