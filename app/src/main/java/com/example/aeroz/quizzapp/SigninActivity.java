package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SigninActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        final EditText editTextEmail = findViewById(R.id.edtText_signin_email);
        final EditText editTextPassword = findViewById(R.id.edtText_signin_password);
        Button button = findViewById(R.id.btn_signin_continue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextEmail.getText().toString().contains("stud"))
                    startActivity(new Intent(getBaseContext(),SHomeActivity.class));
                else
                    startActivity(new Intent(getBaseContext(),PHomeActivity.class));
            }
        });
    }
}
