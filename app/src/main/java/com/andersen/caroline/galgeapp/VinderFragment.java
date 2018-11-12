package com.andersen.caroline.galgeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class VinderFragment extends Fragment {

    TextView antalForsøgTekst;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vinder, container, false);

        antalForsøgTekst = view.findViewById(R.id.antalForsøgTekst);

        Bundle bundle = this.getArguments();

        antalForsøgTekst.setText("Du brugte " + bundle.getInt("antalForsøg") + " forsøg");

        return view;
    }
}
