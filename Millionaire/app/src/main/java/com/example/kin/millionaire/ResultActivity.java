package com.example.kin.millionaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * Created by Admin on 2017/11/16.
 */

public class ResultActivity extends AppCompatActivity {
    private TextView resultView;
    private ImageButton quit;
    private ImageButton restart;
    private String money[] = {"0","100","200","300","500","1000","2000","4000","8000","16,000","32,000","64,000","125,000","250,000","500,000","1 MILLION"};



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_page);


        //set panel
        resultView = (TextView) findViewById(R.id.resultPanel);
        quit = (ImageButton) findViewById(R.id.quitButton);
        restart = (ImageButton) findViewById(R.id.restartButton);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String value = extras.getString("Score");
            resultView.setText("You get $"+money[Integer.parseInt(value)]+", congratulations!!");
        }

        //return to main page
        quit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i=new Intent(ResultActivity.this, QuestionActivity.class);
                startActivity(i);
            }
        });

        //restart game
        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i=new Intent(ResultActivity.this, QuestionActivity.class);
                startActivity(i);
            }
        });

    }
}