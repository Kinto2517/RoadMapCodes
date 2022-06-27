const nodemailer = require("nodemailer");

const sendEmail = async (email, subject, text) => {
  let transporter = nodemailer.createTransport({
    host: "smtp.gmail.com",
    port: 587,
    auth: {
      user: process.env.SMTP_USER,
      pass: process.env.STMP_PASS,
    },
  });

  let info = await transporter.sendMail({});
};

module.exports = sendEmail;
