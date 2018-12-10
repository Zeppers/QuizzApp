package com.example.aeroz.quizzapp.notActivities;

import android.widget.ListView;

import com.example.aeroz.quizzapp.SplashscreenActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quiz implements Serializable {
    protected int id;
    protected String quizName;
    protected String description;
    protected List<Question> questions = new ArrayList<>();
    protected int time;
    protected boolean active;
    protected boolean privat;
    protected long code;
    protected String creator;

    public Quiz(){}

    public Quiz(String quizName,String description, List<Question> questions, int time, boolean active, boolean privat, String creator){
        this.id = new Random().nextInt(9000)+1001;
        while(Util.IDExists(this.id,SplashscreenActivity.quizes)){
            this.id = new Random().nextInt(9000)+1001;
        }
        this.quizName = quizName;
        this.description = description;
        this.questions = questions;
        this.time = time;
        this.active = active;
        this.privat = privat;
        if(this.privat){
            this.code = new Random().nextInt(9000)+1001;
            while(Util.codeExists(this.code,SplashscreenActivity.quizes)){
                this.code = new Random().nextInt(9000)+1001;
            }
        }
        this.creator = creator;
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
    public int getId(){return this.id;}

    public boolean isPrivat(){return this.privat;}
    public void setPrivat(boolean value){this.privat = value;}

    public void addQuestion(Question q){this.questions.add(q);}

    public String getCreator(){return this.creator;}
    public void setCreator(String value){this.creator = value;}

    public String getDescription(){return this.description;}
    public void setDescription(String value){this.description =value;}

    public String toString(){return this.id+" "+this.description+" "+this.creator;}

    public void setId(int value){this.id = value;}
    public void setCode(int value){this.code = code;}
}
