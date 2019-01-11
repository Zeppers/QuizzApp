package com.example.aeroz.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SigninActivity extends AppCompatActivity {

    public EditText editTextEmail;
    public EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        editTextEmail = findViewById(R.id.edtText_signin_email);
        editTextPassword = findViewById(R.id.edtText_signin_password);


    }

}
