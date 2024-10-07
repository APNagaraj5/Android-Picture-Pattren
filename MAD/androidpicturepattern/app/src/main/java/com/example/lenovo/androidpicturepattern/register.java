package com.example.lenovo.androidpicturepattern;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


import java.io.IOException;

public class register extends AppCompatActivity {
Button regbtn;
EditText uitxt,untxt,numtxt;
ImageView imageview;
DataBaseHelper db;
    String userid=null;
    String username=null;
    String unlock1=null;
    String pin=null;
    private SharedPreferences uidpref;
    private SharedPreferences.Editor uideditpref;

private int REQUEST_CODE= 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regbtn=(Button) findViewById(R.id.registerbtn);
        uitxt=(EditText) findViewById(R.id.uitxt);
        untxt=(EditText) findViewById(R.id.untxt);
        numtxt=(EditText) findViewById(R.id.numtxt);

        imageview = (ImageView) findViewById(R.id.imageview);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"select picture"),REQUEST_CODE);

            }
        });

        regbtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                userid=uitxt.getText()+"";
                username=untxt.getText()+"";
                pin=numtxt.getText()+"";
                unlock1="123";

                if(userid.equals(null)||userid.equals("")||username.equals(null)||username.equals("")|pin.equals(null)||pin.equals("")){
                    Toast.makeText(register.this, "Enter UserID, Name and Pin", Toast.LENGTH_LONG).show();
                }
                else {


                    splitImage(imageview);
                    }

                }



        });

    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() !=null){
            Uri uri = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                imageview.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private void splitImage(ImageView image) {

        //For the number of rows and columns of the grid to be displayed
        int rows,cols;
        int chunkNumbers=9;
        //For height and width of the small image chunks
        int chunkHeight,chunkWidth;

        //To store all the small image chunks in bitmap format in this list
        ArrayList<Bitmap> chunkedImages = new ArrayList<Bitmap>(chunkNumbers);

        //Getting the scaled bitmap of the source image
        BitmapDrawable drawable = (BitmapDrawable) image.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);

        rows = cols = (int) Math.sqrt(chunkNumbers);
        chunkHeight = bitmap.getHeight()/rows;
        chunkWidth = bitmap.getWidth()/cols;

        //xCoord and yCoord are the pixel positions of the image chunks
        int yCoord = 0;
        for(int x=0; x<rows; x++){
            int xCoord = 0;
            for(int y=0; y<cols; y++){
                chunkedImages.add(Bitmap.createBitmap(scaledBitmap, xCoord, yCoord, chunkWidth, chunkHeight));
                xCoord += chunkWidth;
            }
            yCoord += chunkHeight;
        }

        //imgtest9.setImageBitmap(chunkedImages.get(8));

        db=new DataBaseHelper(register.this);

        byte[] img1=convertToByte(chunkedImages.get(0));
        byte[] img2=convertToByte(chunkedImages.get(1));
        byte[] img3=convertToByte(chunkedImages.get(2));
        byte[] img4=convertToByte(chunkedImages.get(3));
        byte[] img5=convertToByte(chunkedImages.get(4));
        byte[] img6=convertToByte(chunkedImages.get(5));
        byte[] img7=convertToByte(chunkedImages.get(6));
        byte[] img8=convertToByte(chunkedImages.get(7));
        byte[] img9=convertToByte(chunkedImages.get(8));

        if(db.reg(userid,username,img1,img2,img3,img4,img5,img6,img7,img8,img9,unlock1,pin)){
            uidpref = getSharedPreferences("uidprefs", MODE_PRIVATE);
            uideditpref = uidpref.edit();
            uideditpref.putString("uid", userid);
            uideditpref.putString("uname", username);
            uideditpref.commit();
            Toast.makeText(register.this, "userid="+userid+" username="+username+"\nUser Created Successfully\nNow select image pattern", Toast.LENGTH_LONG).show();
            Intent In = new Intent(register.this, picturespotselecting.class);
            startActivity(In);
            finish();
        }
        else{
            Toast.makeText(register.this, "Error Creating User", Toast.LENGTH_LONG).show();
        }




        /*Intent intent = new Intent(register.this, ChunkedImageActivity.class);
        intent.putParcelableArrayListExtra("image chunks", chunkedImages);
        startActivity(intent);*/
    }
    public static byte[] convertToByte(Bitmap bitmap){
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,70,stream);
        return stream.toByteArray();
    }
}
