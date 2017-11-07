package com.example.kin.millionaire;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Displaymillion extends AppCompatActivity {
    TextView t1, t2, t3, t4, t5;
    String name;
    String name1="No user get 1000000";
    String name2="No user get 1000000";
    String name3="No user get 1000000";
    String name4="No user get 1000000";
    String name5="No user get 1000000";
    String type = "displaymillion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaymillion);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("username");
        t1 = (TextView) findViewById(R.id.textView1);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);
        t5 = (TextView) findViewById(R.id.textView5);
        new localBackgroundWorker(Displaymillion.this).execute(type, name);
    }

    private class localBackgroundWorker extends AsyncTask<String, Void, String> {
        Context context;

        localBackgroundWorker(Context ctx) {
            context = ctx;
        }

        @Override
        protected String doInBackground(String... params) {
            String type = params[0];
            String displaymillion_url = "https://leungwaikin.000webhostapp.com/ranking.php";

            if (type.equals("displaymillion")) {
                try {
                    URL url = new URL(displaymillion_url);
                    String username = params[1];
                    System.out.print(username);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String result = "";
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;
                    }
                    result=result.replace("connection success","");
                    result=result.replace("{","");
                    result=result.replace("[","");
                    result=result.replace("]","");
                    result=result.replace("}","");
                    result=result.replace("\"","");
                    System.out.println(result);
                    try {
                        String[] parts = result.split(",");
                        System.out.println(parts[0]);
                        if(parts[0]!=""){
                            name1=parts[0].substring(9);
                            System.out.println(name1);
                        }
                        if(parts[1]!=""){
                            name2=parts[1].substring(9);
                            System.out.println(name2);
                        }

                        if(parts[2]!=""){
                            name3=parts[2].substring(9);
                            System.out.println(name3);
                        }

                        if(parts[3]!=""){
                            name4=parts[3].substring(9);
                            System.out.println(name4);
                        }

                        if(parts[4]!=""){
                            name5=parts[4].substring(9);
                            System.out.println(name5);
                        }
                    }catch (Exception e) {}
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPreExecute() {


        }

        @Override
        protected void onPostExecute(String result) {
            t1.setText(name1);
            t2.setText(name2);
            t3.setText(name3);
            t4.setText(name4);
            t5.setText(name5);



        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

    }
}
