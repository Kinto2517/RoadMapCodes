const express = require("express");
const dotenv = require("dotenv");
const routers = require("./routers/index");
const connectDatabase = require("./helpers/database/connectDatabase");
const customErrorHandler = require("./middlewares/errors/customErrorHandler");
const bodyParser = require("body-parser");
dotenv.config({
  path: "./config/env/config.env",
});

connectDatabase();
const app = express();
const port = process.env.PORT;

app.use(bodyParser.urlencoded({
  extended: true
}));

app.use(express.json());

app.use("/api", routers);
app.use(customErrorHandler);

//static
app.use(express.static("public"));

app.listen(port, () => {
  console.log(`Server is running on port ${port} : ${process.env.NODE_ENV}`);
});
