package com.example.testbottomnavigationactivity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testbottomnavigationactivity.sqlite_pack.AsyncHelper;
import com.example.testbottomnavigationactivity.sqlite_pack.OnCustomListener;

import java.util.ArrayList;

public class NotificaFrag extends Fragment {

    private RecyclerView recyclerView;

    private RecyclerCustomAdapter adapter;

    private ArrayList<Test>  returnedList;


    private ArrayList<String> arr;

    private ArrayList<Test> arrV2;
    private Context mContext;

    private boolean check=false;
    int i = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        i++;
        View v = inflater.inflate(R.layout.notification_frag,container,false);

        arrV2 = new ArrayList<>();
        arrV2.add(new Test("heyy mann","+6011"));
        arrV2.add(new Test("be cool","+6011"));
        arrV2.add(new Test("one at time","+6011"));



        recyclerView = v.findViewById(R.id.recyclerID);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



            adapter = new RecyclerCustomAdapter(getActivity(), new ArrayList<Test>());

        final View j =v;

        Log.i("checkk"," before on success i: " + i);

      //  recyclerView.setAdapter(adapter);


        AsyncHelper help = new AsyncHelper(getActivity(), new OnCustomListener() {
            @Override
            public void onSucces(ArrayList<Test> tt) {

                returnedList=tt;
//                adapter.notifyDataSetChanged(); //this is not triggered again
//                recyclerView.setAdapter(adapter);

//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.detach(getTargetFragment()).attach(getTargetFragment()).commit();

                Log.i("checkk"," size ada: " + returnedList.size());

                Log.i("checkk"," HEREEE i: " + i);

                adapter = new RecyclerCustomAdapter(getActivity(), returnedList);

                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
                //problem is it is not drawn

            }

            @Override
            public void onFailure(Exception e) {

            }
        },arrV2);

        help.execute();

        Log.i("checkk"," after on success i: " + i);


        //we set our own listener
        //adapter.notifyDataSetChanged(); //this is not triggered again

        recyclerView.setAdapter(adapter);


        return v;

    }

}
