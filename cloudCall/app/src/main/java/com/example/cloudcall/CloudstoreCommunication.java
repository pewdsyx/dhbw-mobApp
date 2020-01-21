package com.example.cloudcall;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CloudstoreCommunication extends AsyncTask<String, Integer, String> {

    @Override
    protected String doInBackground(String... strings) {

        try {
            URL url = new URL(strings[0]);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = null;
            String response = "";
            do {
                line = bufferedReader.readLine();
                if (line != null) {
                    response += line;
                }
            } while (line != null);

            //System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String aResponse) {
        // access to UI and all views
        try {
            JSONArray jsonArray = new JSONArray(aResponse);

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                System.out.println(jsonObject.getString("key"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
