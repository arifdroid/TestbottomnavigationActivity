package com.example.testbottomnavigationactivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeFrag extends Fragment {

    ArrayList<String> ss = new ArrayList<>();

    private Context mContext;


    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.home_frag,container,false);

        ss.add("hello");
        ss.add("progress");
        ss.add("you are");
        ss.add("CRUSHING IT");

        listView = v.findViewById(R.id.listview_homeFragID);

        listView.setAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,ss));



        return v;
    }
}
