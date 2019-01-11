package com.example.aeroz.quizzapp.notActivities;

public class QuestionDB {
    private String text;
    private int quizId;

    public QuestionDB(String text, int quizId){
        this.text =text;
        this.quizId = quizId;
    }
    public QuestionDB(Question question, int quizId){
        this.text = question.getText();
        this.quizId = quizId;
    }
}
