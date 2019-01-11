package com.example.aeroz.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class SHomeActivity extends AppCompatActivity {
    private ListView listView;
    private EditText editText;
    private TextView whyNeedCode;
    private Button demoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shome);

    }

}