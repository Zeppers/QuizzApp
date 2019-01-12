package com.example.aeroz.quizzapp.notActivities;

import java.io.Serializable;

public class TakenQuizDB implements Serializable {
    private float score;
    private int remainingTries;
    private int studentId;
    private int quizId;

    public TakenQuizDB(){};
    public TakenQuizDB(int score, int remainingTries, int studentId, int quizId){
        this.score = score;
        this.remainingTries = remainingTries;
        this.studentId = studentId;
        this.quizId = quizId;
    }

    public int getRemainingTries(){return this.remainingTries;}
    public float getScore(){return this.score;}
    public int getStudentId(){return this.studentId;}
    public int getQuizId(){return this.quizId;}

    public void setRemainingTries(int value){this.remainingTries= value;}
    public void setScore(float value){this.score = value;}
    public void takeTry(){this.remainingTries--;}

    public String toString(){
        return "\nscore:"+this.score+" remTries:"+this.remainingTries+" studentId:"+this.studentId+" quizId"+this.quizId;
    }
}
