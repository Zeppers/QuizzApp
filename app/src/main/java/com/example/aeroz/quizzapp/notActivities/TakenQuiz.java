package com.example.aeroz.quizzapp.notActivities;

import java.util.ArrayList;
import java.util.List;

public class TakenQuiz extends Quiz {
    private int remainingTries;
    private List<ChosenAnswer> chosenAnswers = new ArrayList<>();
    private int noCorrectAnswers = 0;
    public TakenQuiz(String quizName, List<Question> questions, int time, boolean active, boolean privat,String creator, int remainingTries) {
        super(quizName,questions,time,active,privat, creator);
            this.remainingTries = remainingTries;
    }
    public void chooseAnswers(Question question, int[] chosenAnswers){
        ChosenAnswer ca = new ChosenAnswer(question,chosenAnswers);
        this.chosenAnswers.add(ca);
        if(Util.arraysEqual(ca.chosenAnswers,question.getCorrectAnswers()))
            noCorrectAnswers++;
    }

    public List<ChosenAnswer> getChosenAnswers(){return this.chosenAnswers;}

    public float calculateScore(){
        return (float)noCorrectAnswers/questions.size();
    }
    public int getNoCorrectAnswers(){return this.noCorrectAnswers;}
}
