package com.example.kin.millionaire;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class MainPage extends AppCompatActivity {
    private QuestionData questionData = new QuestionData();

    private TextView questionView;
    private Button buttonChoice1;
    private Button buttonChoice2;
    private Button buttonChoice3;
    private Button buttonChoice4;
    private CheckBox checkBox0, checkBox1, checkBox2, checkBox3 ,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15;
    private ArrayList<CheckBox> checkBoxList = new ArrayList<>();

    private ArrayList<String> unansweredQuestions = new ArrayList<>();
    private ArrayList<String[]> choiceList = new ArrayList<>();
    private ArrayList<String> answerList = new ArrayList<>();
    private String[] choices;
    private String currentQuestion;
    private String answer;
    private int score = 0;
    private int randomQuestionNumber;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qpanel);
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("username");
        //scoreView = (TextView)findViewById(R.id.)
        questionView = (TextView) findViewById(R.id.QuestionPanel);
        buttonChoice1 = (Button) findViewById(R.id.Answer1);
        buttonChoice2 = (Button) findViewById(R.id.Answer2);
        buttonChoice3 = (Button) findViewById(R.id.Answer3);
        buttonChoice4 = (Button) findViewById(R.id.Answer4);

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
        checkBoxList.addAll(Arrays.asList(checkBox0, checkBox1, checkBox2, checkBox3 ,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15));


        //initialize questions list
        if (unansweredQuestions == null || unansweredQuestions.size() == 0) {
            unansweredQuestions = new ArrayList<>(Arrays.asList(questionData.getQuestion()));
            choiceList = new ArrayList<>(Arrays.asList(questionData.getChoices()));
            answerList = new ArrayList<>(Arrays.asList(questionData.getCorrectAnswer()));
        }

        updateQuestion();

        buttonChoice1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (buttonChoice1.getText() == answer) {
                    score += 1;
                    updateScoreBoard(score);
                    Toast.makeText(MainPage.this, "correct", Toast.LENGTH_SHORT).show();
                    removeCurrentQuestion();
                    updateQuestion();

                } else {
                    Toast.makeText(MainPage.this, "wrong", Toast.LENGTH_SHORT).show();

                }
            }

        });

        buttonChoice2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                if (buttonChoice2.getText() == answer) {
                    score += 1;
                    updateScoreBoard(score);
                    Toast.makeText(MainPage.this, "correct", Toast.LENGTH_SHORT).show();
                    removeCurrentQuestion();
                    updateQuestion();
                } else {
                    Toast.makeText(MainPage.this, "wrong", Toast.LENGTH_SHORT).show();

                }

            }

        });

        buttonChoice3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                if (buttonChoice3.getText() == answer) {
                    score += 1;
                    updateScoreBoard(score);
                    Toast.makeText(MainPage.this, "correct", Toast.LENGTH_SHORT).show();
                    removeCurrentQuestion();
                    updateQuestion();
                } else {
                    Toast.makeText(MainPage.this, "wrong", Toast.LENGTH_SHORT).show();

                }

            }

        });

        buttonChoice4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                if (buttonChoice4.getText() == answer) {
                    score += 1;
                    updateScoreBoard(score);
                    Toast.makeText(MainPage.this, "correct", Toast.LENGTH_SHORT).show();
                    removeCurrentQuestion();
                    updateQuestion();
                } else {
                    Toast.makeText(MainPage.this, "wrong", Toast.LENGTH_SHORT).show();

                }

            }

        });
    }

    //update question list
    void updateQuestion(){
        // win message
        if(unansweredQuestions.size() == 0){
            Toast.makeText(MainPage.this, "You win 1M!", Toast.LENGTH_SHORT).show();
        }

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
        Toast.makeText(MainPage.this, ""+answer, Toast.LENGTH_SHORT).show();

    };

    //remove answered question
    void removeCurrentQuestion(){
        unansweredQuestions.remove(randomQuestionNumber);
        choiceList.remove(randomQuestionNumber);
        answerList.remove(randomQuestionNumber);
    }

    void updateScoreBoard(int score){
        this.score = score;
        for(int i =0; i<score; i++){
            checkBoxList.get(i).setChecked(true);
        }


    }







    /*Button logout,chagepw,displaymillion,btn4;
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
                    t1=result.substring(6);  //t1 is the score is database


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
    }*/
}
