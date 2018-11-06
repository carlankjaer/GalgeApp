package com.andersen.caroline.galgeapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    Galgelogik spil;
    private EditText bogstav;
    private TextView ord, forkertBogstav, load;
    private Button tjekBogstav;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        spil = new Galgelogik();
        bogstav = findViewById(R.id.bogstav);
        tjekBogstav = findViewById(R.id.tjekBogstav);
        ord = findViewById(R.id.ord);
        forkertBogstav = findViewById(R.id.forkertBogstav);
        load = findViewById(R.id.load);
        progressBar = findViewById(R.id.progressBar);

        class AsyncTask1 extends AsyncTask {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar.setVisibility(View.VISIBLE);
                load.setVisibility(View.VISIBLE);
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
                load.setVisibility(View.INVISIBLE);
                tjekBogstav.setEnabled(true);
                bogstav.setEnabled(true);
                spil.nulstil();
                spil.logStatus();
                ord.setText(spil.getSynligtOrd());
            }
        }
        new AsyncTask1().execute();

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
            
        if (spil.erSpilletVundet())

    }
}
