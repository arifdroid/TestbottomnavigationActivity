package com.example.testbottomnavigationactivity.sqlite_pack;

import com.example.testbottomnavigationactivity.Test;

import java.util.ArrayList;

public interface OnCustomListener {

     void onSucces(ArrayList<Test> ss);

     void onFailure(Exception e);
}
