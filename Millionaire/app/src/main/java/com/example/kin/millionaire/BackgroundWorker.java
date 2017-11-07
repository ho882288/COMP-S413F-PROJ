package com.example.kin.millionaire;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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

/**
 * Created by Kin on 28/9/2017.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    //AlertDialog alertDialog;
    String passingname="";
    BackgroundWorker (Context ctx) {
        context=ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url="https://leungwaikin.000webhostapp.com/login2.php";
        String register_url="https://leungwaikin.000webhostapp.com/register2.php";
        String chnagepassword_url="https://leungwaikin.000webhostapp.com/changepassword2.php";//192.168.1.104 ,192.168.111.1 , 10.0.2.2,192.168.24.1
        String testone_url="https://leungwaikin.000webhostapp.com/updatelatestone2.php";

        String displayrecord_url="https://leungwaikin.000webhostapp.com/displayrecord2.php";
        https://leungwaikin.000webhostapp.com
        if (type.equals("login")){
            try {
                URL url = new URL(login_url);
                String user_name = params[1];
                passingname=user_name;
                String password = params[2];

                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder. encode("user_name","UTF-8")+"="+URLEncoder. encode(user_name,"UTF-8")+"&"
                        +URLEncoder. encode("password","UTF-8")+"="+URLEncoder. encode(password,"UTF-8");
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

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch(MalformedURLException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            }

        }else if(type.equals("register")){
            try {
                URL url = new URL(register_url);
                String user_name = params[1];
                passingname=user_name;
                String password = params[2];
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder. encode("username","UTF-8")+"="+URLEncoder. encode(user_name,"UTF-8")+"&"
                        +URLEncoder. encode("password","UTF-8")+"="+URLEncoder. encode(password,"UTF-8");
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

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch(MalformedURLException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            }
        }else if(type.equals("changepw")){
            try {
                URL url = new URL(chnagepassword_url);
                String username = params[1];
                String password = params[2];
                System.out.print(username);
                System.out.print(password);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder. encode("username","UTF-8")+"="+URLEncoder. encode(username,"UTF-8")+"&"
                        +URLEncoder. encode("password","UTF-8")+"="+URLEncoder. encode(password,"UTF-8");
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

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch(MalformedURLException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            }
        }else if(type.equals("submittestone")){
            try {
                URL url = new URL(testone_url);
                String username = params[1];
                String testone = params[2];
                System.out.print(username);
                System.out.print(testone);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder. encode("username","UTF-8")+"="+URLEncoder. encode(username,"UTF-8")+"&"
                        +URLEncoder. encode("testone","UTF-8")+"="+URLEncoder. encode(testone,"UTF-8");
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

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch(MalformedURLException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            }
        }else if(type.equals("display")){
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
                String[] parts = result.split(",");
                System.out.println(parts[0]);
                System.out.println("substring1 is = " + parts[0].substring(8));
                System.out.println("substring2 is = " + parts[1].substring(8));
                System.out.println("substring3 is = " + parts[2].substring(10));
                System.out.println("substring4 is = " + parts[3].substring(9));
                System.out.println("substring5 is = " + parts[4].substring(9));
                System.out.println("substring6 is = " + parts[5].substring(8));
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

        //alertDialog= new AlertDialog.Builder(context).create();
        //alertDialog.setTitle("Status");

    }
    @Override
    protected void onPostExecute(String result) {
        //alertDialog.setMessage(result);
        //alertDialog.show();
        if (result.contains("Login not")){
            Toast.makeText(context,"Information not match. Try again", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context,MainActivity.class));
        }else if (result.contains("Insert not")) {
            Toast.makeText(context,"Username has beem used. Try another", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, register.class));
        }else if (result.contains("Update not")){
            Toast.makeText(context,"Fail to change password. Try again later", Toast.LENGTH_SHORT).show();
        }else if (result.contains("Update")){
            Toast.makeText(context,"Password has been changed", Toast.LENGTH_SHORT).show();
        }else if (result.contains("test")){


        }else{
            Intent in = new Intent (context,MainPage.class);
            Bundle bundle = new Bundle();
            bundle.putString("username",passingname);
            in.putExtras(bundle);
            context.startActivity(in);
        }


    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super. onProgressUpdate(values);
    }
}
