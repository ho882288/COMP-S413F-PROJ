package com.example.kin.millionaire;
import java.sql.* ;


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


    public static void main(String[] args) {
        QuestionData q = new QuestionData(); // 加上這行初始化物件
         String url = "jdbc:mysql://leungwaikin.000webhostapp.com/id2987906_leungwaikin";
         String username = "";   	//範例，使用者ID
         String password = "";	//範例，使用者密碼
         Connection con = null;
         Statement stat = null; 	//執行,傳入之sql為完整字串
         ResultSet rs = null; 	//結果集
         PreparedStatement pst = null;
        int x=0;
        int y=0;

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect the database!", e);
        }

        try {
            stat = con.createStatement();
            rs = stat.executeQuery("select question from Question ");
            while(rs.next()) {
                q.Questions[x]=rs.getString("question");
                x++;
            }
        }
        catch(SQLException e) {
        }

        try {
            stat = con.createStatement();
            rs = stat.executeQuery("select a,b,c,d from Question ");
            while(rs.next()) {
                q.Choices [y][0]=rs.getString("a");
                q.Choices [y][1]=rs.getString("b");
                q.Choices [y][2]=rs.getString("c");
                q.Choices [y][3]=rs.getString("d");
                y++;
            }
        }
        catch(SQLException e) {
        }

        if (con != null)
            try { con.close(); }
            catch (SQLException ignore) {}


    }


}