package com.example.aeroz.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.Student;


public class SQuizPreviewActivity extends AppCompatActivity {

    private Quiz quiz;
    private Student student;
    private String creatorName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squiz_preview);

        //Fields

        TextView quizName=findViewById(R.id.txtView_squizpreview_dynamic_quizname);
        TextView creator=findViewById(R.id.txtView_squizpreview_dynamic_creator);
        TextView quizTimePerQustion=findViewById(R.id.txtView_squizpreview_dynamic_timeq);
        TextView noQuestions=findViewById(R.id.txtView_squizpreview_dynamic_noq);
        TextView quizDescription=findViewById(R.id.txtView_squizpreview_dynamic_description);
        ImageView backIcon=findViewById(R.id.imgView_squizpreview_ic_back);

        quiz=(Quiz) getIntent().getExtras().getSerializable("quiz");
        student = (Student)getIntent().getExtras().getSerializable("student");

        quizName.setText(quiz.getName());
        quizTimePerQustion.setText(String.valueOf(quiz.getTime()/quiz.getQuestions().size()));
        noQuestions.setText(String.valueOf(quiz.getQuestions().size()));
        quizDescription.setText(String.valueOf(quiz.getDescription()));
        creator.setText("Pulifrici");

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    SQuizPreviewActivity.this.finish();
            }
        });

    }
}
