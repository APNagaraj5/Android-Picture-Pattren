package com.example.lenovo.androidpicturepattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
public class home extends AppCompatActivity {
    Button nextbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        nextbtn=(Button)findViewById(R.id.nextbtn);

        nextbtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent In = new Intent(home.this, inst1.class);
                startActivity(In);
                finish();
            }
        });
    }

}
