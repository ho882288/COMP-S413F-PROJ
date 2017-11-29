package com.example.kin.millionaire;

/**
 * Created by Admin on 2017/11/14.
 */
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


import static android.R.id.list;

public class QuestionActivity extends AppCompatActivity {

    private QuestionData questionData = new QuestionData();
    private String name;
    private TextView questionView;
    private Button buttonChoice1;
    private Button buttonChoice2;
    private Button buttonChoice3;
    private Button buttonChoice4;
    private CheckBox checkBox0, checkBox1, checkBox2, checkBox3 ,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14;
    static String money[] = {"0","100","200","300","500","1000","2000","4000","8000","16,000","32,000","64,000","125,000","250,000","500,000","1 MILLION"};
    private ImageButton quit;
    private ImageButton pause;
    private ImageButton helper1, helper2, helper3;
    private TextView timer;
    private CountDownTimer mTimer;

    private ArrayList<CheckBox> checkBoxList = new ArrayList<>();
    private ArrayList<String> unansweredQuestions = new ArrayList<>();
    private ArrayList<String[]> choiceList = new ArrayList<>();
    private ArrayList<String> answerList = new ArrayList<>();
    private String[] choices;
    private String currentQuestion;
    private String answer;
    private int score = 0;
    private int randomQuestionNumber;
    private boolean helper3Used = false;
    public String type;
    

