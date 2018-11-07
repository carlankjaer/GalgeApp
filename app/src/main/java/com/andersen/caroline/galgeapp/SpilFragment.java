package com.andersen.caroline.galgeapp;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SpilFragment extends Fragment implements View.OnClickListener {

    Galgelogik spil;
    private EditText bogstav;
    private TextView ord, forkertBogstav, loadText;
    private Button tjekBogstav;
    private ProgressBar progressBar;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        class AsyncTask1 extends AsyncTask {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar.setVisibility(View.VISIBLE);
                loadText.setVisibility(View.VISIBLE);
                tjekBogstav.setEnabled(false);
                bogstav.setEnabled(false);
            }

            @Override
            protected Object doInBackground(Object... arg0) {
                try {
                    spil.hentOrdFraDr();
                    return "Ordene blev korrekt hentet fra DR's server";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "Ordene blev ikke hentet korrekt: "+e;
                }
            }

            @Override
            protected void onPostExecute(Object resultat) {
                progressBar.setVisibility(View.INVISIBLE);
                loadText.setVisibility(View.INVISIBLE);
                tjekBogstav.setEnabled(true);
                bogstav.setEnabled(true);
                spil.logStatus();
                ord.setText(spil.getSynligtOrd());
            }
        }
        new AsyncTask1().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spil, container, false);

        spil = new Galgelogik();
        bogstav = view.findViewById(R.id.bogstav);
        tjekBogstav = view.findViewById(R.id.tjekBogstav);
        ord = view.findViewById(R.id.ord);
        forkertBogstav = view.findViewById(R.id.forkertBogstav);
        loadText = view.findViewById(R.id.loadText);
        progressBar = view.findViewById(R.id.progressBar);

        tjekBogstav.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        spil.gætBogstav(bogstav.getText().toString());
        ord.setText(spil.getSynligtOrd());
        spil.logStatus();
        if(!spil.erSidsteBogstavKorrekt()) {
            forkertBogstav.append(bogstav.getText().toString() + " ");
        }
        bogstav.getText().clear();

        switch (spil.getAntalForkerteBogstaver()) {
            case 1:
                getView().findViewById(R.id.hoved).setVisibility(View.VISIBLE);
                break;
            case 2:
                getView().findViewById(R.id.krop).setVisibility(View.VISIBLE);
                break;
            case 3:
                getView().findViewById(R.id.arm1).setVisibility(View.VISIBLE);
                break;
            case 4:
                getView().findViewById(R.id.arm2).setVisibility(View.VISIBLE);
                break;
            case 5:
                getView().findViewById(R.id.ben1).setVisibility(View.VISIBLE);
                break;
            case 6:
                getView().findViewById(R.id.ben2).setVisibility(View.VISIBLE);
                break;
        }
        if(spil.erSpilletTabt()) {
            FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
            fragmentTransaction2.replace(R.id.frameLayout, new TaberFragment()).addToBackStack(null);
            fragmentTransaction2.commit();
        }

        if (spil.erSpilletVundet()) {
            FragmentTransaction fragmentTransaction3 = getFragmentManager().beginTransaction();
            fragmentTransaction3.replace(R.id.frameLayout, new VinderFragment()).addToBackStack(null);
            fragmentTransaction3.commit();
        }
    }
}
