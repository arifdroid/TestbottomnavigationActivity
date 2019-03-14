package com.example.testbottomnavigationactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testbottomnavigationactivity.sqlite_pack.AsyncHelper;
import com.example.testbottomnavigationactivity.sqlite_pack.OnCustomListener;

import java.util.ArrayList;

class RecyclerCustomAdapter extends RecyclerView.Adapter<RecyclerCustomAdapter.InsideHolder> {

    private ArrayList<Test> hereList;

    private ArrayList<Test> returnedList;

    private Context mContext;



    public RecyclerCustomAdapter(Context context,ArrayList<Test> arr){

        this.mContext = context;
        this.hereList=arr;
    }

    @NonNull
    @Override
    public InsideHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //return null;

        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_list_card, viewGroup,false);

        return new InsideHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull InsideHolder insideHolder, int i) {



        insideHolder.textView.setText(hereList.get(i).getName());


    }

    @Override
    public int getItemCount() {
        return hereList.size();
    }

    public class InsideHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        public InsideHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textViewCustomID);
        }
    }
}
