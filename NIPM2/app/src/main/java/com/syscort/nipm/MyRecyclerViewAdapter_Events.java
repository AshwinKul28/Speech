package com.syscort.nipm;

/**
 * Created by Ashwin on 18/01/17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;



public class MyRecyclerViewAdapter_Events extends RecyclerView
        .Adapter<MyRecyclerViewAdapter_Events
        .DataObjectHolder> {
    private static String LOG_TAG = "com.iashwin28.vishwa_app.MyRecyclerViewAdapter";
    private ArrayList<DataObject1> mDataset;
    private static MyClickListener myClickListener;
    RecyclerView rv;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView dateTime;
        TextView school;
        TextView phone;

        public DataObjectHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            myClickListener.onItemClick(getAdapterPosition(), v);


            int i = getPosition();

        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;



    }

    public MyRecyclerViewAdapter_Events(ArrayList<DataObject1> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_row_events, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.label.setText(mDataset.get(position).getmText1());



//        holder.school.setText(mDataset.get(position).getmText3());
//        holder.phone.setText(mDataset.get(position).getmText4());
    }

    public void addItem(DataObject1 dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);

    }


}