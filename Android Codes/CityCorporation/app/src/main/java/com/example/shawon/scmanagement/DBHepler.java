package com.example.shawon.scmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHepler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "City.db";
    public static final String CONTACTS_TABLE_NAME = "Admin";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_STUDENTNAME = "name";
    public static final String CONTACTS_COLUMN_TEACHERNAME = "teachername";




















    public DBHepler(Context context) {
        super(context, DATABASE_NAME , null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "create table UserName (id integer primary key, name,userId,pass);create table Problems (id integer primary key, name,title,description,location);";



              sqLiteDatabase.execSQL(sql);




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS UserName;DROP TABLE IF EXISTS Problems");

        onCreate(sqLiteDatabase);
    }
    public boolean SignUp(String studentN, String studentI, String studentP) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", studentN);
        contentValues.put("userId", studentI);
        contentValues.put("pass", studentP);

        db.insert("UserName", null, contentValues);
        return true;
    }
 /*   public boolean insertAttendance (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);

        db.insert("Attendance", null, contentValues);
        return true;
    }    */
public Cursor GetStudentName(){
SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

    Cursor res =  sqLiteDatabase.rawQuery( "select * from Problems", null );
    return res;
}


    public int LogIn(String userId,String pass){
        int affectedRowCount=0;
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        Cursor res =  sqLiteDatabase.rawQuery( "select name from UserName where userId='"+userId+"' and "+"pass='"+pass+"';", null);

        if(res != null && res.getCount() > 0 && res.moveToFirst())
        {
            affectedRowCount = 1;

        }
        else
        {
            // Some error occurred?
        }

        return affectedRowCount;
    }
    public void delete(String id) {SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from student where userId='"+id+"'");
    }
    public boolean Assign(String Semester,String Section,String studentN, String studentI) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pass", Semester);
        contentValues.put("pass", Section);
        contentValues.put("name", studentN);
        contentValues.put("userId", studentI);


        db.insert("Student", null, contentValues);
        return true;
    }



}























