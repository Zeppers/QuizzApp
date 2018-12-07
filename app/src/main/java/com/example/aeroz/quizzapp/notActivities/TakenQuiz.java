package com.example.aeroz.quizzapp.notActivities;

import java.util.List;

public class TakenQuiz extends Quiz {
    private int remainingTries;

    public TakenQuiz(String quizName, List<Question> questions, int time, boolean active, boolean privat,String creator, int remainingTries) throws Exception {
        super(quizName,questions,time,active,privat, creator);
        if(this.active)
            throw new Exception("Test must be active!");
        else
            this.remainingTries = remainingTries;
    }

    public float calculateScore(){

        return 0;
    }

}
