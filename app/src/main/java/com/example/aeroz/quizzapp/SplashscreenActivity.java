package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.aeroz.quizzapp.notActivities.Question;
import com.example.aeroz.quizzapp.notActivities.Quiz;

import java.util.ArrayList;
import java.util.List;

public class SplashscreenActivity extends AppCompatActivity {
    public static List<Quiz> quizes = new ArrayList<>();
    public static List<Question> questions1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        questions1.add(new Question("Who was the first american in space?",new String[]{"Alan Shepard","Donald Trump","Marizio Tutti","Mariah Carey"},new int[]{0}));
        questions1.add(new Question("Which planet is nearest the sun",new String[]{"the Moon","Jupiter","Venus","Mercur"},new int[]{3}));
        questions1.add(new Question("Which devide was invented by Henry Mill", new String[]{"metal dildo","toothbrush","pen","typewriter"},new int[]{3}));
        questions1.add(new Question("Which unit indicate the light intensity?",new String[]{"bar","ohm","amper","candela"},new int[]{3}));
        Quiz q = new Quiz("Science",questions1,240,true,true);
        quizes.add(q);
        Log.d("codul nostru este: :)",""+q.getCode());

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

    public static boolean codeExists(long code,List<Quiz> list){
        for(Quiz q:list)
            if(code==q.getCode())
                return true;
        return false;
    }
}
