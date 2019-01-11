package com.example.aeroz.quizzapp.notActivities;

import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Answer implements Serializable {
    private int id;
    private String text;
    private boolean isCorrect;
    public Answer(){}
    public Answer(int id, String text, boolean isCorrect){
        this.id = id;
        this.text = text;
        this.isCorrect = isCorrect;
    }
    public int getId(){return this.id;}
    public String getText(){return this.text;} public void setText(String value){this.text = value;}
    public boolean getIsCorect(){return this.isCorrect;} public void setIsCorrect(boolean value){this.isCorrect = value;}

    public String toString(){
        return "id:"+this.id+" "+"text:"+this.text+" "+"isCorrect:"+this.isCorrect;
    }

    public static Answer retrieveFromJSONString(String s){
        JSONObject json = null;
        Answer answer = null;
        try {
            json = new JSONObject(s);
            answer = new Answer(json.getInt("id"),json.getString("text"),json.getBoolean("isCorrect"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return answer;
    }
    public static List<Answer> retrieveAnswersListFromJSONString(String s){
        JSONObject json = null;
        List<Answer> answers = new ArrayList<>();
        try{
            json = new JSONObject(s);
            JSONArray jsonArray = json.getJSONArray("answers");
            for(int i =0;i<jsonArray.length();i++){
                JSONObject obj = (JSONObject)jsonArray.get(i);
                answers.add(new Answer(obj.getInt("id"),obj.getString("text"),obj.getBoolean("isCorrect")));
            }
        }
        catch(JSONException e){
            e.printStackTrace();
        }
        return answers;
    }
}
