package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.Teacher;

public class SigninActivity extends AppCompatActivity {

    public EditText editTextEmail;
    public EditText editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        editTextEmail = findViewById(R.id.edtText_signin_email);
        editTextPassword = findViewById(R.id.edtText_signin_password);

        Button button = findViewById(R.id.btn_signin_continue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if(username.contains("@stud.ase.ro")){
                    for(Student s:SplashscreenActivity.students){
                        if(s.getEmail().equals(username)){
                            if(s.getPassword().equals(password)){
                                startActivity(new Intent(SigninActivity.this,SHomeActivity.class).putExtra("student",s));
                                break;
                            }
                            //else password incorrect
                        }
                        //else doesnt exist
                    }


                }
                else if(username.contains("@ie.ase.ro")){
                    for(Teacher t:SplashscreenActivity.teachers){
                        if(t.getEmail().equals(username)){
                            if(t.getPassword().equals(password)){
                                startActivity(new Intent(SigninActivity.this,PHomeActivity.class).putExtra("teacher",t));
                                break;
                            }
                            //else password incorrect
                        }
                        //else doesnt exist
                    }
                }
                //else input incorect
            }
        });
    }
}
