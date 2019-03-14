package com.example.testbottomnavigationactivity.sqlite_pack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.testbottomnavigationactivity.Test;

import java.util.ArrayList;

import static com.example.testbottomnavigationactivity.sqlite_pack.InsertData_SQLite_Contract.*;

public class InsertData_SQLite_DB_Helper extends SQLiteOpenHelper {


//    public InsertData_SQLite_DB_Helper( Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }

    private static ArrayList<Test> liss;


    public static final String DATABASE_NAME = "FS_SQLiteDB";

    public static final int DATABASE_VERSION=1;

    private static InsertData_SQLite_DB_Helper instance;

    private SQLiteDatabase db;

    public InsertData_SQLite_DB_Helper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized InsertData_SQLite_DB_Helper getInstance(Context context, ArrayList<Test> ss){
            if(instance == null){
                    instance = new InsertData_SQLite_DB_Helper(context);
            }

            liss=ss;
            return instance;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db =db;

        final String TEST_TABLE = "CREATE TABLE "+
                InsertData.TABLE_NAME +" ( "+
                InsertData._ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                InsertData.COLUMN_NAME + " TEXT, "+
                InsertData.COLUMN_PHONE + " TEXT"+
                " ) ";
        db.execSQL(TEST_TABLE);

        addToTable(liss);




    }

    private void addToTable(ArrayList<Test> liss) {

        for(int i=0; i<liss.size();i++) {
            //     h++;
            //    Log.i("checkk flow SQ","h :"+h+" : sqlite count");

            Test employee = liss.get(i);

            ContentValues cv = new ContentValues();

            cv.put(InsertData.COLUMN_NAME, employee.getName());
            cv.put(InsertData.COLUMN_PHONE, employee.getPhone());
            db.insert(InsertData.TABLE_NAME, null, cv);
        }

        Log.i("checkk success ", " : database created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Test> get_AllTest_List(){

        Log.i("checkk flow SQ","sqlite called");
        ArrayList<Test> returnList =new ArrayList<>();

        db = getReadableDatabase();

        Cursor c =db.rawQuery("SELECT *FROM "+ InsertData.TABLE_NAME, null);

        if(c.moveToFirst()){

            do{

                Test employee = new Test();

                employee.setName(c.getString(c.getColumnIndex(InsertData.COLUMN_NAME)));
                employee.setPhone(c.getString(c.getColumnIndex(InsertData.COLUMN_PHONE)));



                returnList.add(employee);

            }while (c.moveToNext());


        }

        c.close();

        Log.i("checkk success ", " : database returned");

        return returnList;
    }
}
