package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.TakenQuiz;
import com.example.aeroz.quizzapp.notActivities.Util;

public class SQuizPreviewActivity extends AppCompatActivity {

    private Quiz quiz;
    private Student student;
    private TakenQuiz takenQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squiz_preview);

        quiz = (Quiz) getIntent().getExtras().getSerializable("quiz");
        student = (Student)getIntent().getExtras().getSerializable("student");
        ((ImageView)findViewById(R.id.imgView_squizpreview_ic_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SQuizPreviewActivity.this,SHomeActivity.class).putExtra("student",student));
            }
        });
        Button button = findViewById(R.id.btn_squizpreview_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Util.getTakenQuizById(quiz.getId(),student)==null){
                    takenQuiz = new TakenQuiz(quiz);
                    student.getTakenQuizes().add(takenQuiz);
                }
                else{
                    takenQuiz = Util.getTakenQuizById(quiz.getId(),student);
                }
                if(takenQuiz.getRemainingTries()!=0||Util.isDemoQuiz(takenQuiz)){
                    takenQuiz.setRemainingTries(takenQuiz.getRemainingTries()-1);
                    startActivity(new Intent(SQuizPreviewActivity.this,SQuestionActivity.class)
                            .putExtra("takenQuiz",takenQuiz).putExtra("student",student));
                }
                else Toast.makeText(SQuizPreviewActivity.this,R.string.shometries,Toast.LENGTH_LONG).show();
            }
        });

        ((TextView)findViewById(R.id.txtView_squizpreview_dynamic_quizname)).setText(quiz.getQuizName());
        ((TextView)findViewById(R.id.txtView_squizpreview_dynamic_creator)).setText(quiz.getCreator());
        ((TextView)findViewById(R.id.txtView_squizpreview_dynamic_timeq)).setText(""+quiz.getTime()/quiz.getQuestions().size());
        ((TextView)findViewById(R.id.txtView_squizpreview_dynamic_noq)).setText(""+quiz.getQuestions().size());
        ((TextView)findViewById(R.id.txtView_squizpreview_dynamic_description)).setText(quiz.getDescription());
    }
}
