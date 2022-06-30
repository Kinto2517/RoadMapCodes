const mongoose = require('mongoose');

const Schema = mongoose.Schema;

const QuestionSchema = new Schema({

    title: {
        type: String,
        required: true,
        unique: true
    },

    content: {
        type: String,
        required: true
        minlength: 10,
    },
    slug: {
        type: String,
    },
    createdAt: {
        type: Date,
        default: Date.now
    },
    user: {
        type: mongoose.Schema.ObjectId,
        required: true,
        ref: 'User'
    }
        
            
});

module.exports = mongoose.model('Question', QuestionSchema);    
