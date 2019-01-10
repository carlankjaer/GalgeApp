package com.andersen.caroline.galgeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ToSpillereFragment extends Fragment implements View.OnClickListener {

    Galgelogik spil;

    private EditText bogstav;
    private TextView ord, forkertBogstav;
    private Button tjekBogstav;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_to_spillere, container, false);

        spil = new Galgelogik();
        bogstav = view.findViewById(R.id.bogstav);
        tjekBogstav = view.findViewById(R.id.tjekBogstav);
        ord = view.findViewById(R.id.ord);
        forkertBogstav = view.findViewById(R.id.forkertBogstav);

        tjekBogstav.setOnClickListener(this);

        indlæsValgtOrd();

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

            ToSpillereVinderFragment toSpillereVinderFragment = new ToSpillereVinderFragment();
            toSpillereVinderFragment.setArguments(bundle);

            FragmentTransaction fragmentTransaction3 = getFragmentManager().beginTransaction();
            fragmentTransaction3.replace(R.id.frameLayout, toSpillereVinderFragment).addToBackStack(null);
            fragmentTransaction3.commit();
        }
    }

    public void indlæsValgtOrd() {
        Bundle bundle = this.getArguments();

        if (bundle != null) {
            String valgtOrd = bundle.getString("Valgt ord");
            spil.muligeOrd.clear();
            spil.muligeOrd.add(valgtOrd);
            spil.nulstil();
            ord.setText(spil.getSynligtOrd());
        }
    }
}
