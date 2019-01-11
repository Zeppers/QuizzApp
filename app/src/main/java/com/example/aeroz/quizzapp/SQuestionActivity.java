package com.example.aeroz.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SQuestionActivity extends AppCompatActivity {

    private Button button;
    private TextView textViewNoQuestion;
    private TextView textViewQuestion;
    private TextView[] textViewsAnswers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squestion);


    }
}
