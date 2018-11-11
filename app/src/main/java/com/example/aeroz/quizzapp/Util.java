package com.example.aeroz.quizzapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class Util extends AppCompatActivity {
    public void fireActivity(Activity activity1, Activity activity2){
        Intent intent = new Intent(activity1.getBaseContext(), activity2.getClass());
        startActivity(intent);
//        SO WRONG SO FUCKING WRONG WRONG WRONG
    }
}
