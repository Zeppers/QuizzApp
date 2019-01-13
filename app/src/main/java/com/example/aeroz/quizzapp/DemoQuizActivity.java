package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.aeroz.quizzapp.notActivities.Student;

public class DemoQuizActivity extends AppCompatActivity {

    ImageView ic_close;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_quiz);
        //INITIALIZE FIELDS///////////////////////////////////////////////////////

        ic_close=findViewById(R.id.imgView_demoquiz_ic_back);
        student = (Student)getIntent().getExtras().getSerializable("student");

        ic_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DemoQuizActivity.this,SHomeActivity.class).putExtra("student",student));
            }
        });

    }

}
