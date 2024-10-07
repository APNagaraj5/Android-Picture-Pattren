package com.example.lenovo.androidpicturepattern;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.ButtonBarLayout;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class pinlogin extends AppCompatActivity {
    Button logbtn1;
    EditText numtxt2;
    DataBaseHelper db;
    String pin="";
    String dbpin=null;
    private SharedPreferences uidpref;
    private SharedPreferences.Editor uideditpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinlogin);
        logbtn1=(Button)findViewById(R.id.logbtn1);
        numtxt2=(EditText)findViewById(R.id.numtxt2);
        uidpref = getSharedPreferences("uidprefs", MODE_PRIVATE);
        final String uid = uidpref.getString("uid", "");
        logbtn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                db=new DataBaseHelper(pinlogin.this);
                pin=numtxt2.getText()+"";
                Cursor res= db.getpin(uid);
                while (res.moveToNext()) {
                    dbpin=res.getString(0);
                }
                if(dbpin.equals(pin)) {
                    Intent In = new Intent(pinlogin.this, loginhome.class);
                    startActivity(In);
                    finish();
                }
                else{
                    Toast.makeText(pinlogin.this, "Invalid Pin", Toast.LENGTH_LONG).show();
                    Intent In = new Intent(pinlogin.this, inst4.class);
                    startActivity(In);
                    finish();
                }

            }

        });

            }
}
