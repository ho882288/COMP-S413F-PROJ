package com.example.kin.millionaire;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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


public class MainPage extends AppCompatActivity {
    Button logout,chagepw,displaymillion,btn4;
    String name;
    TextView textView2;
    String type = "display";
    String score ="1000000";
    String t1="20000";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("username");
        textView2=(TextView)findViewById(R.id.textView2);
        logout=(Button)findViewById(R.id.button1);
        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {

                Toast.makeText(MainPage.this,"You log out successfully", Toast.LENGTH_SHORT).show();
                Intent jumpage=new Intent(MainPage.this,MainActivity.class);
                startActivity(jumpage);
            }
        });
        chagepw=(Button)findViewById(R.id.button2);
        chagepw.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent in = new Intent (MainPage.this,Changepassword.class);
                Bundle bundle = new Bundle();
                bundle.putString("username",name);
                in.putExtras(bundle);
                startActivity(in);
            }
        });
        displaymillion=(Button)findViewById(R.id.button3);
        displaymillion.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                Intent in = new Intent (MainPage.this,Displaymillion.class);
                Bundle bundle = new Bundle();
                bundle.putString("username",name);
                in.putExtras(bundle);
                startActivity(in);
            }
        });
        new localBackgroundWorker(MainPage.this).execute(type,name);
        btn4=(Button)findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                type="submittestone";
                BackgroundWorker background = new BackgroundWorker(MainPage.this);  //  if correct button
                background.execute(type,name,score);
            }
        });

    }
    private class localBackgroundWorker extends AsyncTask<String,Void,String> {
        Context context;
        localBackgroundWorker (Context ctx) {
            context=ctx;
        }
        @Override
        protected String doInBackground(String... params) {
            String type = params[0];
            String displayrecord_url="https://leungwaikin.000webhostapp.com/displayrecord2.php";

            if(type.equals("display")){
                try {
                    URL url = new URL(displayrecord_url);
                    String username = params[1];
                    System.out.print(username);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                    String post_data= URLEncoder. encode("username","UTF-8")+"="+URLEncoder. encode(username,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream= httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String result="";
                    String line="";
                    while ((line=bufferedReader.readLine())!= null){
                        result+=line;
                    }
                    result=result.replace("connection success","");
                    result=result.replace("{","");
                    result=result.replace("[","");
                    result=result.replace("]","");
                    result=result.replace("}","");
                    result=result.replace("\"","");
                    System.out.println(result);
                    t1=result.substring(6);


                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch(MalformedURLException e){
                    e.printStackTrace();
                } catch(IOException e){
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
            textView2.setText(t1);



        }
        @Override
        protected void onProgressUpdate(Void... values) {
            super. onProgressUpdate(values);
        }
    }
}
