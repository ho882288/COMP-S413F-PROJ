package com.example.kin.millionaire;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.camera2.params.BlackLevelPattern;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.kin.millionaire.R.drawable.money0;
import static com.example.kin.millionaire.R.drawable.money1;
import static com.example.kin.millionaire.R.drawable.money2;
import static com.example.kin.millionaire.R.drawable.money3;


/**
 * Created by Admin on 2017/11/16.
 */

public class ResultActivity extends AppCompatActivity {
    private TextView resultView;
    private ImageButton quit;
    private ImageButton restart;
    private String name;
    private String type;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_page);
        Bundle bundle=getIntent().getExtras();
        name = bundle.getString("username");

        //Toast.makeText(ResultActivity.this, name, Toast.LENGTH_SHORT).show();
        //set panel
        resultView = (TextView) findViewById(R.id.resultPanel);
        quit = (ImageButton) findViewById(R.id.quitButton);
        restart = (ImageButton) findViewById(R.id.restartButton);
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("score");
        int result=Integer.parseInt(value);

        resultView.setText("You get $"+QuestionActivity.money[Integer.parseInt(value)]+", congratulations!!");
        resultView.setTextSize(35);
        resultView.setTextColor(Color.BLACK);
        if(result==0){
            resultView.setBackgroundResource(money0);
        }
        if(result>=1&& result<=7){
            resultView.setBackgroundResource(money2);
        }
        if(result>7&&result<=11){
            resultView.setBackgroundResource(money1);
        }

        if(result>11){
            resultView.setBackgroundResource(money3);
        }

        //return to main page
        quit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i=new Intent(ResultActivity.this, ControlPage.class);
                Bundle bundle = new Bundle();
                bundle.putString("username",name);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        //restart game
        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i=new Intent(ResultActivity.this, QuestionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("username",name);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }


}