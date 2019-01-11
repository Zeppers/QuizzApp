package com.example.aeroz.quizzapp.notActivities;

public class TakenQuiz {
    private float score;
    private int remainingTries;
    private Quiz quiz;

    public float getScore() {
        return score;
    }

    public int getRemainingTries() {
        return remainingTries;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setRemainingTries(int remainingTries) {
        this.remainingTries = remainingTries;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }


    public TakenQuiz(float score, int remainingTries, Quiz quiz){
        this.score = score;
        this.remainingTries = remainingTries;
        this.quiz = quiz;
    }
}
