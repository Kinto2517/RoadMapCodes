const customErrorHandler=((err, req, res, next) => {

    
    console.log(err.message);
    res.status(500).json({
      message: err.message,
    });
  });

    module.exports = customErrorHandler;