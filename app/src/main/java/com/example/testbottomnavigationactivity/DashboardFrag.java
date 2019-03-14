package com.example.testbottomnavigationactivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DashboardFrag extends Fragment {

    private TextView textView;

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.dash_frag,container,false);

        textView = v.findViewById(R.id.textView_dashID);

        textView.setText("fuck this shit");


        return v;


        //        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
