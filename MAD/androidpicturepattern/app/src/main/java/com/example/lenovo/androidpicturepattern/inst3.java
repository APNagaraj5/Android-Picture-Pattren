package com.example.lenovo.androidpicturepattern;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class inst3 extends AppCompatActivity {
Button nextbtn,backbtn;
private SharedPreferences instpref;
private SharedPreferences.Editor insteditpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inst3);
        nextbtn = (Button) findViewById(R.id.nextbtn);
        nextbtn.setOnClickListener(new Button.OnClickListener(){



            @Override
            public void onClick(View v) {
                instpref=getSharedPreferences("instprefs",MODE_PRIVATE);
                insteditpref=instpref.edit();
                insteditpref.putString("instname","set");
                insteditpref.commit();
                Intent In = new Intent(inst3.this, inst4.class);
                startActivity(In);
                finish();
            }
        });
        backbtn = (Button) findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent In = new Intent(inst3.this, inst2.class);
                startActivity(In);
                finish();
            }
        });

    }
}
