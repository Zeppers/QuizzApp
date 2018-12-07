package com.example.aeroz.quizzapp.notActivities;

import java.util.List;

public class TakenQuiz extends Quiz {
    public int remainingTries;
    public float score;

    public TakenQuiz(String quizName, List<Question> questions, int time, boolean active, boolean privat,int remainingTries, float score) throws Exception {
        super(quizName,questions,time,active,privat);
        if(this.active)
            throw new Exception("Test must be active!");
        else{
        this.remainingTries = remainingTries;
        this.score = score;}
    }


}
