package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.Student;

public class SQuestionActivity extends AppCompatActivity {

    private Quiz quiz;
    private Student student;
    private Button button;
    private int currentQuestion = 1;
    private TextView textViewNoQuestion;
    private TextView textViewQuestion;
    private TextView[] textViewsAnswers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squestion);

        //INITIALIZING FIELDS////////////////////////////////////////////
        button = findViewById(R.id.btn_squestion_continue);
        textViewNoQuestion = findViewById(R.id.txtView_squestion_noquestion);
        textViewQuestion = findViewById(R.id.txtView_squestion_question);
        textViewsAnswers = new TextView[4];
        textViewsAnswers[0] = findViewById(R.id.txtView_squestion_ans1);
        textViewsAnswers[1] = findViewById(R.id.txtView_squestion_ans2);
        textViewsAnswers[2] = findViewById(R.id.txtView_squestion_ans3);
        textViewsAnswers[3] = findViewById(R.id.txtView_squestion_ans4);
        student = (Student)getIntent().getExtras().getSerializable("student");
        quiz = (Quiz)getIntent().getExtras().getSerializable("quiz");
        //////////////////////////////////////////////////////////////////

        textViewNoQuestion.setText(""+1+"/"+quiz.getQuestions().size());
        textViewQuestion.setText(quiz.getQuestions().get(0).getQuestionText());
        for(int i = 0;i<4;i++)
            textViewsAnswers[i].setText(""+(char)(65+i)+")"+quiz.getQuestions().get(0).getAnswers()[i]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestion<quiz.getQuestions().size()) {
                    textViewNoQuestion.setText("" + (++currentQuestion) + "/" + quiz.getQuestions().size());
                    textViewQuestion.setText(quiz.getQuestions().get(currentQuestion - 1).getQuestionText());
                    for (int i = 0; i < 4; i++)
                        textViewsAnswers[i].setText(""+(char)(65+i)+")"+quiz.getQuestions().get(currentQuestion - 1).getAnswers()[i]);
                }
            }
        });
    }
}
