package com.andersen.caroline.galgeapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    private ArrayList<ExampleItem> ordListe;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView listeOrd;

        public MyViewHolder(View itemView) {
            super(itemView);
            listeOrd = itemView.findViewById(R.id.listeOrd);
        }
    }

    public ItemAdapter(ArrayList<ExampleItem> ordListe) {
        this.ordListe = ordListe;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_item, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        ExampleItem currentItem = ordListe.get(position);

        viewHolder.listeOrd.setText(currentItem.getListeOrd());
    }

    @Override
    public int getItemCount() {
        return ordListe.size();
    }
}
