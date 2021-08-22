package com.example.boba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.myViewholder>  {

    String data1 [], data2[];
    String fullist [];
    Context context;
    int images[];

    // constructor
    public recyclerAdapter(Context ct, String bobaplace[], String description[], int logos[]) {

        context = ct;
        data1 = bobaplace;
        data2 = description;
        images = logos;

        this.data1 = bobaplace;
        this.fullist = new ArrayList<>(data1);
    }

    //references each element to the xml element
    public class myViewholder extends RecyclerView.ViewHolder {

        TextView bobaplace, description;
        ImageView logos;
        RelativeLayout my_row;

        public myViewholder(@NonNull View itemView) {
            super(itemView);

            bobaplace = itemView.findViewById(R.id.bobaplace);
            description = itemView.findViewById(R.id.description);
            logos = itemView.findViewById(R.id.logos);
            my_row = itemView.findViewById(R.id.my_row);
        }
    }


    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent,false);
        return new myViewholder (view);

    }
    // attaches each input to its respective area in the xml
    @Override
    public void onBindViewHolder(@NonNull myViewholder holder, int position) {
        holder.bobaplace.setText(data1[position]);
        holder.description.setText(data2[position]);
        holder.logos.setImageResource(images[position]);


//        click on row to open new activity

//        holder.my_row.setOnClickListener(new View.OnClickListener());
    }

//    how long the recycle viewer goes for
    @Override
    public int getItemCount() {

        return images.length;
    }



    // searchview control filtering


//    @Override
//    public Filter getFilter() {
//
//        return examplefilter;
//
//        private Filter examplefilter = new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence charSequence) {
//                 List<String> filteredList = new ArrayList<>();
//
//                 if (charSequence.toString().isEmpty()) {
//                     filteredlist.addall(fullist);
//                 } else {
//                     for (String )
//                 }
//            }
//
//            @Override
//            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//
//            }
//        };
//    }
}











