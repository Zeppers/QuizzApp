package com.example.aeroz.quizzapp.notActivities;

public class AnswerDB {
    private int id;
    private String text;
    private boolean isCorrect;
    private int questionID;

    public AnswerDB( String text, boolean isCorrect,int questionID){
        this.text = text;
        this.isCorrect = isCorrect;
        this.questionID=questionID;
    }


}
