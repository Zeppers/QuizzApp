package com.example.aeroz.quizzapp.notActivities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TakenQuiz extends Quiz implements Serializable {

    private int remainingTries;
    private List<ChosenAnswer> chosenAnswers = new ArrayList<>();
    private int noCorrectAnswers = 0;

    public TakenQuiz(){}

    public TakenQuiz(Quiz q){
        super(q.quizName,q.description,q.questions,q.time,q.active,q.privat,q.creator);
        this.remainingTries = 3;
        this.id = q.id;
        this.code = q.code;
    }
    public TakenQuiz(Quiz q, int remainingTries){
        super(q.quizName,q.description,q.questions,q.time,q.active,q.privat,q.creator);
        this.id = q.id;
        this.code = q.code;
        this.remainingTries = remainingTries;
    }
    public void chooseAnswers(Question question, int[] chosenAnswers){
        ChosenAnswer ca = new ChosenAnswer(question,chosenAnswers);
        this.chosenAnswers.add(ca);
        if(Util.arraysEqual(ca.getChosenAnswers(),question.getCorrectAnswers()))
            noCorrectAnswers++;
    }

    public List<ChosenAnswer> getChosenAnswers(){return this.chosenAnswers;}

    public float calculateScore(){
        return (float)noCorrectAnswers/questions.size()*100;
    }
    public int getNoCorrectAnswers(){return this.noCorrectAnswers;}
    public int getRemainingTries(){return this.remainingTries;}     public void setRemainingTries(int value){this.remainingTries = value;}

    public String toString(){return this.id+" "+this.description+" "+this.creator+" ";}
}
