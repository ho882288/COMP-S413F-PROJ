package com.example.kin.millionaire;

import android.accounts.Account;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Changepassword extends AppCompatActivity {
    EditText newpassword,reenterpassword;
    Button submit;
    String password;
    String secondpw;
    String name;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("username");
        newpassword=(EditText)findViewById(R.id.editText1);
        reenterpassword=(EditText)findViewById(R.id.editText2);

        submit=(Button)findViewById(R.id.button1);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View w) {
                password= newpassword.getText().toString();
                secondpw=reenterpassword.getText().toString();
                type="changepw";
                if(password.equals("")) {
                    Toast.makeText(Changepassword.this,"You didn't enter your new password", Toast.LENGTH_SHORT).show();
                }else if(secondpw.equals("")){
                    Toast.makeText(Changepassword.this,"You didn't re-enter your new password", Toast.LENGTH_SHORT).show();
                }else if(!(password.equals(secondpw))){
                    Toast.makeText(Changepassword.this,"Mismatch password", Toast.LENGTH_SHORT).show();
                }else{
                    //to-do-database
                    BackgroundWorker background = new BackgroundWorker(Changepassword.this);
                    background.execute(type,name,password);

                }

            }
        });
    }
}
