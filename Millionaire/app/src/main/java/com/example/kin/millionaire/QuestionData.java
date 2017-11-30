package com.example.kin.millionaire;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import java.io.*;
import java.util.*;

/**
 * Created by Admin on 2017/11/14.
 */

public class QuestionData {
    public QuestionData(){
        setQuestion(doInBackground());
    }

    private String Questions[] = new String[]{
            "Test 1 answer is 1",
            "Test 2 answer is 2",
            "Test 3 answer is 3",
            "Test 4 answer is 4",
            "Test 5 answer is 1",
            "Test 6 answer is 2",
            "Test 7 answer is 3",
            "Test 8 answer is 4",
            "Test 9 answer is 1",
            "Test 10 answer is 2",
            "Test 11 answer is 3",
            "Test 12 answer is 4",
            "Test 13 answer is 1",
            "Test 14 answer is 2",
            "Test 15 answer is 3",
    };


    /*
     public String Questions[]={
             "Q1",
             "Q2"
     ,"Q3"
      ,"Q4"
      ,"Q5"
      ,"Q6"
     , "Q7"
     , "Q8"
     , "Q9"
     , "Q10"
     , "Q11"
     , "012"
     , "Q13"
     , "Q14"
     , "Q15"
     };
     */
    //public String Questions[];
    public String Choices[][] = {
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"}
    };

    public String CorrectAnswers[] = {
            "1",
            "2",
            "3",
            "4",
            "1",
            "2",
            "3",
            "4",
            "1",
            "2",
            "3",
            "4",
            "1",
            "2",
            "3"
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

    public void setQuestion(String data[]) {
        Questions = data;
    }

    public String[] doInBackground() {
        String database_url = "https://leungwaikin.000webhostapp.com/database.php";
        int i = 0;
        String data[] = null;
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
        try {
            URL url = new URL(database_url);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                inputLine=inputLine.replace("connection success","");
                String[] tokens = inputLine.split("\r\n");
                for(String token:tokens){
                    data[i]=token;
                    i++;}
            }
            in.close();
        }

        catch(Exception e){
            // handle errors here...
        }


        return data;


    }
}
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

	