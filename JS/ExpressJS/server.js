const express = require('express');

const app = express();
const accessControl = require('./middleware');
const port = process.env.PORT || 3000;
const users = [
    { id: 1, name: 'ryan' },
    { id: 2, name: 'james' }
];    
app.use(express.json());
app.use(accessControl);


app.get('/users', accessControl, (req, res) => {
    res.json(users);
  });
  
app.get('/products', (req, res) => {
    res.send("products");
});

app.post('/users', (req, res) => {
    const user = req.body;
    res.json({
        success: true,
            data: user
    });
});

app.delete('/users/:id', (req, res) => {
    res.json({ message: 'user deleted' });
})

app.put('/users/:id', (req, res) => {
    const user = req.body;
    const id = parseInt(req.params.id);

    for(let i = 0; i < users.length; i++) {
        if(users[i].id === id) {
            users[i] = {
                ...users[i],
                ...user
            };
            break;
        }
    }


    res.json({
        success: true,
        data: users,
        message: 'user updated' });
    
})

app.delete('/users/:id', (req, res) => {
    const id = parseInt(req.params.id);
    for(let i = 0; i < users.length; i++) {
        if(users[i].id === id) {
            users.splice(i, 1);
            break;
        }
    }
    res.json({
        success: true,
        data: users,
        message: 'user deleted' });
});


app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
  });
  
