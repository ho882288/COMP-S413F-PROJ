package com.example.kin.millionaire;

/**
 * Created by Admin on 2017/11/14.
 */

public class QuestionData {


    private String Questions [] = {
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

    private String Choices [][] = {
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"},
            {"1","2","3","4"}
    };

    private String CorrectAnswers[] = {
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

    public  String[] getQuestion(){
        return Questions;
    }

    public String[][] getChoices(){
        return Choices;
    }

    public String[] getCorrectAnswer(){
        return CorrectAnswers;
    }
    
	public SQLiteDatabase db;
    public String DB_NAME = "questions_db";
    public String TABLE_NAME = "questions";
    
    public void openDatabase(){
        try {
            db = openOrCreaDatabase(DB_NAME,SQLiteDatabase.CREATE_IF_NECESSARY,null);
        } catch (FileNotFoundException e) {
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
        }
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
    }
	
	
}