package com.andersen.caroline.galgeapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class VinderFragment extends Fragment implements View.OnClickListener {

    MediaPlayer player;
    KonfettiView viewKonfetti;
    TextView antalForsøgTekst, dinScore;
    Button prøvIgen, tilStart;
    String nyScore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vinder, container, false);

        viewKonfetti = v.findViewById(R.id.viewKonfetti);
        antalForsøgTekst = v.findViewById(R.id.antalForsøgTekst);
        dinScore = v.findViewById(R.id.dinScore);
        prøvIgen = v.findViewById(R.id.prøvIgen);
        tilStart = v.findViewById(R.id.tilStart);

        prøvIgen.setOnClickListener(this);
        tilStart.setOnClickListener(this);

        Bundle bundle = this.getArguments();

        SharedPreferences minScore = getContext().getSharedPreferences("Min score", Context.MODE_PRIVATE);
        nyScore = minScore.getString("score", "");

        antalForsøgTekst.setText("Du brugte " + bundle.getInt("antalForsøg") + " forsøg");
        dinScore.setText("Din score: " + nyScore);

        player = MediaPlayer.create(this.getActivity(), R.raw.winner_sound);
        player.start();

        viewKonfetti.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(359.0, 0.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12, 5))
                .setPosition(-50f, viewKonfetti.getWidth() + 50f, -50f, -50f)
                .streamFor(100, 3000L);

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
