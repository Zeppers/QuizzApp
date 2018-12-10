package com.example.aeroz.quizzapp.notActivities;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Reader extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        List<Quiz> quizes = new ArrayList<>();
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            content = new StringBuilder();
            String line = "";

            while((line=bufferedReader.readLine())!=null){
                content.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
