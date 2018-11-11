package com.example.aeroz.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phome);

        TextView txtView_createQuiz = findViewById(R.id.txtView_createQuiz);
        TextView txtView_publicQuizzes = findViewById(R.id.txtView_publicquiz);
    }
}
