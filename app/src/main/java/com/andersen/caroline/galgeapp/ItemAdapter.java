package com.andersen.caroline.galgeapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    private ArrayList<OrdListeItem> ordListe;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView listeOrd;
        public ImageView deleteIcon;

        public MyViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            listeOrd = itemView.findViewById(R.id.listeOrd);
            deleteIcon = itemView.findViewById(R.id.deleteIcon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            deleteIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public ItemAdapter(ArrayList<OrdListeItem> ordListe) {
        this.ordListe = ordListe;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ord_liste_item, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(v, listener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        OrdListeItem currentItem = ordListe.get(position);

        viewHolder.listeOrd.setText(currentItem.getListeOrd());
    }

    @Override
    public int getItemCount() {
        return ordListe.size();
    }
}
