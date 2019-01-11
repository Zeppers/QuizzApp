package com.example.aeroz.quizzapp;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.common.api.Response;

import org.json.JSONObject;



public class SResultActivity extends AppCompatActivity {
    private TextView score;
    private TextView correctAns;
    private TextView wrongAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sresult);



    }
}
