const getAllQuestions = (req, res) => {
  res.json({
    message: "Get All Questions",
    success: "true",
    questions: [
      {
        id: 1,
        question: "What is your name?",
        answer: "",
        userId: 1,
        createdAt: "2020-01-01",
      },
    ],
  });
};

module.exports = {
  getAllQuestions,
};
