package com.example.kin.millionaire;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.kin.millionaire.R.id.menu_about;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button login;
    Button register;
    ImageView logo;
    String name;
    String pw;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo=(ImageView)findViewById(R.id.imageView1);
        username=(EditText)findViewById(R.id.editText1);
        password= (EditText)findViewById(R.id.editText2);
        login=(Button)findViewById(R.id.button1);
        register=(Button)findViewById(R.id.button2);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                name= username.getText().toString();
                pw=password.getText().toString();
                type ="login";
                if(name.equals("")) {
                    Toast.makeText(MainActivity.this,"You didn't enter your username", Toast.LENGTH_SHORT).show();
                }else if(pw.equals("")){
                    Toast.makeText(MainActivity.this,"You didn't enter your password", Toast.LENGTH_SHORT).show();
                }else{

                    BackgroundWorker backgroundWorker = new BackgroundWorker(MainActivity.this);
                    backgroundWorker.execute(type, name, pw);  // diaable login function

                    //Temperoy use
                    /*Intent in = new Intent (MainActivity.this,QuestionActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username",name);
                    in.putExtras(bundle);
                    startActivity(in);*/

                }

            }
        });
    }
    public void movetoregister(View w){
        Intent jumpage=new Intent(MainActivity.this,register.class);
        startActivity(jumpage);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_about,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case menu_about:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("About");
                builder.setMessage("This is a game called \" Millionaire\".");

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
