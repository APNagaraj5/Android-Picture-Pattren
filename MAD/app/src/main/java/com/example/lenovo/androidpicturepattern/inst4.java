package com.example.lenovo.androidpicturepattern;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class inst4 extends AppCompatActivity {
    Button loginbtn,registerbtn;
    EditText useridtxt;
    private SharedPreferences uidpref;
    private SharedPreferences.Editor uideditpref;
    DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inst4);
        db=new DataBaseHelper(this);
        loginbtn = (Button) findViewById(R.id.loginbtn);
        useridtxt=(EditText) findViewById(R.id.useridtxt);
        loginbtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                String uid=useridtxt.getText()+"";
                if(uid.equals(null)||uid.equals("")){
                    Toast.makeText(inst4.this, "Please Enter UserID", Toast.LENGTH_LONG).show();
                }
                else{
                    String uname=null;
                    int count=0;
                    Cursor res= null;
                    res= db.getSelMember(uid);
                    while (res.moveToNext()){
                        uname=res.getString(0);
                        count=count+1;
                    }
                    if (count==1) {
                        uidpref = getSharedPreferences("uidprefs", MODE_PRIVATE);
                        uideditpref = uidpref.edit();
                        uideditpref.putString("uid", uid);
                        uideditpref.putString("uname", uname);
                        uideditpref.commit();
                        Intent In = new Intent(inst4.this, login.class);
                        startActivity(In);
                        finish();


                    }
                    else {
                        Toast.makeText(inst4.this, "Invalid user ID", Toast.LENGTH_LONG).show();
                        useridtxt.setText("");
                    }
                }

            }
        });
        registerbtn = (Button) findViewById(R.id.registerbtn);
        registerbtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent In = new Intent(inst4.this, register.class);
                startActivity(In);
                finish();
            }
        });

    }
}
