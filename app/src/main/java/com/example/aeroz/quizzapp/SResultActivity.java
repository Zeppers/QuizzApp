package com.example.aeroz.quizzapp;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aeroz.quizzapp.notActivities.Creator;
import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.Student;
import com.google.android.gms.common.api.Response;

import org.json.JSONObject;



public class SResultActivity extends AppCompatActivity {
    private TextView txt_score;
    private TextView correctAns;
    private TextView wrongAns;
    private Student student;
    private Quiz quiz;
    private int noCorrect;
    private float score;
    private Button retry;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sresult);

        txt_score=findViewById(R.id.txtView_sresult_score);
        correctAns=findViewById(R.id.txtView_sresult_corectans);
        wrongAns=findViewById(R.id.txtView_sresult_wrongans);

        findViewById(R.id.btn_sresult_retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SResultActivity.this,SQuizPreviewActivity.class)
                .putExtra("student",student).putExtra("quiz",quiz)
                        .putExtra("creator",getIntent().getExtras().getSerializable("creator")));
            }
        });


        student=(Student)getIntent().getExtras().getSerializable("student");
        quiz=(Quiz)getIntent().getExtras().getSerializable("quiz");
        noCorrect=getIntent().getIntExtra("noCorrect",-1);
        score=getIntent().getFloatExtra("score",score);

       // score.setText(""+student.getTakenQuizes().get(student.getTakenQuizes().size()-1).getScore());
        txt_score.setText(String.valueOf(score));
        correctAns.setText(String.valueOf(noCorrect));
        wrongAns.setText(""+(quiz.getQuestions().size()-noCorrect));

        findViewById(R.id.btn_sresult_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SResultActivity.this,SHomeActivity.class).putExtra("student",student));
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
