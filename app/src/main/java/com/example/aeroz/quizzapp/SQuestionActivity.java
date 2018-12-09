package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.aeroz.quizzapp.notActivities.Quiz;

public class SQuestionActivity extends AppCompatActivity {

    private Quiz quiz;
    private Button button;
    private int currentQuestion = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squestion);


        button = findViewById(R.id.btn_squestion_continue);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SQuestionActivity.this,SResultActivity.class));
            }
        });
    }
}
