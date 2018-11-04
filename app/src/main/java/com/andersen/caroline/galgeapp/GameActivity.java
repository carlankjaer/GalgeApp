package com.andersen.caroline.galgeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    Galgelogik spil;
    private EditText bogstav;
    private TextView ord, forkertBogstav;
    private Button tjekBogstav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        spil = new Galgelogik();
        bogstav = findViewById(R.id.bogstav);
        tjekBogstav = findViewById(R.id.tjekBogstav);
        ord = findViewById(R.id.ord);
        forkertBogstav = findViewById(R.id.forkertBogstav);

        spil.nulstil();
        try {
            spil.hentOrdFraDr();
        } catch (Exception e) {
            e.printStackTrace();
        }
        spil.logStatus();

        ord.setText(spil.getSynligtOrd());

        tjekBogstav.setOnClickListener(this);
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
                findViewById(R.id.hoved).setVisibility(View.VISIBLE);
                break;
            case 2:
                findViewById(R.id.krop).setVisibility(View.VISIBLE);
                break;
            case 3:
                findViewById(R.id.arm1).setVisibility(View.VISIBLE);
                break;
            case 4:
                findViewById(R.id.arm2).setVisibility(View.VISIBLE);
                break;
            case 5:
                findViewById(R.id.ben1).setVisibility(View.VISIBLE);
                break;
            case 6:
                findViewById(R.id.ben2).setVisibility(View.VISIBLE);
                break;
        }
        if(spil.erSpilletTabt())
            findViewById(R.id.tabtSpil).setVisibility(View.VISIBLE);
        if (spil.erSpilletVundet())
            findViewById(R.id.spilletErVundet).setVisibility(View.VISIBLE);
    }
}
