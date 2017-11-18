package com.example.kin.millionaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText secondpassword;
    Button register;
    ImageView logo;
    String name;
    String pw;
    String secondpw;
    String type = "register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        logo=(ImageView)findViewById(R.id.imageView1);
        username=(EditText)findViewById(R.id.editText1);
        password=(EditText)findViewById(R.id.editText2);
        secondpassword=(EditText)findViewById(R.id.editText3);
        register=(Button)findViewById(R.id.button1);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                name= username.getText().toString();
                pw=password.getText().toString();
                secondpw=secondpassword.getText().toString();
                if(name.equals("")) {
                    Toast.makeText(register.this,"You didn't enter your username", Toast.LENGTH_SHORT).show();
                }else if(pw.equals("")){
                    Toast.makeText(register.this,"You didn't enter your password", Toast.LENGTH_SHORT).show();
                }else if(secondpw.equals("")){
                    Toast.makeText(register.this,"You didn't re-enter your password", Toast.LENGTH_SHORT).show();
                }else if(!(secondpw.equals(pw))){
                    Toast.makeText(register.this,"Password mismatch.", Toast.LENGTH_SHORT).show();
                }else{
                    //to do--database
                    BackgroundWorker background = new BackgroundWorker(register.this);
                    background.execute(type,name,pw);
                    /*Intent in = new Intent (register.this,QuestionActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username",name);
                    in.putExtras(bundle);
                    startActivity(in);*/
                }

            }
        });

    }
}
