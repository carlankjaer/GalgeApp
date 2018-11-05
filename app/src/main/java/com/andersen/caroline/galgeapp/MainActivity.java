package com.andersen.caroline.galgeapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Galgelogik spil;
    Button nytSpil, highScore, indstillinger, hjælp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spil = new Galgelogik();
        nytSpil = findViewById(R.id.nytSpil);
        highScore = findViewById(R.id.highScore);
        indstillinger = findViewById(R.id.indstillinger);
        hjælp = findViewById(R.id.hjælp);

        nytSpil.setOnClickListener(this);
        highScore.setOnClickListener(this);
        indstillinger.setOnClickListener(this);
        hjælp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == nytSpil) {

            Intent intent1 = new Intent(this, GameActivity.class);
            startActivity(intent1);

        }
    }
}
