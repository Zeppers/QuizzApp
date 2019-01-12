package com.example.aeroz.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.Teacher;

import java.util.List;

public class PPrivateActivity extends AppCompatActivity {

    private Teacher teacher;
    private List<Quiz> privateQuizes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pprivate);

    }
}
