package com.example.lenovo.androidpicturepattern;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private SharedPreferences uidpref;
    private SharedPreferences.Editor uideditpref;
    TextView uidtxt;
    DataBaseHelper db;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
    String ulkey="";
    String ulcode="";
    Button subbtn,pinbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        subbtn=(Button)findViewById(R.id.subbtn);
        pinbtn=(Button)findViewById(R.id.pinbtn);

                img1=(ImageView) findViewById(R.id.img1);
        img2=(ImageView) findViewById(R.id.img2);
        img3=(ImageView) findViewById(R.id.img3);
        img4=(ImageView) findViewById(R.id.img4);
        img5=(ImageView) findViewById(R.id.img5);
        img6=(ImageView) findViewById(R.id.img6);
        img7=(ImageView) findViewById(R.id.img7);
        img8=(ImageView) findViewById(R.id.img8);
        img9=(ImageView) findViewById(R.id.img9);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ulcode=ulcode+"1";
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ulcode=ulcode+"2";

            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ulcode=ulcode+"3";

            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ulcode=ulcode+"4";
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ulcode=ulcode+"5";

            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ulcode=ulcode+"6";
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ulcode=ulcode+"7";
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ulcode=ulcode+"8";

            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ulcode=ulcode+"9";

            }
        });
        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(ulcode.equals(ulkey)){
                   Intent In = new Intent(login.this, loginhome.class);
                   startActivity(In);
                   finish();
               }
               else{
                   Toast.makeText(login.this,"INVALID PICTURE PATTERN SELECTED",Toast.LENGTH_LONG).show();
                   Intent In = new Intent(login.this, inst4.class);
                   startActivity(In);
                   finish();
               }

            }
        });
        pinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent In = new Intent(login.this, pinlogin.class);
                    startActivity(In);
                    finish();


            }
        });
        db=new DataBaseHelper(this);
        uidpref = getSharedPreferences("uidprefs", MODE_PRIVATE);
        String uid = uidpref.getString("uid", "");
        String uname = uidpref.getString("uname", "");
        uidtxt=(TextView)findViewById(R.id.uidtxt);
        uidtxt.setText("User ID: "+uid+"\nWELCOME: "+uname);
        byte[] imge=null,imge1=null,imge2=null,imge3=null,imge4=null,imge5=null,imge6=null,imge7=null,imge8=null;
        String unlock1="";
        Cursor res= null;
        res= db.getSelImg(uid);

        while (res.moveToNext()) {
            imge = res.getBlob(0);
            imge1 = res.getBlob(1);
            imge2 = res.getBlob(2);
            imge3 = res.getBlob(3);
            imge4 = res.getBlob(4);
            imge5 = res.getBlob(5);
            imge6 = res.getBlob(6);
            imge7 = res.getBlob(7);
            imge8 = res.getBlob(8);
            unlock1=res.getString(9);
        }
        Bitmap image1=ByteArrayToBitmap(imge);
        int hight=image1.getRowBytes() * image1.getHeight();
        int width=image1.getRowBytes() * image1.getWidth();
        int div=width/180;
        int sethight=hight/div;
        img1.getLayoutParams().height=sethight;
        img1.getLayoutParams().width=180;
        img1.setScaleType(ImageView.ScaleType.FIT_XY);
        img2.getLayoutParams().height=sethight;
        img2.getLayoutParams().width=180;
        img2.setScaleType(ImageView.ScaleType.FIT_XY);
        img3.getLayoutParams().height=sethight;
        img3.getLayoutParams().width=180;
        img3.setScaleType(ImageView.ScaleType.FIT_XY);
        img4.getLayoutParams().height=sethight;
        img4.getLayoutParams().width=180;
        img4.setScaleType(ImageView.ScaleType.FIT_XY);
        img5.getLayoutParams().height=sethight;
        img5.getLayoutParams().width=180;
        img5.setScaleType(ImageView.ScaleType.FIT_XY);
        img6.getLayoutParams().height=sethight;
        img6.getLayoutParams().width=180;
        img6.setScaleType(ImageView.ScaleType.FIT_XY);
        img7.getLayoutParams().height=sethight;
        img7.getLayoutParams().width=180;
        img7.setScaleType(ImageView.ScaleType.FIT_XY);
        img8.getLayoutParams().height=sethight;
        img8.getLayoutParams().width=180;
        img8.setScaleType(ImageView.ScaleType.FIT_XY);
        img9.getLayoutParams().height=sethight;
        img9.getLayoutParams().width=180;
        img9.setScaleType(ImageView.ScaleType.FIT_XY);
        img1.setImageBitmap(image1);
        Bitmap image2=ByteArrayToBitmap(imge1);
        img2.setImageBitmap(image2);
        Bitmap image3=ByteArrayToBitmap(imge2);
        img3.setImageBitmap(image3);
        Bitmap image4=ByteArrayToBitmap(imge3);
        img4.setImageBitmap(image4);
        Bitmap image5=ByteArrayToBitmap(imge4);
        img5.setImageBitmap(image5);
        Bitmap image6=ByteArrayToBitmap(imge5);
        img6.setImageBitmap(image6);
        Bitmap image7=ByteArrayToBitmap(imge6);
        img7.setImageBitmap(image7);
        Bitmap image8=ByteArrayToBitmap(imge7);
        img8.setImageBitmap(image8);
        Bitmap image9=ByteArrayToBitmap(imge8);
        img9.setImageBitmap(image9);
        ulkey=unlock1;

    }
    public static Bitmap ByteArrayToBitmap(byte[] img){
        Bitmap bitmap=BitmapFactory.decodeByteArray(img,0,img.length);
        return bitmap;
    }
}
