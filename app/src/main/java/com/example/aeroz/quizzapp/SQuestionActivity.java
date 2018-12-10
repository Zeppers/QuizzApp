package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aeroz.quizzapp.notActivities.ChosenAnswer;
import com.example.aeroz.quizzapp.notActivities.Question;
import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.TakenQuiz;
import com.example.aeroz.quizzapp.notActivities.Util;

import java.util.List;

public class SQuestionActivity extends AppCompatActivity {

    private Student student;
    private Button button;
    private int currentQuestion = 1;
    private TextView textViewNoQuestion;
    private TextView textViewQuestion;
    private TextView[] textViewsAnswers;
    private TakenQuiz takenQuiz;
    private boolean[] answer = new boolean[4];
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
        takenQuiz = (TakenQuiz)getIntent().getExtras().getSerializable("takenQuiz");
        //////////////////////////////////////////////////////////////////
        textViewsAnswers[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer[0]=!answer[0];
                if(answer[0])
                    textViewsAnswers[0].setTextColor(getResources().getColor(R.color.aqua));
                else
                    textViewsAnswers[0].setTextColor(getResources().getColor(R.color.white));
            }
        });
        textViewsAnswers[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer[1]=!answer[1];
                if(answer[1])
                    textViewsAnswers[1].setTextColor(getResources().getColor(R.color.aqua));
                else
                    textViewsAnswers[1].setTextColor(getResources().getColor(R.color.white));
            }
        });
        textViewsAnswers[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer[2]=!answer[2];
                if(answer[2])
                    textViewsAnswers[2].setTextColor(getResources().getColor(R.color.aqua));
                else
                    textViewsAnswers[2].setTextColor(getResources().getColor(R.color.white));
            }
        });
        textViewsAnswers[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer[3]=!answer[3];
                if(answer[3])
                    textViewsAnswers[3].setTextColor(getResources().getColor(R.color.aqua));
                else
                    textViewsAnswers[3].setTextColor(getResources().getColor(R.color.white));
            }
        });
        textViewNoQuestion.setText(""+1+"/"+takenQuiz.getQuestions().size());
        textViewQuestion.setText(takenQuiz.getQuestions().get(0).getQuestionText());
        for(int i = 0;i<4;i++)
            textViewsAnswers[i].setText(""+(char)(65+i)+")"+takenQuiz.getQuestions().get(0).getAnswers()[i]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                takenQuiz.chooseAnswers(Util.getQuestionByQuestionText(textViewQuestion.getText().toString(),takenQuiz.getQuestions()),getChosenAnswer().getChosenAnswers());
                if(currentQuestion<takenQuiz.getQuestions().size()) {
                    if(Util.arraysEqual(getChosenAnswer().getChosenAnswers(),Util.getQuestionByQuestionText(textViewQuestion.getText().toString(),takenQuiz.getQuestions()).getCorrectAnswers()))
                        Log.d("panda", "onClick: "+"corect!");
                    else
                        Log.d("panda", "onClick: "+"gresit!");
                    ResetQuestion();
                }
                else{
                    startActivity(new Intent(SQuestionActivity.this,SResultActivity.class).putExtra("student",student).putExtra("takenQuizID",takenQuiz.getId()));
                }
            }
        });
    }
    public void ResetQuestion(){
        textViewNoQuestion.setText("" + (++currentQuestion) + "/" + takenQuiz.getQuestions().size());
        textViewQuestion.setText(takenQuiz.getQuestions().get(currentQuestion - 1).getQuestionText());
        for (int i = 0; i < 4; i++)
            textViewsAnswers[i].setText(""+(char)(65+i)+")"+takenQuiz.getQuestions().get(currentQuestion - 1).getAnswers()[i]);
        for(int i = 0;i<answer.length;i++){
            answer[i] = false;
            textViewsAnswers[i].setTextColor(getResources().getColor(R.color.white));
        }
    }
    public ChosenAnswer getChosenAnswer(){
        int noSelected=0;
        int nr=0;
        for(int i = 0;i<answer.length;i++)
            if(answer[i])
                noSelected++;
        int[] chosenAnswer = new int[noSelected];
        for(int k = 0;k<answer.length;k++){
            if(answer[k]){
                chosenAnswer[nr] = k;
                nr++;
            }
        }
        return new ChosenAnswer(Util.getQuestionByQuestionText(textViewQuestion.getText().toString(),takenQuiz.getQuestions()),chosenAnswer);
    }
}
