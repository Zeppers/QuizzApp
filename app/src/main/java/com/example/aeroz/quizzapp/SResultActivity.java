package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.TakenQuiz;
import com.example.aeroz.quizzapp.notActivities.Util;

public class SResultActivity extends AppCompatActivity {
    private TakenQuiz takenQuiz;
    private Student student;
    private TextView score;
    private TextView correctAns;
    private TextView wrongAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sresult);

        student = (Student)getIntent().getExtras().getSerializable("student");
        takenQuiz = Util.getTakenQuizById(getIntent().getExtras().getInt("takenQuizID"),student);
        score = findViewById(R.id.txtView_sresult_score);
        correctAns = findViewById(R.id.txtView_sresult_corectans);
        wrongAns = findViewById(R.id.txtView_sresult_wrongans);
        score.setText(""+(takenQuiz.calculateScore()*100)+"%");
        correctAns.setText(""+takenQuiz.getNoCorrectAnswers());
        wrongAns.setText(""+(takenQuiz.getQuestions().size()-takenQuiz.getNoCorrectAnswers()));

        findViewById(R.id.btn_sresult_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takenQuiz.setRemainingTries(0);
                startActivity(new Intent(SResultActivity.this,SHomeActivity.class).putExtra("student",student));
            }
        });
        findViewById(R.id.btn_sresult_retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(takenQuiz.getRemainingTries()!=0||Util.isDemoQuiz(takenQuiz)) {
                    if(!(Util.isDemoQuiz(takenQuiz)))
                    startActivity(new Intent(SResultActivity.this, SQuizPreviewActivity.class)
                            .putExtra("student", student).putExtra("quiz", Util.getQuizById(takenQuiz.getId())));
                    else
                        startActivity(new Intent(SResultActivity.this, SQuizPreviewActivity.class)
                                .putExtra("student", student).putExtra("quiz", Util.getDemoQuizById(takenQuiz.getId())));
                }
                else Toast.makeText(SResultActivity.this,R.string.shometries,Toast.LENGTH_LONG).show();
            }
        });

        Log.d("panda", "onCreate: "+student+"\n"+takenQuiz);
        Log.d("panda", "onCreate: "+takenQuiz.getRemainingTries());
    }
}
