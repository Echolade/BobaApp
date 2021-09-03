package com.example.boba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;


public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.myViewholder> implements Filterable {

    List<Data> cardinfo;
    List<Data> cardinfofull;
    private onNoteListener mOnnoteListener;
    private Context context;

    // constructor
    public recyclerAdapter(List<Data> cardinfo, onNoteListener onNoteListener) {

        this.cardinfo = cardinfo;
        this.cardinfofull = new ArrayList<>(cardinfo);
        this.mOnnoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        return new myViewholder(view, mOnnoteListener);

    }

    // attaches each input to its respective area in the xml
    @Override
    public void onBindViewHolder(@NonNull myViewholder holder, int position) {

        Data item = cardinfo.get(position);

        holder.bobaplace.setText(item.getBobaplace());
        holder.description.setText(item.getDescription());
        holder.logos.setImageResource(item.getLogos());

    }

    //    how long the recycle viewer goes for
    @Override
    public int getItemCount() {

        return cardinfo.size();
    }


    //references each element to the xml element
    public class myViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView bobaplace, description;
        ImageView logos;
        onNoteListener onNoteListener;

        public myViewholder(@NonNull View itemView, onNoteListener onNoteListener) {
            super(itemView);
            context = itemView.getContext();
            bobaplace = itemView.findViewById(R.id.bobaplace);
            description = itemView.findViewById(R.id.description);
            logos = itemView.findViewById(R.id.logos);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface onNoteListener {
        void onNoteClick(int position);
    }


    // searchview control filtering
    public Filter getFilter() {

        return examplefilter;
    }

        Filter examplefilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                  List<Data> filteredList= new ArrayList<>();

                  if (charSequence == null || charSequence.length() == 0) {
                    filteredList.addAll(cardinfofull);
                } else {
                      String filteredPattern = charSequence.toString().toLowerCase().trim();

                    for (Data item: cardinfofull) {
                        if(item.getBobaplace().toLowerCase().contains(filteredPattern)) {
                             filteredList.add(item);
                        }
                    }
                }
                  FilterResults results = new FilterResults();
                  results.values = filteredList;

                  return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    cardinfo.clear();
                    cardinfo.addAll((List) filterResults.values);
                    notifyDataSetChanged();
            }
        };
    }












