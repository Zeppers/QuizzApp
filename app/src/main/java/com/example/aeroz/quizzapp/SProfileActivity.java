package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aeroz.quizzapp.notActivities.QuizAdapter;
import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.TakenQuiz;
import com.example.aeroz.quizzapp.notActivities.TakenQuizAdapter;

import java.util.ArrayList;
import java.util.List;

public class SProfileActivity extends AppCompatActivity {

    private Student student;
    private ImageView ic_return;
    private TextView txt_avg_score;
    private TextView txt_quiz_history_no;
    private ListView list_quiz_history;
    private List<TakenQuiz> takenQuizes;

    private float total_score=0;
    private float avg_score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprofile);

        student = (Student)getIntent().getExtras().getSerializable("student");
        ic_return=findViewById(R.id.imgView_sprofile_ic_close);
        txt_avg_score=findViewById(R.id.txtView_sprofie_score);
        txt_quiz_history_no=findViewById(R.id.txtView_sprofile_quizhistory);
        list_quiz_history=findViewById(R.id.list_sprofile_quizhistory);
        takenQuizes=new ArrayList<>();

        if(student.getTakenQuizes().size()>0) {
            for(int i=0;i<student.getTakenQuizes().size();i++){
                Log.i("score", "onCreate: "+student.getTakenQuizes().get(i).getScore());
                total_score+=student.getTakenQuizes().get(i).getScore();
                takenQuizes.add(student.getTakenQuizes().get(i));
            }
        }
        avg_score=total_score/student.getTakenQuizes().size();

        txt_avg_score.setText(String.valueOf(avg_score)+"%");

        TakenQuizAdapter quizAdapter = new TakenQuizAdapter(SProfileActivity.this,android.R.layout.simple_list_item_2,takenQuizes);
        list_quiz_history.setAdapter(quizAdapter);

        ic_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SProfileActivity.this,SHomeActivity.class).putExtra("student",student));
            }
        });

        txt_quiz_history_no.setText("Quiz history ( "+String.valueOf(student.getTakenQuizes().size())+" taken by now )");
        findViewById(R.id.btn_sprofile_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SProfileActivity.this,SigninActivity.class));
            }
        });
    }


}
