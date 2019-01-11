package com.example.aeroz.quizzapp.notActivities;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequestMaker extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        StringBuilder response=new StringBuilder();
        try {
            String line="";
            URL url = new URL(strings[1]);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            if(strings[0]=="GET"){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                response = new StringBuilder();
                while((line=bufferedReader.readLine())!=null)
                    response.append(line);
            }
            else{
                connection.setRequestMethod(strings[0]);
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setRequestProperty("Content-Type","application/json");

                if(strings[1].contains("login")){
                    OutputStream outputStream = connection.getOutputStream();
                    outputStream.write(strings[2].toString().getBytes("UTF-8"));

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    response = new StringBuilder();
                    while((line=bufferedReader.readLine())!=null)
                        response.append(line);
                }
                else{
                    OutputStream outputStream = connection.getOutputStream();
                    outputStream.write(strings[2].toString().getBytes("UTF-8"));
                    response = new StringBuilder(connection.getResponseMessage());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
