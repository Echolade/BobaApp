package com.example.boba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.myViewholder> {

    private ArrayList<Data> cardinfo;

    // constructor
    public recyclerAdapter(ArrayList<Data> cardinfo) {

        this.cardinfo = cardinfo;
    }

    //references each element to the xml element
    public class myViewholder extends RecyclerView.ViewHolder {

        TextView bobaplace, description;
        ImageView logos;
//        RelativeLayout my_row;

        public myViewholder(@NonNull View itemView) {
            super(itemView);

            bobaplace = itemView.findViewById(R.id.bobaplace);
            description = itemView.findViewById(R.id.description);
            logos = itemView.findViewById(R.id.logos);
//            my_row = itemView.findViewById(R.id.my_row);
        }
    }


    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(context);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent,false);
//        MyViewholder ehv = new MyViewholder(view);
        return new myViewholder (view);

    }
    // attaches each input to its respective area in the xml
    @Override
    public void onBindViewHolder(@NonNull myViewholder holder, int position) {

        Data item = cardinfo.get(position);

        holder.bobaplace.setText(item.getBobaplace());
        holder.description.setText(item.getDescription());
        holder.logos.setImageResource(item.getLogos());


//        click on row to open new activity

//        holder.my_row.setOnClickListener(new View.OnClickListener());
    }

//    how long the recycle viewer goes for
    @Override
    public int getItemCount() {

        return cardinfo.size();
    }



    // searchview control filtering


//    @Override
//    public Filter getFilter() {
//
//        return examplefilter;
//
//        private Filter examplefilter = new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                  = new ArrayList<>();
//
//                if (constraint == null || constraint.length() == 0) {
//                    data1.addAll(fullist);
//                } else {
//                    for (String )
//                }
//            }
//
//            @Override
//            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//
//            }
//        };
//    }
}











