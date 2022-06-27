const sendJwtToClient = (user, res) => {
  const token = user.generateJwtToken();

  const { JWT_COOKIE_EXPIRES_IN, NODE_ENV } = process.env;
  return res
    .status(200)
    .cookie("access_token", token, {
      httpOnly: true,
      expires: new Date(Date.now() + parseInt(JWT_COOKIE_EXPIRES_IN) * 1000 *60*24),
      secure: NODE_ENV === "development" ? false : true,
    })
    .json({
      success: true,
      access_token: token,
      message: "User logged in successfully",
      data: {
        name: user.name,
        email: user.email,
      },
    });
};

const isTokenIncluded = (req) => {
  
  return req.headers.authorization.split(' ')[0] === 'Bearer:';
}

const getAccesTokenFromHeader = (req) => {
  return req.headers.authorization.split(' ')[1];
}

module.exports = {sendJwtToClient
,isTokenIncluded 
,getAccesTokenFromHeader};
