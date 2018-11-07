package com.andersen.caroline.galgeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment implements View.OnClickListener {

    Button nytSpil, highScore, indstillinger, hjælp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        nytSpil = v.findViewById(R.id.nytSpil);
        highScore = v.findViewById(R.id.highScore);
        indstillinger = v.findViewById(R.id.indstillinger);
        hjælp = v.findViewById(R.id.hjælp);

        nytSpil.setOnClickListener(this);
        highScore.setOnClickListener(this);
        indstillinger.setOnClickListener(this);
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
            case R.id.highScore:
                FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.frameLayout, new HighScoreFragment()).addToBackStack("tilbage");
                fragmentTransaction2.commit();
                break;
            case R.id.indstillinger:
                FragmentTransaction fragmentTransaction3 = getFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.frameLayout, new IndstillingerFragment()).addToBackStack("tilbage");
                fragmentTransaction3.commit();
                break;
            case R.id.hjælp:
                FragmentTransaction fragmentTransaction4 = getFragmentManager().beginTransaction();
                fragmentTransaction4.replace(R.id.frameLayout, new HjaelpFragment()).addToBackStack("tilbage");
                fragmentTransaction4.commit();
                break;
        }
    }
}
