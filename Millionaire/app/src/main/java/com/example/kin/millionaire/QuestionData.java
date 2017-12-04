package com.example.kin.millionaire;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.os.AsyncTask;

import java.io.*;
import java.util.*;


/**
 * Created by Admin on 2017/11/14.
 */

public class QuestionData {
    public QuestionData() {
    }

    private String Questions[] = new String[]{
            "Which film festival celebrated its 60th anniversary in 2003?",
            "Which disease devastated livestock across the UK during 2001?",
            "Which country is not an island?",
            "What are you said to do to a habit when you break it?",
            "What might an electrician lay?",
            "Which word follows 'North' and 'South' to give the names of two continents?",
            "Which is not the name of an English county?",
            "Which of these means adequate space for moving in?",
            "How is a play on words commonly described?",
            "Which of these is a fashionable district of London?",
            "Which colour is used as a term to describe an illegal market in rare goods?",
            "Which character was first played by Arnold Schwarzenegger in a 1984 film?",
            "What name is given to the person who traditionally attends the groom on his wedding day?",
            "Which of these would a film actor like to receive?",
            "In which country would you expect to be greeted with the word 'bonjour'?",
    };


    //public String Questions[];
    public String Choices[][] = {
            {"Venice", "London", "Berlin", "Cannes"},
            {"Hand-and-foot", "Foot-and-mouth", "Hand-to-mouth", "Foot-in-mouth"},
            {"Madagascar", "Cuba", "Germany", "Jamaica"},
            {"Throw it", "Punch it", "Eat it", "Kick it"},
            {"Cables", "Stables", "Gables", "Tables"},
            {"Africa", "America", "Asia", "Australia"},
            {"Lancashire", "Leicestershire", "Liverpoolshire", "Lincolnshire"},
            {"Knee lounge", "Ear hole", "Foot rest", "Elbow room"},
            {"Pun", "Pen", "Pin", "Pan"},
            {"Bulgaria", "Belgravia", "Belgrade", "Belgium"},
            {"Blue", "Red", "Black", "White"},
            {"The Demonstrator", "The Instigator", "The Investigator", "The Terminator"},
            {"Best man", "Top  man", "Old man", "Poor man"},
            {"Oliver", "Oscar", "Oliphant", "Osbert"},
            {"Italy", "Spain", "France", "Wales"}
    };

    public String CorrectAnswers[] = {
            "Venice",
            "Foot-and-mouth",
            "Germany",
            "Kick it",
            "Cables",
            "America",
            "Liverpoolshire",
            "Elbow room",
            "Pun",
            "Belgravia",
            "Black",
            "The Investigator",
            "Best man",
            "Oscar",
            "France"
    };

    public String[] getQuestion() {
        return Questions;
    }

    public String[][] getChoices() {
        return Choices;
    }

    public String[] getCorrectAnswer() {
        return CorrectAnswers;
    }

