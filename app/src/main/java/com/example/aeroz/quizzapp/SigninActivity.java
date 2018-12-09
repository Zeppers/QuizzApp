package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aeroz.quizzapp.notActivities.Dialog;
import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.Teacher;
import com.example.aeroz.quizzapp.notActivities.Util;

public class SigninActivity extends AppCompatActivity {

    public EditText editTextEmail;
    public EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        editTextEmail = findViewById(R.id.edtText_signin_email);
        editTextPassword = findViewById(R.id.edtText_signin_password);
        editTextEmail.setText("petrecosmin16@stud.ase.ro");
        editTextPassword.setText("password1");
        Button button = findViewById(R.id.btn_signin_continue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                Student student;
                Teacher teacher;
                if(email.contains("@stud.ase.ro")){
                    if((student=Util.getStudentByEmail(email))!=null){
                        if(student.getPassword().equals(password))
                            startActivity(new Intent(SigninActivity.this,SHomeActivity.class).putExtra("student",student));
                        else Toast.makeText(SigninActivity.this,R.string.signintoastpassword,Toast.LENGTH_LONG).show();
                    }
                    else Toast.makeText(SigninActivity.this,R.string.signintoastemail,Toast.LENGTH_LONG).show();
                }
                else if(email.contains("@ie.ase.ro")){
                    if((teacher = Util.getTeacherByEmail(email))!=null){
                        if(teacher.getPassword().equals(password))
                            startActivity(new Intent(SigninActivity.this,PHomeActivity.class).putExtra("teacher",teacher));
                        else Toast.makeText(SigninActivity.this,R.string.signintoastpassword,Toast.LENGTH_LONG).show();
                    }
                    else Toast.makeText(SigninActivity.this,R.string.signintoastemail,Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(SigninActivity.this,R.string.signintoastinstitutional,Toast.LENGTH_LONG).show();
            }
        }

        );

    }

}
