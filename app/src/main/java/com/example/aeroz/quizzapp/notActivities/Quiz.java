package com.example.aeroz.quizzapp.notActivities;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String quizName;
    private List<Question> questions = new ArrayList<>();


    public Quiz(String quizName, List<Question> questions){
        this.quizName = quizName;
        for(Question q:questions)
            questions.add(q);
    }

    public String getQuizName(){return this.quizName;}
    public void setQuizName(String value){this.quizName = value;}

    public List<Question> getQuestions(){return this.questions;}
    public void setQuestions(List<Question> value){this.questions = value;}

    public void addQuestion(Question q){this.questions.add(q);}
}
