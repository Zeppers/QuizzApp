package com.example.aeroz.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.TakenQuiz;
import com.example.aeroz.quizzapp.notActivities.Util;

public class SResultActivity extends AppCompatActivity {
    private TakenQuiz takenQuiz;
    private Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sresult);

        student = (Student)getIntent().getExtras().getSerializable("student");
        takenQuiz = Util.getTakenQuizById(getIntent().getExtras().getInt("takenQuizID"),student);
        Log.d("panda", "onCreate: "+student+"\n"+takenQuiz);
        Log.d("panda", "onCreate: "+takenQuiz.getRemainingTries());
    }
}
