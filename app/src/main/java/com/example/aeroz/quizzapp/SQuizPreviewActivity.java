package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aeroz.quizzapp.notActivities.Creator;
import com.example.aeroz.quizzapp.notActivities.HttpRequestMaker;
import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.TakenQuiz;
import com.example.aeroz.quizzapp.notActivities.TakenQuizDB;
import com.google.gson.Gson;

import org.json.JSONObject;


public class SQuizPreviewActivity extends AppCompatActivity {

    private Quiz quiz;
    private Student student;
    private String creatorName;
    private TakenQuizDB takenQuizDB;
    private TextView textViewCreator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squiz_preview);

        //Fields

        TextView quizName=findViewById(R.id.txtView_squizpreview_dynamic_quizname);
        TextView quizTimePerQustion=findViewById(R.id.txtView_squizpreview_dynamic_timeq);
        TextView noQuestions=findViewById(R.id.txtView_squizpreview_dynamic_noq);
        TextView quizDescription=findViewById(R.id.txtView_squizpreview_dynamic_description);
        ImageView backIcon=findViewById(R.id.imgView_squizpreview_ic_back);
        textViewCreator = findViewById(R.id.txtView_squizpreview_dynamic_creator);
        quiz=(Quiz) getIntent().getExtras().getSerializable("quiz");
        student = (Student)getIntent().getExtras().getSerializable("student");
        Log.d("ehehe", "onCreate: "+student);

        quizName.setText(quiz.getName());
        quizTimePerQustion.setText(String.valueOf(quiz.getTime()/quiz.getQuestions().size()));
        noQuestions.setText(String.valueOf(quiz.getQuestions().size()));
        quizDescription.setText(String.valueOf(quiz.getDescription()));

        Creator creator = (Creator)getIntent().getExtras().getSerializable("creator");
        textViewCreator.setText(creator.getCreator());

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    SQuizPreviewActivity.this.finish();
            }
        });
        findViewById(R.id.btn_squizpreview_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HttpRequestMaker(){
                    @Override
                    public void onPostExecute(String s){
                        TakenQuizDB[] takenQuizes = new Gson().fromJson(s,TakenQuizDB[].class);
                        if(takenQuizes.length!=0){
                            takenQuizDB = takenQuizes[0];
                            Log.d("testolini", "onPostExecute: "+takenQuizDB);
                            if(takenQuizDB.getRemainingTries()!=0){
                                takenQuizDB.takeTry();
                                new HttpRequestMaker().execute("POST","http://188.25.199.62:8000/takenQuizes",new Gson().toJson(takenQuizDB));
                                startActivity(new Intent(SQuizPreviewActivity.this,SQuestionActivity.class)
                                        .putExtra("student",student).putExtra("quiz",quiz).putExtra("takenQuizDB",takenQuizDB));
                            }
                            else{
                                Toast.makeText(SQuizPreviewActivity.this,R.string.shometries,Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            new HttpRequestMaker().execute("POST","http://188.25.199.62:8000/takenQuizes",new Gson()
                                    .toJson(new TakenQuizDB(0,2,student.getId(),quiz.getId())));
                        }

                    }
                }.execute("GET","http://188.25.199.62:8000/takenQuizes/?studentId="+student.getId()+"&quizId="+quiz.getId());
            }
        });

    }
}
