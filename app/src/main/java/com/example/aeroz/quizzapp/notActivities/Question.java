package com.example.aeroz.quizzapp.notActivities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {
    private int id;
    private String text;
    private List<Answer> answers = new ArrayList<>();

    public Question(int id, String text){
        this.id = id;
        this.text = text;
    }
    public Question(int id, String text,List<Answer> answers){
        this.id = id;
        this.text = text;
        this.answers = answers;
    }
    public int getId(){return this.id;}
    public String getText(){return this.text;} public void setText(String value){this.text = value;}
    public List<Answer> getAnswers(){return this.answers;} public void setAnswers(List<Answer> value){this.answers = value;}


    public String toString(){
        StringBuilder answers = new StringBuilder();
        for(Answer a:this.answers){
            answers.append(a);
        }
        return "id:"+this.id+" text:"+this.text+" answers:"+answers.toString();
    }
}
