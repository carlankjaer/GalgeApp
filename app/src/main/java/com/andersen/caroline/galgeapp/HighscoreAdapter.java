package com.andersen.caroline.galgeapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HighscoreAdapter extends RecyclerView.Adapter<HighscoreAdapter.HighscoreViewHolder> {
    private ArrayList<HighscoreItem> highscoreList;

    public static class HighscoreViewHolder extends RecyclerView.ViewHolder {
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;

        public HighscoreViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.placering);
            textView2 = itemView.findViewById(R.id.highscoreNavn);
            textView3 = itemView.findViewById(R.id.highscore);
        }
    }

    public HighscoreAdapter(ArrayList<HighscoreItem> highscoreList) {
        this.highscoreList = highscoreList;
    }

    @NonNull
    @Override
    public HighscoreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.highscore_item, viewGroup, false);
        HighscoreViewHolder highscoreViewHolder = new HighscoreViewHolder(v);
        return highscoreViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HighscoreViewHolder highscoreViewHolder, int position) {
        HighscoreItem currentItem = highscoreList.get(position);

        highscoreViewHolder.textView1.setText(currentItem.getPlacering());
        highscoreViewHolder.textView2.setText(currentItem.getHighscoreNavn());
        highscoreViewHolder.textView3.setText(currentItem.getHighscore());
    }

    @Override
    public int getItemCount() {
        return highscoreList.size();
    }
}
