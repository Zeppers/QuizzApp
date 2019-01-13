package com.example.aeroz.quizzapp;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aeroz.quizzapp.notActivities.EmailPassword;
import com.example.aeroz.quizzapp.notActivities.HttpRequestMaker;
import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.Teacher;
import com.google.gson.Gson;

public class SigninActivity extends AppCompatActivity {

    public EditText editTextEmail;
    public EditText editTextPassword;
    public HttpRequestMaker httpRequestMaker;
    public Button button;
    public EmailPassword emailPassword;
    public String email;
    public String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        editTextEmail = findViewById(R.id.edtText_signin_email);
        editTextPassword = findViewById(R.id.edtText_signin_password);
        button = findViewById(R.id.btn_signin_continue);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextEmail.setText("petrecosmin@stud.ase.ro");
                editTextPassword.setText("pass100");
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextEmail.setText("zamfirescucatalin@prof.ase.ro");
                editTextPassword.setText("pass001");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();
                emailPassword = new EmailPassword(email,password);

                if(email.contains("@stud.ase.ro")){
                    httpRequestMaker = new HttpRequestMaker(){
                        @Override
                        public void onPostExecute(String s){
                            Student student = new Gson().fromJson(s,Student.class);
                            startActivity(new Intent(SigninActivity.this,SHomeActivity.class).putExtra("student",student));
                        }
                    };
                    httpRequestMaker.execute("POST","http://188.25.199.62:8000/login/student",new Gson().toJson(emailPassword));
                }
                else if(email.contains("@prof.ase.ro")){
                    httpRequestMaker = new HttpRequestMaker(){
                        @Override
                        public void onPostExecute(String s){
                            Teacher teacher = new Gson().fromJson(s,Teacher.class);
                            startActivity(new Intent(SigninActivity.this,PHomeActivity.class).putExtra("teacher",teacher));
                        }
                    };
                    httpRequestMaker.execute("POST","http://188.25.199.62:8000/login/teacher",new Gson().toJson(emailPassword));
                }
                else{
                    Toast.makeText(SigninActivity.this,R.string.signintoastinstitutional,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
