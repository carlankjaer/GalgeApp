package com.andersen.caroline.galgeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment implements View.OnClickListener {

    Button nytSpil, highScore, indstillinger, hjælp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        nytSpil = getView().findViewById(R.id.nytSpil);
        highScore = getView().findViewById(R.id.highScore);
        indstillinger = getView().findViewById(R.id.indstillinger);
        hjælp = getView().findViewById(R.id.hjælp);

        // Sætter on click funktion på alle knapper
        nytSpil.setOnClickListener(this);
        highScore.setOnClickListener(this);
        indstillinger.setOnClickListener(this);
        hjælp.setOnClickListener(this);

        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onClick(View v) {
        // Hvis nyt spil knap bliver valgt
        if (v == nytSpil) {

        }
        // Hvis highscore knap bliver valgt
        if (v == highScore) {

        }
        // Hvis indstillinger knap bliver valgt
        if (v == indstillinger) {

        }
        //Hvis hjælp knap bliver valgt
        if (v == hjælp) {

        }
    }
}
