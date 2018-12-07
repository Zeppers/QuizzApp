package com.example.aeroz.quizzapp.notActivities;

public class Question {
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
}