    private long defaultTime = 35000;
    private long timeRemain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qpanel);
        Bundle bundle=getIntent().getExtras();
        name = bundle.getString("username");

        //database
        type="database";
        //to-do-database
        String[][] array = new String[15][5];
        /*Database db = new Database(QuestionActivity.this);
        db.execute(type);
        questionData.setAll(array);*/
        //set panels
        // questionData.setQuestion();
        questionView = (TextView) findViewById(R.id.QuestionPanel);
        timer = (TextView)findViewById(R.id.timer);
        buttonChoice1 = (Button) findViewById(R.id.Answer1);
        buttonChoice2 = (Button) findViewById(R.id.Answer2);
        buttonChoice3 = (Button) findViewById(R.id.Answer3);
        buttonChoice4 = (Button) findViewById(R.id.Answer4);
        quit = (ImageButton)findViewById(R.id.giveUp);
        pause = (ImageButton)findViewById(R.id.pauseGame);
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

        //Toast.makeText(QuestionActivity.this, name, Toast.LENGTH_SHORT).show();
        //initialize questions list
        if (unansweredQuestions == null || unansweredQuestions.size() == 0) {
            unansweredQuestions = new ArrayList<>(Arrays.asList(questionData.getQuestion()));
            choiceList = new ArrayList<>(Arrays.asList(questionData.getChoices()));
            answerList = new ArrayList<>(Arrays.asList(questionData.getCorrectAnswer()));
        }
        updateQuestion();
        helper1.setBackgroundResource(R.drawable.helper1);
        helper2.setBackgroundResource(R.drawable.helper2);
        helper3.setBackgroundResource(R.drawable.helper3);

        startTimer(defaultTime);

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

        pause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                pauseGame();
            }
        });

        helper1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                helper(1);
            }
        });

        helper2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                helper(2);
            }
        });

        helper3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                helper(3);
            }
        });



    }

    private void helper(int number){
        switch (number){
            case 1:
                helper1.setBackgroundResource(R.drawable.helper1corss);
                helper1.setEnabled(false);
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(" ")
                    .setMessage("After a moment of chat, your girlfriend said the answer is choice " + randomChoice() +". Do you have trust issue with her?")
                    .setNegativeButton("Continue", null)
                    .show();
            break;
            case 2:
                List distribution = randomDistribution(100,4);
                helper2.setBackgroundResource(R.drawable.helper2cross);
                helper2.setEnabled(false);
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(" ")
                    .setMessage("Audiences's choices are shown as below:\n" +
                            " A: "+ distribution.get(0) +"%\n B: "+ distribution.get(1) +"%\n C: "+ distribution.get(2) +"%\n D: "+ distribution.get(3) +"%")
                    .setNegativeButton("Continue", null)
                    .show();
                break;
           default:
              ArrayList<String> buttonText = new ArrayList<>();
               buttonText.addAll(Arrays.asList(buttonChoice1.getText().toString(), buttonChoice2.getText().toString(),buttonChoice3.getText().toString(),buttonChoice4.getText().toString()));
               Random r = new Random();
               ArrayList<String> randomChoiceList = new ArrayList<>();
              while(true) {
                 String randomChoiceText = buttonText.get(r.nextInt(buttonText.size()));
                  if(randomChoiceList.size() == 2)
                      break;
                  else if (!randomChoiceText.substring(randomChoiceText.indexOf(".") + 2, randomChoiceText.length()).equals(answer) && !randomChoiceList.contains(randomChoiceText.substring(0, 1))) {
                     randomChoiceList.add(randomChoiceText.substring(0, 1));
                 }
               }
               for(String s:randomChoiceList){
                   if(s .equals("A")) {
                       buttonChoice1.setAlpha(.2f);
                       buttonChoice1.setClickable(false);}
                   else if(s .equals("B")) {
                       buttonChoice2.setAlpha(.2f);
                       buttonChoice2.setClickable(false);}
                   else if(s .equals("C")) {
                       buttonChoice3.setAlpha(.2f);
                       buttonChoice3.setClickable(false);}
                   else if(s .equals("D")){
                       buttonChoice4.setAlpha(.2f);
                       buttonChoice4.setClickable(false);}
               }

                helper3.setBackgroundResource(R.drawable.helper3cross);
                helper3.setEnabled(false);
                helper3Used = true;
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle(" ")
                        .setMessage("You used your helper, click to continue")
                        .setNegativeButton("Continue", null)
                        .show();
        }

    }


     private boolean checkAnswer(int number){
        //String string[] = {buttonChoice1.getText().toString(), buttonChoice2.getText().toString(), buttonChoice3.getText().toString(), buttonChoice4.getText().toString()};
         String string[] = {choices[0], choices[1],choices[2], choices[3]};
        if ( string [number] == answer)
            return true;
         return false;
    }

        //update question list

    private void updateQuestion(){
         // win message
         if(score == 15){
             //Toast.makeText(QuestionActivity.this, "You win 1M!", Toast.LENGTH_SHORT).show();
             new AlertDialog.Builder(this)
                     .setIcon(android.R.drawable.ic_dialog_alert)
                     .setTitle(" ")
                     .setMessage("You win $1 MILLION!")
                     .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             transitResultPage(score);
                         }
                     }).show();
         }else {
             //generate random question order
             Random r = new Random();
             randomQuestionNumber = r.nextInt(unansweredQuestions.size());
             // int randomQuestionNumber =  (int)(Math.random() * ((unansweredQuestions.size()) + 1));
             currentQuestion = unansweredQuestions.get(randomQuestionNumber);
             questionView.setText(currentQuestion);
             choices = choiceList.get(randomQuestionNumber);
             buttonChoice1.setText("A. "+choices[0]);
             buttonChoice2.setText("B. "+choices[1]);
             buttonChoice3.setText("C. "+choices[2]);
             buttonChoice4.setText("D. "+choices[3]);
             answer = answerList.get(randomQuestionNumber);

             startTimer(defaultTime);
             if(helper3Used == true){
             buttonChoice1.setAlpha(1f);
             buttonChoice1.setClickable(true);
             buttonChoice2.setAlpha(1f);
             buttonChoice2.setClickable(true);
             buttonChoice3.setAlpha(1f);
             buttonChoice3.setClickable(true);
             buttonChoice4.setAlpha(1f);
             buttonChoice4.setClickable(true);
                 helper3Used = false;
         }
    }}

    //remove answered question
   private void removeCurrentQuestion(){
        unansweredQuestions.remove(randomQuestionNumber);
        choiceList.remove(randomQuestionNumber);
        answerList.remove(randomQuestionNumber);
    }

    //update score board
    private void updateScoreBoard(int score){
        this.score = score;
        for(int i =0; i<score; i++){
            checkBoxList.get(i).setChecked(true);
        }
    }

    private void startTimer(long time){
        if(mTimer != null)
            mTimer.cancel();
        mTimer = new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
                if(millisUntilFinished<=11000) {
                timer.setTextColor(Color.RED);

                }

                timeRemain = millisUntilFinished;
            }

            public void onFinish() {
                timer.setText("0");
                timer.setTextColor(Color.RED);
                Animation shake;
                shake = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shake);
                timer.startAnimation(shake);
                timerEnd();
            }
        }.start();
    }

    private void timerEnd(){
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(" ")
                .setMessage("Time's up!")
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dropToSafe(score);
                    }
                }).show();
    }

    private void pauseGame(){
        mTimer.cancel();
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(" ")
                .setMessage("Pause")
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long timerValue = timeRemain;
                        mTimer = null;
                        startTimer(timerValue);
                    }
                }).show();
    }
    
    private void dropToSafe(int a){
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
   private void transitResultPage(int a){
        Intent i=new Intent(QuestionActivity.this, ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("username",name);
        bundle.putString("score",""+a);
        i.putExtras(bundle);
        startActivity(i);

    }

    //result dialog boxes
   private void resultDialog(final String a) {
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
    private void confirmDialog(final int a) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(" ")
                .setMessage("Is this your final answer?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(checkAnswer(a)){
                            score += 1;
                            type="submittestone"; //  if correct button
                            BackgroundWorker background = new BackgroundWorker(QuestionActivity.this);  //  if correct button
                            background.execute(type,name,money[score]); //  if correct button
                            updateScoreBoard(score);
                            resultDialog("Correct !");
                            removeCurrentQuestion();
                            updateQuestion();
                        } else {
                            type="submittestone";
                            if (score>= 10) {
                                BackgroundWorker background = new BackgroundWorker(QuestionActivity.this);  //  if wrong button
                                background.execute(type, name, "32000"); //  if wrong button
                            }else if(score>=5){
                                BackgroundWorker background = new BackgroundWorker(QuestionActivity.this);  //  if wrong button
                                background.execute(type, name, "1000"); //  if wrong button
                            }else{
                                BackgroundWorker background = new BackgroundWorker(QuestionActivity.this);  //  if wrong button
                                background.execute(type, name, "0"); //  if wrong button
                            }
                            resultDialog("Wrong !");
                        };
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    // quit  game button
    private void giveUpDialog(final int score) {
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

     private List randomDistribution(int targetSum, int numberOfDraws) {
        Random r = new Random();
        List<Integer> load = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < numberOfDraws; i++) {
            int next = r.nextInt(targetSum) + 1;
            load.add(next);
            sum += next;
        }
        double scale = 1d * targetSum / sum;
        sum = 0;
        for (int i = 0; i < numberOfDraws; i++) {
            load.set(i, (int) (load.get(i) * scale));
            sum += load.get(i);
        }
        while(sum++ < targetSum) {
            int i = r.nextInt(numberOfDraws);
            load.set(i, load.get(i) + 1);
        }
       return load;
    }

    private char randomChoice(){
            Random r = new Random();
            char randomChoice = (char) (65 + r.nextInt(4));
            return randomChoice;
    }


}

