package com.andersen.caroline.galgeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment implements View.OnClickListener {

    Button nytSpil, toSpillere, highScore, redigerOrd, hjælp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        nytSpil = v.findViewById(R.id.nytSpil);
        toSpillere = v.findViewById(R.id.toSpillere);
        highScore = v.findViewById(R.id.highScore);
        redigerOrd = v.findViewById(R.id.redigerOrd);
        hjælp = v.findViewById(R.id.hjælp);

        nytSpil.setOnClickListener(this);
        toSpillere.setOnClickListener(this);
        highScore.setOnClickListener(this);
        redigerOrd.setOnClickListener(this);
        hjælp.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nytSpil:
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frameLayout, new SpilFragment()).addToBackStack("tilbage");
                fragmentTransaction1.commit();
                break;
            case R.id.toSpillere:
                FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.frameLayout, new ToSpillereFragment()).addToBackStack("tilbage");
                fragmentTransaction2.commit();
                break;
            case R.id.highScore:
                FragmentTransaction fragmentTransaction3 = getFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.frameLayout, new HighScoreFragment()).addToBackStack("tilbage");
                fragmentTransaction3.commit();
                break;
            case R.id.redigerOrd:
                FragmentTransaction fragmentTransaction4 = getFragmentManager().beginTransaction();
                fragmentTransaction4.replace(R.id.frameLayout, new RedigerOrdFragment()).addToBackStack("tilbage");
                fragmentTransaction4.commit();
                break;
            case R.id.hjælp:
                FragmentTransaction fragmentTransaction5 = getFragmentManager().beginTransaction();
                fragmentTransaction5.replace(R.id.frameLayout, new HjaelpFragment()).addToBackStack("tilbage");
                fragmentTransaction5.commit();
                break;
        }
    }
}
