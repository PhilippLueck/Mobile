package com.philipplueck.twitterapp;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by PhilippLueck on 21.12.2017.
 */


public class Hilfsklasse  extends AsyncTask<String,Integer,String> {

String a;
    protected void onPostExecute(String s) {


        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(s);
            s="";
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject tweet = jsonArray.getJSONObject(i);

                s = s +  "Nachricht"+(i+1)+": " +tweet.get("text") + "\n";}

                a= a+s;
        } catch (JSONException e) {
            e.printStackTrace();
        }
       // System.out.println("Nachricht 1: " + s);

        MainActivity main = new MainActivity();
        main.textaendern(a);


    }




    //wird in Cloud thread ausgehührt
    @Override
    protected String doInBackground(String... urls) {
        String jasonString = "";
        for (String urlString : urls) {

            try {
                URL url = new URL(urlString);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = "";

                JSONArray jsonArray = new JSONArray();
                while ((line = reader.readLine()) != null) {
                    //System.out.println("line=" + line);
                    jasonString = jasonString + line;

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();


            }


        } return jasonString;
    }
    public String senden(String s){
       return doInBackground( s);
    }
}