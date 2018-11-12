package com.andersen.caroline.galgeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HighScoreFragment extends Fragment {

    ListView highScoreListe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_high_score, container, false);

        ArrayList<String> highScores = new ArrayList<>();
        highScores.add("300");
        highScores.add("500");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, highScores);

        highScoreListe = view.findViewById(R.id.highScoreListe);
        highScoreListe.setAdapter(adapter);

        return view;
    }
}
