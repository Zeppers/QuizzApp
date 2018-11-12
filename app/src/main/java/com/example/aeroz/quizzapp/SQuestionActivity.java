package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SQuestionActivity extends AppCompatActivity {

    /////////////////TEMPORAR i
    public static int i = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squestion);


        final Button button = findViewById(R.id.btn_squestion_continue);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mytag123", "onClick: "+i);
                if(i>0){
                    startActivity(new Intent(getBaseContext(),SQuestionActivity.class));
                    i--;
                }
                else
                    startActivity(new Intent(getBaseContext(),SResultActivity.class));
            }
        });
    }
}
