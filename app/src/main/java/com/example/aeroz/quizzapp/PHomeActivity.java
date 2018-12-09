package com.example.aeroz.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.Teacher;

public class PHomeActivity extends AppCompatActivity {
    public Teacher teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phome);

        //TextView txtView_createQuiz = findViewById(R.id.txtView_createQuiz);
        TextView txtView_publicQuizzes = findViewById(R.id.txtView_publicquiz);

        teacher = (Teacher) getIntent().getExtras().getSerializable("teacher");
        Log.d("pandateacher", "onCreate: "+teacher);
    }
}
