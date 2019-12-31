package android.example.android.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;


public class sqlite extends SQLiteOpenHelper {


    public sqlite(Context context ) {
        super(context, "Login.db", null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Userinfo(username text primary key,password text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    public boolean insert(String user,String Pass){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",Pass);
        long result=  db.insert("Userinfo",null,contentValues);
        if(result==-1){
            return false;
        }else
            return true;

    }
    public boolean checkEmail(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * From Userinfo where username=?",new String[]{email});
        if(cursor.getCount()>0){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor checkpass(String email, String Pass){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * From Userinfo",null);
        //String[] s=new String[]{cursor.getString(0),cursor.getString(1)};
        return cursor;




    }
}
