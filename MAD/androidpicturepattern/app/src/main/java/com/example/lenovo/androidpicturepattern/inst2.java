package com.example.lenovo.androidpicturepattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
public class inst2 extends AppCompatActivity {
Button nextbtn,backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inst2);
        nextbtn = (Button) findViewById(R.id.nextbtn);
        nextbtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent In = new Intent(inst2.this, inst3.class);
                startActivity(In);
                finish();
            }
        });
        backbtn = (Button) findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent In = new Intent(inst2.this, inst1.class);
                startActivity(In);
                finish();
            }
        });
    }
}
