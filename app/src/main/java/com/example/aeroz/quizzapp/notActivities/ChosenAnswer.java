package com.example.aeroz.quizzapp.notActivities;

import java.io.Serializable;

public class ChosenAnswer implements Serializable {
    private Question question;
    private int[] chosenAnswers;

    public ChosenAnswer(Question question, int[] chosenAnswers){
        this.question = question;
        this.chosenAnswers = chosenAnswers;
    }
    public String toString(){
        String array = "";
        for(int i = 0;i<chosenAnswers.length;i++)
            array+=chosenAnswers[i]+",";
        return this.question.getQuestionText()+array;
    }

    public Question getQuestion(){return this.question;}
    public int[] getChosenAnswers(){return this.chosenAnswers;}
}
