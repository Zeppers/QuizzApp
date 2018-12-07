package com.example.aeroz.quizzapp.notActivities;

public class ChosenAnswer {
    public Question question;
    public int[] chosenAnswers;

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
}