    public void setAll(String data[][]) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                Questions[i] = data[i][j];
                Choices[i][0] = data[i][j];
                Choices[i][1] = data[i][j];
                Choices[i][2] = data[i][j];
                Choices[i][3] = data[i][j];

            }
        }
    }

    public void setQuestion(String data) {
        String[] parts=data.split("\r\n");
        for (int i = 0; i < parts.length; i++) {
            Questions[i] = parts[i];
        }
    }
    public void Question() {
        String database_url = "https://leungwaikin.000webhostapp.com/database.php";
        String[] data = new String[15];
        String[] testQ = {"10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "110", "120", "130", "140", "150"};

    }


    public class Database extends AsyncTask<String, Void, String> {

        //AlertDialog alertDialog;
        Context context;

        Database(Context ctx) {
            context = ctx;
        }
        protected String doInBackground(String... params) {

            String database_url = "https://leungwaikin.000webhostapp.com/database.php";

            try {
                URL url = new URL(database_url);
                String username = "lo";
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
                result = result.replace("connection success", "");
                System.out.println(result);
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {


        }

        @Override
        protected void onPostExecute(String result) {
            setQuestion(result);
            super.onPostExecute(result);

            //QuestionData qa=new QuestionData();
            //String[] parts = result.split("\r\n");
            //qa.setQuestion(parts);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

    }


    }
        //return null;



 /*   public void Question() {
        String database_url = "https://leungwaikin.000webhostapp.com/database.php";
        String[] data = new String[15];
        String[] testQ = {"10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "110", "120", "130", "140", "150"};
        int a = 0;

        try {
            URL url = new URL(database_url);
            String username = "Lo";
            System.out.print(username);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data =  URLEncoder.encode(username, "UTF-8");
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
            result = result.replace("connection success", "");
            System.out.println(result);
            //String[] parts = result.split("\r\n");
            //System.out.println(parts[0]);
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            //return parts;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return null;


    }
*/


/*
        try {
            URL url = new URL(database_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            result = result.replace("connection success", "");
            System.out.println(result);
            parts = result.split("\r\n");
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
*/
//leungwaikin.000webhostapp.com
        /*
        try {
            URL url = new URL(database_url);
            URLConnection urlCon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            String  q;
            int size;
            size = Integer.parseInt(br.readLine());


            for(int num = 0; num < data.length; num++){
                q=br.readLine();
                String[] tokens = q.split(" ");
            }
            br.close();
        } catch(Exception e){
            // handle errors here...
        }
        return  data;
        */
/*
        try {
            URL url = new URL(database_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                inputLine = inputLine.replace("connection success", "");
            }
                String[] tokens = inputLine.split("\r\n");
            System.out.println(inputLine);
                for(String token:tokens){
                    data[a]=token;
                    a++;}

            in.close();
            inputStream.close();
        httpURLConnection.disconnect();

        }

        catch(Exception e){
            // handle errors here...
        }

    }

}
*/
    /*SQL
    public void setQuestion(){

        List<String> ls = new ArrayList<String>();
        ls=db.SelectAll();
        int i=0;
        int count=0;
        for(String item:ls){
            i=count%5;
            switch (i) {
                case 0:
                    Questions[count] = item ;
                    break;
                case 1:
                    Choices[count][0] = item ;
                    break;
                case 2:
                    Choices[count][1] = item ;
                    break;
                case 3:
                    Choices[count][2] = item ;
                    break;
                case 4:
                    Choices[count][3] = item ;
                    break;
            }
            count++;
        }

        db.close();
    }
     */


	/*
	public SQLiteDatabase db;
    public String DB_NAME = "questions_db";
    public String TABLE_NAME = "questions";
    
    public void openDatabase(){
        try {
            db = openOrCreaDatabase(DB_NAME,SQLiteDatabase.CREATE_IF_NECESSARY,null);
			createTable();
        } catch (FileNotFoundException e) {
            }
        
    }
	
	public void openDb(){
        try {
            db = openDatabase(DB_NAME,null);
        } catch (FileNotFoundException e) {
            try {
                db = createDatabase(DB_NAME,SQLiteDatabase.CREATE_IF_NECESSARY,null);
                createTable();
            } catch (FileNotFoundException e2) {
                db = null;
                Log.e("ERROR", e2.toString());
            }
        }
    }

    public void createTable(){
        String sql = "create table " + TABLE_NAME + " ("
            + "question text, "
            + "a text, "
			+ "b text, "
			+ "c text, "
            + "d text);";

        try {
            db.execSQL(sql);
        } catch (SQLException e) {
            Log.e("ERROR", e.toString());
        };
            String question = "Which one is me?";
            String a = "Lo" ;           
			String b = "Steve";
            String c = "Dick";
            String d = "Ho gor";		
			ContentValues cv = new ContentValues();
            cv.put("question", question);
            cv.put("a", a);            
			cv.put("b", b);
            cv.put("c", c);
			cv.put("d", d);
            db.insert(TABLE_NAME, null, cv);
    }
   		
	
	public void setQuestion(){
        String sql = "select * from " + TABLE_NAME + ";";
            try {
                SQLiteCursor c = (SQLiteCursor)db.query(sql, null);
                int rowcount = c.count();
                c.first();
                for (int i = 0; i < rowcount ; i++) {
                    Questions[i] = c.getInt(0);
                    Choices[i][0] = c.getString(1);
                    Choices[i][1] = c.getString(2);
					Choices[i][2] = c.getString(3);
					Choices[i][3] = c.getString(4);


                    c.next();
                }

                textResult.setText(new String(sb));
            } catch (SQLException e) {
                Log.e("ERROR", e.toString());
            }
        }
	*/

	