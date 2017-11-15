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

    public String getChoice1(int a){
        String choice0 = Choices[a][0];
        return choice0;
    }

    public String getChoice2(int a){
        String choice1 = Choices[a][1];
        return choice1;
    }

    public String getChoice3(int a){
        String choice2 = Choices[a][2];
        return choice2;
    }

    public String getChoice4(int a){
        String choice3 = Choices[a][3];
        return choice3;
    }

    public String[] getCorrectAnswer(){
        return CorrectAnswers;
    }
}
