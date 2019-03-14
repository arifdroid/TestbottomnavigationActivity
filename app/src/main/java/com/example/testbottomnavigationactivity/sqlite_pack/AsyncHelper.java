package com.example.testbottomnavigationactivity.sqlite_pack;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.testbottomnavigationactivity.Test;

import java.util.ArrayList;

public class AsyncHelper extends AsyncTask<Void,Void, ArrayList<Test>> {

    private OnCustomListener mCallback;
    private Context context;
    public Exception exception;

    private ArrayList<Test> tests;

    public AsyncHelper(Context context, OnCustomListener onCustomListener){
        this.context =context;
        this.mCallback = onCustomListener;
    }

    public AsyncHelper(Context context, OnCustomListener onCustomListener, ArrayList<Test> list){
        this.context =context;
        this.mCallback = onCustomListener;
        this.tests = list;
    }



    @Override
    protected ArrayList<Test> doInBackground(Void... voids) {

        //here we create database.
        InsertData_SQLite_DB_Helper object =  InsertData_SQLite_DB_Helper.getInstance(context,tests);

        Log.i("checkk success ", " : check async helper returned");



        return new ArrayList<>(object.get_AllTest_List());
    }

    @Override
    protected void onPostExecute(ArrayList<Test> list) {
      //  super.onPostExecute(list);

        if(mCallback!=null){

            if(exception==null){

                mCallback.onSucces(list);

            }else {
                mCallback.onFailure(exception);
            }

        }
    }
}
