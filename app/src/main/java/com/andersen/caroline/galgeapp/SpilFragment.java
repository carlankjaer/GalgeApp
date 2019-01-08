package com.andersen.caroline.galgeapp;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SpilFragment extends Fragment implements View.OnClickListener {

    Galgelogik spil;

    private EditText bogstav;
    private TextView ord, forkertBogstav;
    private Button tjekBogstav;
    private int score;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spil, container, false);

        spil = new Galgelogik();
        bogstav = view.findViewById(R.id.bogstav);
        tjekBogstav = view.findViewById(R.id.tjekBogstav);
        ord = view.findViewById(R.id.ord);
        forkertBogstav = view.findViewById(R.id.forkertBogstav);

        tjekBogstav.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        class AsyncTask1 extends AsyncTask {

            ProgressDialog progressDialog;

            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    spil.hentOrdFraDr();
                    return "Ordene blev korrekt hentet fra DR's server";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "Ordene blev ikke hentet korrekt: "+e;
                }
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(getActivity(), "ProgressDialog", "Vent venligst");
            }

            @Override
            protected void onPostExecute(Object resultat) {
                spil.logStatus();
                ord.setText(spil.getSynligtOrd());
                progressDialog.dismiss();
            }
        }
        new AsyncTask1().execute();
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
            Bundle bundle = new Bundle();
            bundle.putString("ord", spil.getOrdet());

            TaberFragment taberFragment = new TaberFragment();
            taberFragment.setArguments(bundle);

            FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
            fragmentTransaction2.replace(R.id.frameLayout, taberFragment).addToBackStack(null);
            fragmentTransaction2.commit();
        }

        if (spil.erSpilletVundet()) {
            Bundle bundle = new Bundle();
            bundle.putInt("antalForsøg", spil.getAntalForkerteBogstaver());

            VinderFragment vinderFragment = new VinderFragment();
            vinderFragment.setArguments(bundle);

            FragmentTransaction fragmentTransaction3 = getFragmentManager().beginTransaction();
            fragmentTransaction3.replace(R.id.frameLayout, vinderFragment).addToBackStack(null);
            fragmentTransaction3.commit();
        }
    }
}
