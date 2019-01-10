package com.andersen.caroline.galgeapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BrugernavnDialog.BrugernavnDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.frameLayout, new MenuFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void gemBrugernavn(String brugernavn) {
        //Gem indtastet brugernavn
        SharedPreferences mitBrugenavn = getSharedPreferences("Mit brugernavn", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mitBrugenavn.edit();
        editor.putString("brugernavn", brugernavn);
        editor.apply();
    }
}
