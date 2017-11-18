package com.example.kin.millionaire;

/**
 * Created by Admin on 2017/11/14.
 */
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity {

    private QuestionData questionData = new QuestionData();

    private TextView questionView;
    private Button buttonChoice1;
    private Button buttonChoice2;
    private Button buttonChoice3;
    private Button buttonChoice4;
    private CheckBox checkBox0, checkBox1, checkBox2, checkBox3 ,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14;
    static String money[] = {"0","100","200","300","500","1000","2000","4000","8000","16,000","32,000","64,000","125,000","250,000","500,000","1 MILLION"};
    private ImageButton quit;
    private ImageButton helper1, helper2, helper3;

    private ArrayList<CheckBox> checkBoxList = new ArrayList<>();
    private ArrayList<String> unansweredQuestions = new ArrayList<>();
    private ArrayList<String[]> choiceList = new ArrayList<>();
    private ArrayList<String> answerList = new ArrayList<>();
    private String[] choices;
    private String currentQuestion;
    private String answer;
    private int score = 0;
    private int randomQuestionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qpanel);

        //set panels
        questionView = (TextView) findViewById(R.id.QuestionPanel);
        buttonChoice1 = (Button) findViewById(R.id.Answer1);
        buttonChoice2 = (Button) findViewById(R.id.Answer2);
        buttonChoice3 = (Button) findViewById(R.id.Answer3);
        buttonChoice4 = (Button) findViewById(R.id.Answer4);
        quit = (ImageButton)findViewById(R.id.giveUp);
        helper1 = (ImageButton)findViewById(R.id.helper1) ;
        helper2 = (ImageButton)findViewById(R.id.helper2) ;
        helper3 = (ImageButton)findViewById(R.id.helper3) ;

         checkBox0 = (CheckBox)findViewById(R.id.score1);
         checkBox1 = (CheckBox)findViewById(R.id.score2);
         checkBox2 = (CheckBox)findViewById(R.id.score3);
         checkBox3 = (CheckBox)findViewById(R.id.score4);
         checkBox4 = (CheckBox)findViewById(R.id.score5);
         checkBox5 = (CheckBox)findViewById(R.id.score6);
         checkBox6 = (CheckBox)findViewById(R.id.score7);
         checkBox7 = (CheckBox)findViewById(R.id.score8);
         checkBox8 = (CheckBox)findViewById(R.id.score9);
         checkBox9 = (CheckBox)findViewById(R.id.score10);
         checkBox10 = (CheckBox)findViewById(R.id.score11);
         checkBox11 = (CheckBox)findViewById(R.id.score12);
         checkBox12 = (CheckBox)findViewById(R.id.score13);
         checkBox13 = (CheckBox)findViewById(R.id.score14);
         checkBox14 = (CheckBox)findViewById(R.id.score15);
         checkBoxList.addAll(Arrays.asList(checkBox0, checkBox1, checkBox2, checkBox3 ,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14));


        //initialize questions list
        if (unansweredQuestions == null || unansweredQuestions.size() == 0) {
            unansweredQuestions = new ArrayList<>(Arrays.asList(questionData.getQuestion()));
            choiceList = new ArrayList<>(Arrays.asList(questionData.getChoices()));
            answerList = new ArrayList<>(Arrays.asList(questionData.getCorrectAnswer()));
        }
        updateQuestion();

        //set mc buttons activity
        buttonChoice1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                confirmDialog(0);
            }

        });

        buttonChoice2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                confirmDialog(1);
            }

        });

        buttonChoice3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                confirmDialog(2);
            }

        });

        buttonChoice4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                confirmDialog(3);
            }

        });

        quit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                giveUpDialog(score);
            }
        });

        helper1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });

    }
    void helper(int number){

    }

    void checkAnswer(int number){
        String string[] = {buttonChoice1.getText().toString(), buttonChoice2.getText().toString(), buttonChoice3.getText().toString(), buttonChoice4.getText().toString()};

        if ( string [number] == answer) {
            score += 1;
            updateScoreBoard(score);
            resultDialog("Correct !");
            removeCurrentQuestion();
            updateQuestion();
        } else {
            resultDialog("Wrong !");
        }
    }

        //update question list
     void updateQuestion(){
         // win message
         if(score == 15){
             Toast.makeText(QuestionActivity.this, "You win 1M!", Toast.LENGTH_SHORT).show();
             transitResultPage(score);
         }else {
             //generate random question order
             Random r = new Random();
             randomQuestionNumber = r.nextInt(unansweredQuestions.size());
             // int randomQuestionNumber =  (int)(Math.random() * ((unansweredQuestions.size()) + 1));
             currentQuestion = unansweredQuestions.get(randomQuestionNumber);
             questionView.setText(currentQuestion);

             choices = choiceList.get(randomQuestionNumber);
             buttonChoice1.setText(choices[0]);
             buttonChoice2.setText(choices[1]);
             buttonChoice3.setText(choices[2]);
             buttonChoice4.setText(choices[3]);

             answer = answerList.get(randomQuestionNumber);
         }
    };

    //remove answered question
    void removeCurrentQuestion(){
        unansweredQuestions.remove(randomQuestionNumber);
        choiceList.remove(randomQuestionNumber);
        answerList.remove(randomQuestionNumber);
    }
    //update score board
    void updateScoreBoard(int score){
        this.score = score;
        for(int i =0; i<score; i++){
            checkBoxList.get(i).setChecked(true);
        }
    }

    void dropToSafe(int a){
        int temp = a;
        if(temp <5)
            temp = 0;
        if(temp<10 && temp >5)
            temp = 5;
        else if (temp >10)
            temp = 10;
        transitResultPage(temp);
    }

    // generate result page
    void transitResultPage(int a){
        Intent i=new Intent(QuestionActivity.this, ResultActivity.class);
        i.putExtra("Score", ""+a);
        startActivity(i);
    }

    //result dialog boxes
    void resultDialog(final String a) {
        if (a == "Correct !") {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(" ")
                    .setMessage("Your answer is " + a)
                    .setNegativeButton("Continue", null)
                    .show();
        } else {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(" ")
                    .setMessage("Your answer is " + a)
                    .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dropToSafe(score);
                        }
                    }).show();
        }
    }


    //confirm answer dialog
    void confirmDialog(final int a) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(" ")
                .setMessage("Is this your final answer?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        checkAnswer(a);
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    // quit  game button
     void giveUpDialog(final int score) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Quit game?")
                .setMessage("Do you want to give up ? You will get $"+money[score])
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        transitResultPage(score);
                    }
                })
                .setNegativeButton("cancel", null)
                .show();
    }



}
