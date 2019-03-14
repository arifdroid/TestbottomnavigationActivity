package com.example.testbottomnavigationactivity.sqlite_pack;

import android.provider.BaseColumns;

public final class InsertData_SQLite_Contract {

    public InsertData_SQLite_Contract(){

    }

    public static class InsertData implements BaseColumns{

        public static final String TABLE_NAME = "test_data";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE = "phone";

    }
}
