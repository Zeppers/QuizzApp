package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.aeroz.quizzapp.notActivities.Answer;
import com.example.aeroz.quizzapp.notActivities.HttpRequestMaker;
import com.example.aeroz.quizzapp.notActivities.Question;
import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.QuizDB;
import com.example.aeroz.quizzapp.notActivities.Reader;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class SplashscreenActivity extends AppCompatActivity {


    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);


        Answer answer1 = new Answer(100,"text100",true);
        Answer answer2 = new Answer(101,"text101",false);
        Answer answer3 = new Answer(102,"text102",false);
        Answer answer4 = new Answer(103,"text103",true);
        List<Answer> answers = new ArrayList<>();
        answers.add(answer1);answers.add(answer2);answers.add(answer3);answers.add(answer4);
        List<Question> questions = new ArrayList<>();
        Question question1 = new Question(100,"text100",answers);
        Quiz quiz = new Quiz(1,"nameeee","desssc",1200,true,true,1212,questions);

//        HttpRequestMaker httpRequestMaker = new HttpRequestMaker(){
//            @Override
//            protected  void onPostExecute(String s){
//                quiz = new Gson().fromJson(s,Quiz.class);
//                Log.d("panda", "onPostExecute: "+quiz);
//
//                String str = gson.toJson(quiz);
//                Log.d("pandas", "onPostExecute: "+str);
//
//            }
//        };
//        httpRequestMaker.execute("GET","http://188.25.199.62:8000/quizes/1");

        String quizDB = gson.toJson(new QuizDB(quiz.getId(),quiz.getName(),quiz.getDescription(),quiz.getTime(),quiz.isActive(),quiz.isPrivat(),quiz.getCode(),2));
        HttpRequestMaker httpRequestMaker2 = new HttpRequestMaker(){
            @Override
            protected  void onPostExecute(String s){

                Quiz q = gson.fromJson(s,Quiz.class);
                Log.d("panda", "onPostExecute: "+q);

            }
        };

        httpRequestMaker2.execute("POST","http://188.25.199.62:8000/quizes/1",gson.toJson(quiz));

        Thread thread = new Thread(){
            @Override

            public void run() {
                try{
                    sleep(1500);
                    Intent i = new Intent(getApplicationContext(),OnboardingActivity.class);
                    startActivity(i);
                    }
                    catch(Exception e){}
                    }
                };

        thread.start();
    }


}
