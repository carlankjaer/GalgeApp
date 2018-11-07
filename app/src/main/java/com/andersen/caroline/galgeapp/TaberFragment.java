package com.andersen.caroline.galgeapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TaberFragment extends Fragment {

    Galgelogik spil;
    TextView rigtigtOrd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_taber, container, false);

        spil = new Galgelogik();
        rigtigtOrd = view.findViewById(R.id.rigtigtOrd);

        rigtigtOrd.setText("Ordet var: ");

        return view;
    }
}
