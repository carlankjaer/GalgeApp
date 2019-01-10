package com.andersen.caroline.galgeapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TaberFragment extends Fragment implements View.OnClickListener {

    Galgelogik spil;
    MediaPlayer player;
    TextView rigtigtOrd, dinScore;
    Button prøvIgen, tilStart;
    String nyScore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_taber, container, false);

        spil = new Galgelogik();
        rigtigtOrd = v.findViewById(R.id.rigtigtOrd);
        dinScore = v.findViewById(R.id.dinScore);
        prøvIgen = v.findViewById(R.id.prøvIgen);
        tilStart = v.findViewById(R.id.tilStart);

        prøvIgen.setOnClickListener(this);
        tilStart.setOnClickListener(this);

        Bundle bundle = this.getArguments();

        SharedPreferences minScore = getContext().getSharedPreferences("Min score", Context.MODE_PRIVATE);
        nyScore = minScore.getString("score", "");

        rigtigtOrd.setText("Ordet var: " + bundle.getString("ord"));
        dinScore.setText("Din score: " + nyScore);

        player = MediaPlayer.create(this.getActivity(), R.raw.loser_sound);
        player.start();

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.prøvIgen) {
            FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
            fragmentTransaction1.replace(R.id.frameLayout, new SpilFragment()).addToBackStack("NULL");
            fragmentTransaction1.commit();
        }
        else if (v.getId() == R.id.tilStart) {
            FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
            fragmentTransaction2.replace(R.id.frameLayout, new MenuFragment()).addToBackStack("tilbage");
            fragmentTransaction2.commit();
        }
    }
}
