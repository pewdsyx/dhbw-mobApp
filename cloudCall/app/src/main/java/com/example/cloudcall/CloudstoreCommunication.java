package com.example.cloudcall;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CloudstoreCommunication extends AsyncTask<String, Integer, String> {

    @Override
    protected String doInBackground(String... strings) {

        try {
            URL url = new URL("https://webtechlecture.appspot.com/cloudstore/listkeys?owner=maxi");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = null;
            String response = "";
            do {
                line = bufferedReader.readLine();
                if (line != null) {
                    response += line;
                }
            } while (line != null);

            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
