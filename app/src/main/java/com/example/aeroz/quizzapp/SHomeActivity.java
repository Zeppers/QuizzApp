package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.aeroz.quizzapp.notActivities.Student;

public class SHomeActivity extends AppCompatActivity {
    public Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shome);

        ImageView imageView = findViewById(R.id.ic_shome_profile);
        Button button = findViewById(R.id.btn_shome_continue);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        student = (Student)getIntent().getExtras().getSerializable("student");
        Log.d("pandastudent", "onCreate: "+student);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SHomeActivity.this,SQuizPreviewActivity.class));
            }
        });
    }
}
