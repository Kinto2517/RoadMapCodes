const accessControl = (req, res, next) => {
    console.log('accessControl');
    const access = true;
    if (access) {
        next();
    }else {
        res.status(403).send('Forbidden');
    }
    
}

module.exports = accessControl;