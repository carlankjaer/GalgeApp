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
                System.out.println("Du trykkede på High score!");
                break;
            case R.id.indstillinger:
                System.out.println("Du trykkede på Indstillinger!");
                break;
            case R.id.hjælp:
                System.out.println("Du trykkede på Hjælp!");
                break;
        }
    }
}
