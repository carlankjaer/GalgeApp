package com.andersen.caroline.galgeapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HighScoreFragment extends Fragment {
    private ArrayList<HighscoreItem> highscoreList;
    private String nyScore;
    private String highscore;
    private String nytBrugernavn;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_high_score, container, false);

        SharedPreferences mitBrugernavn = getContext().getSharedPreferences("Mit brugernavn", Context.MODE_PRIVATE);
        nytBrugernavn = mitBrugernavn.getString("brugernavn", "");

        highscoreList = new ArrayList<>();
        highscoreList.add(new HighscoreItem("Caroline", ""+300));
        highscoreList.add(new HighscoreItem("Lone", ""+300));

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new HighscoreAdapter(highscoreList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        indsætHighscore();

        return view;
    }

    public void indsætHighscore() {
        SharedPreferences minScore = getContext().getSharedPreferences("Min score", Context.MODE_PRIVATE);
        nyScore = minScore.getString("score", "");

        highscoreList.add(new HighscoreItem(nytBrugernavn, "" + nyScore));
        adapter.notifyDataSetChanged();
    }

    public void compareTo(String highscore, String nyScore) {
    }
}
