package com.example.lenovo.androidpicturepattern;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginhome extends AppCompatActivity {
Button logoutbtn,chromebtn,facebookbtn,whatsappbtn,shareitbtn,youtubebtn,mapsbtn,jiotvbtn,telegrambtn,gmailbtn,vidmatebtn,jiomusicbtn,googlemusicbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginhome);
        chromebtn=(Button)findViewById(R.id.chromebtn);
        facebookbtn=(Button)findViewById(R.id.facebookbtn);
        whatsappbtn=(Button)findViewById(R.id.whatsappbtn);
        shareitbtn=(Button)findViewById(R.id.shareitbtn);
        youtubebtn=(Button)findViewById(R.id.youtubebtn);
        mapsbtn=(Button)findViewById(R.id.mapsbtn);
        jiotvbtn=(Button)findViewById(R.id.jiotvbtn);
        telegrambtn=(Button)findViewById(R.id.telegrambtn);
        gmailbtn=(Button)findViewById(R.id.gmailbtn);
        jiomusicbtn=(Button)findViewById(R.id.jiomusicbtn);
        googlemusicbtn=(Button)findViewById(R.id.googlemusicbtn);
        vidmatebtn=(Button)findViewById(R.id.vidmatebtn);
        logoutbtn=(Button)findViewById(R.id.logoutbtn);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(loginhome.this, inst4.class);
                startActivity(In);
                finish();
            }});
        chromebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlString = "http://google.co.in";
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(urlString));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                try {
                    loginhome.this.startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    loginhome.this.startActivity(intent);
                }
            }});
        facebookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://home/"));
                    startActivity(intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/appetizerandroid")));
                }
            }});
        whatsappbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                startActivity(launchIntent);
            }});
        shareitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.lenovo.anyshare.gps");
                startActivity(launchIntent);
            }});
        youtubebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                startActivity(launchIntent);
            }});
        mapsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.maps");
                startActivity(launchIntent);
            }});
        jiotvbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.jio.jioplay.tv");
                startActivity(launchIntent);
            }});
        telegrambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("org.telegram.messenger");
                startActivity(launchIntent);
            }});
        gmailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
                startActivity(launchIntent);
            }});
        jiomusicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.jio.media.jiobeats");
                startActivity(launchIntent);
            }});
        vidmatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.nemo.vidmate");
                startActivity(launchIntent);
            }});
        googlemusicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.music");
                startActivity(launchIntent);
            }});

    }
}
