package com.andersen.caroline.galgeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class VinderFragment extends Fragment {

    Galgelogik spil;
    TextView antalForsøgTekst;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vinder, container, false);

        spil = new Galgelogik();
        antalForsøgTekst = view.findViewById(R.id.antalForsøgTekst);

        antalForsøgTekst.setText("Du brugte " + spil.getAntalForkerteBogstaver() + " forsøg");

        return view;
    }
}
