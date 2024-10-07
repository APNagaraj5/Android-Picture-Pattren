package com.example.lenovo.androidpicturepattern;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class splash extends AppCompatActivity {
    private SharedPreferences instpref;
    private SharedPreferences.Editor insteditpref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 100) {
                    i = i + 50;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i >= 100) {
                    instpref=getSharedPreferences("instprefs",MODE_PRIVATE);
                    String inst=instpref.getString("instname","");
                    if(inst.equals("set")){
                        Intent In = new Intent(splash.this,inst4.class);
                        startActivity(In);
                        finish();
                    }
                    else
                    {
                        Intent In = new Intent(splash.this, home.class);
                        startActivity(In);
                        finish();
                    }

                }

            }
        }).start();

    }
    private void startApp(){
        Intent In = new Intent(splash.this, home.class);
        startActivity(In);
    }
}
