package com.andersen.caroline.galgeapp;

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
    TextView rigtigtOrd;
    Button prøvIgen, tilStart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_taber, container, false);

        spil = new Galgelogik();
        rigtigtOrd = v.findViewById(R.id.rigtigtOrd);
        prøvIgen = v.findViewById(R.id.prøvIgen);
        tilStart = v.findViewById(R.id.tilStart);

        prøvIgen.setOnClickListener(this);
        tilStart.setOnClickListener(this);

        Bundle bundle = this.getArguments();

        rigtigtOrd.setText("Ordet var: " + bundle.getString("ord"));

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
