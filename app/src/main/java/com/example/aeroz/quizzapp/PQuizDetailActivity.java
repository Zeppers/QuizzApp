package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aeroz.quizzapp.notActivities.HttpRequestMaker;
import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.TakenQuizDB;
import com.example.aeroz.quizzapp.notActivities.Teacher;
import com.google.gson.Gson;

public class PQuizDetailActivity extends AppCompatActivity {

    private Quiz quiz;
    private TextView quiz_name;
    private TextView quiz_code;
    private TextView quiz_description;
    private TextView quiz_time_question;
    private TextView quiz_no_questions;
    private TextView quiz_no_commits;
    private ImageView ic_back;
    private Teacher teacher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pquiz_detail);

        quiz=(Quiz)getIntent().getExtras().getSerializable("quiz");
        teacher=(Teacher)getIntent().getExtras().getSerializable("teacher");

        quiz_name=findViewById(R.id.txtView_pquizdetail_quizname_dynamic);
        quiz_code=findViewById(R.id.txtView_pquizdetail_quizname_dynamic2);
        quiz_description=findViewById(R.id.txtView_pquizdetail_description_dynamic);
        quiz_time_question=findViewById(R.id.txtView_pquizdetail_timeperquestion_dynamic);
        quiz_no_questions=findViewById(R.id.txtView_pquizdetail_noquestions_dynamic);
        quiz_no_commits=findViewById(R.id.txtView_pquizdetail_statistics_nocommints_dynamic);
        ic_back=findViewById(R.id.ic_pquizdetail_back);


        new HttpRequestMaker(){
            @Override
            public void onPostExecute(String s)
            {
                int n=new Gson().fromJson(s,TakenQuizDB[].class).length;
                Log.d("lungime", "onPostExecute: "+n);
                quiz_name.setText(quiz.getName());
                quiz_code.setText(String.valueOf(quiz.getCode()));
                quiz_description.setText(quiz.getDescription());
                quiz_time_question.setText(String.valueOf(quiz.getTime()/quiz.getQuestions().size()));
                quiz_no_questions.setText(String.valueOf(quiz.getQuestions().size()));
                quiz_no_commits.setText(String.valueOf(n));
            }
        }.execute("GET","http://188.25.199.62:8000/takenQuizes/?quizId="+quiz.getId());

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PQuizDetailActivity.this,PHomeActivity.class).putExtra("quiz",quiz).putExtra("teacher",teacher));
            }
        });


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {

        }

        return super.onKeyDown(keyCode, event);
    }
}
