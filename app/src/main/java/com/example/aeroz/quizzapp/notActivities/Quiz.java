package com.example.aeroz.quizzapp.notActivities;

import android.widget.ListView;

import com.example.aeroz.quizzapp.SplashscreenActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quiz {
    protected String quizName;
    protected List<Question> questions = new ArrayList<>();
    protected int time;
    protected boolean active;
    protected boolean privat;
    protected long code;

    public Quiz(){}

    public Quiz(String quizName, List<Question> questions, int time, boolean active, boolean privat){
        this.quizName = quizName;
        this.questions = questions;
        this.time = time;
        this.active = active;
        this.privat = privat;
        if(this.privat){
            this.code = new Random().nextInt(9000)+1001;
            while(SplashscreenActivity.codeExists(this.code,SplashscreenActivity.quizes)){
                this.code = new Random().nextInt(9000)+1001;
            }
        }
    }

    public String getQuizName(){return this.quizName;}
    public void setQuizName(String value){this.quizName = value;}

    public List<Question> getQuestions(){return this.questions;}
    public void setQuestions(List<Question> value){this.questions = value;}

    public int getTime(){return this.time;}
    public void setTime(int value){this.time = value;}

    public boolean isActive(){return this.active;}
    public void setActive(boolean value){this.active = value;}

    public float timePerQuestion(){return this.time/questions.size();}

    public long getCode(){return this.code;}

    public boolean isPrivat(){return this.privat;}
    public void setPrivat(boolean value){this.privat = value;}

    public void addQuestion(Question q){this.questions.add(q);}


}
