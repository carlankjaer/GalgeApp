package com.andersen.caroline.galgeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class VinderFragment extends Fragment implements View.OnClickListener {

    TextView antalForsøgTekst, dinScore;
    Button prøvIgen, tilStart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vinder, container, false);

        antalForsøgTekst = v.findViewById(R.id.antalForsøgTekst);
        dinScore = v.findViewById(R.id.dinScore);
        prøvIgen = v.findViewById(R.id.prøvIgen);
        tilStart = v.findViewById(R.id.tilStart);

        prøvIgen.setOnClickListener(this);
        tilStart.setOnClickListener(this);

        Bundle bundle = this.getArguments();

        antalForsøgTekst.setText("Du brugte " + bundle.getInt("antalForsøg") + " forsøg");

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
