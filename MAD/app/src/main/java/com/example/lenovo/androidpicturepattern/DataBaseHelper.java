package com.example.lenovo.androidpicturepattern;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper (Context context){
        super (context,"picturepattern",null,1);
    }
    public static final String col1="userid";
    public static final String col2="name";
    public static final String col3="part1";
    public static final String col4="part2";
    public static final String col5="part3";
    public static final String col6="part4";
    public static final String col7="part5";
    public static final String col8="part6";
    public static final String col9="part7";
    public static final String col10="part8";
    public static final String col11="part9";
    public static final String col12="unl1";
    public static final String col13="pin";
    public static final String tableName="userappl";



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+tableName+"("+col1+" text,"+col2+" text,"+col3+" blob,"+col4+" blob,"+col5+" blob,"+col6+" blob,"+col7+" blob,"+col8+" blob,"+col9+" blob,"+col10+" blob,"+col11+" blob,"+col12+" text,"+col13+" text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if EXISTS "+tableName);
    }
    public boolean reg(String uid, String uname, byte[] part1, byte[] part2, byte[] part3, byte[] part4, byte[] part5, byte[] part6, byte[] part7, byte[] part8,byte[] part9,String unlock1,String pin){
        System.out.println("Username"+uname+"\nUser ID"+uid);
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col1,uid);
        contentValues.put(col2,uname);
        contentValues.put(col3,part1);
        contentValues.put(col4,part2);
        contentValues.put(col5,part3);
        contentValues.put(col6,part4);
        contentValues.put(col7,part5);
        contentValues.put(col8,part6);
        contentValues.put(col9,part7);
        contentValues.put(col10,part8);
        contentValues.put(col11,part9);
        contentValues.put(col12,unlock1);
        contentValues.put(col13,pin);

        long res=sqLiteDatabase.insert(tableName,null,contentValues);
        if (res==-1){
            return false;
        }
        else{
            return true;
        }

    }
    public Cursor getSelMember(String uid)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor res;
        res=sqLiteDatabase.rawQuery("select "+col2+" from "+tableName+" where "+col1+"='"+uid+"'",null);
        return res;
    }
    public Cursor getSelImg(String uid)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor res;
        res=sqLiteDatabase.rawQuery("select "+col3+","+col4+","+col5+","+col6+","+col7+","+col8+","+col9+","+col10+","+col11+","+col12+" from "+tableName+" where "+col1+"='"+uid+"'",null);
        return res;
    }
    public boolean updatelock(String uid,String ul){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col12,ul);
        long res=sqLiteDatabase.update(tableName,cv,col1+"="+uid,null);

        if(res==-1) {
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getpin(String uid)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor res;
        res=sqLiteDatabase.rawQuery("select "+col13+" from "+tableName+" where "+col1+"='"+uid+"'",null);
        return res;
    }
}
