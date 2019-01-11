package com.example.aeroz.quizzapp.notActivities;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Quiz implements Serializable {
    protected int id;
    protected String name;
    protected String description;
    protected int time;
    protected boolean active;
    protected boolean privat;
    protected int code;
    protected List<Question> questions;

    public Quiz(){}

    public Quiz(int id, String name, String description, int time, boolean active, boolean privat, int code){
        this.id = id;
        this.name = name;
        this.description = description;
        this.time = time;
        this.active = active;
        this.privat = privat;
        this.code = code;
    }
    public Quiz(int id, String name, String description, int time, boolean active, boolean privat, int code, List<Question> questions){
        this.id = id;
        this.name = name;
        this.description = description;
        this.time = time;
        this.active = active;
        this.privat = privat;
        this.code = code;
        this.questions = questions;
    }

    public int getId(){return this.id;}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isPrivat() {
        return privat;
    }

    public void setPrivat(boolean privat) {
        this.privat = privat;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public static Quiz retrieveFromJSONString(String s){
        Quiz quiz = null;
        Gson gson = new Gson();
        quiz = gson.fromJson(s,Quiz.class);

        return quiz;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Question q:this.questions)
            sb.append(q);
        return "id:"+this.id+" name:"+this.name+" description:"+this.description+" time:"+this.time+" active:"+this.active+" privat:"+this.privat+" code:"+ this.code+" questions:"+sb.toString();
    }

}
