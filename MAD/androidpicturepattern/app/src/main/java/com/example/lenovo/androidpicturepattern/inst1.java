package com.example.lenovo.androidpicturepattern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class inst1 extends AppCompatActivity {
Button nextbtn,backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inst1);
        nextbtn=(Button)findViewById(R.id.nextbtn);
        backbtn=(Button)findViewById(R.id.backbtn);
        nextbtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent In = new Intent(inst1.this, inst2.class);
                startActivity(In);
                finish();
            }
        });

        backbtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent In = new Intent(inst1.this, home.class);
                startActivity(In);
                finish();
            }
        });
    }
}
