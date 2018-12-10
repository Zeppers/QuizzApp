package com.example.aeroz.quizzapp.notActivities;

import java.io.Serializable;

public class Question implements Serializable {
    private String questionText;
    private String[] answers;
    private int[] correctAnswers;

    public Question(String questionText, String[] answers, int[] correctAnswers){
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswers = correctAnswers;
    }

    public String getQuestionText(){return this.questionText;}
    public void setQuestionText(String value){this.questionText = value;}

    public String[] getAnswers(){return this.answers;}
    public void setAnswers(String[] value){this.answers = value;}

    public int[] getCorrectAnswers(){return this.correctAnswers;}
    public void setCorrectAnswers(int[] value){this.correctAnswers = value;}

    public String toString(){
        String answers="";
        String correctAnswers="";
        for(int i = 0;i<this.answers.length;i++)
            answers+=this.answers[i]+" ";
        for(int i =0;i<this.correctAnswers.length;i++)
            correctAnswers+=this.correctAnswers[i];
        return questionText+" "+answers+" "+correctAnswers;
    }
}
