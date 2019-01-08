package com.andersen.caroline.galgeapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.frameLayout, new MenuFragment());
        fragmentTransaction.commit();
    }

    public void saveScores(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("scores", Context.MODE_PRIVATE);
        
    }
}
