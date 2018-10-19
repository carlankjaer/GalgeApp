package com.andersen.caroline.galgeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button nytSpil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nytSpil = findViewById(R.id.nytSpil);

        nytSpil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        
    }
}
