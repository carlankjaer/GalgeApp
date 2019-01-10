package com.andersen.caroline.galgeapp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class BrugernavnDialog extends AppCompatDialogFragment {
    private EditText editTextBrugernavn;
    private BrugernavnDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("Hvad hedder du?")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.frameLayout, new MenuFragment()).addToBackStack("tilbage");
                        fragmentTransaction1.commit();
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String brugernavn = editTextBrugernavn.getText().toString();
                        listener.gemBrugernavn(brugernavn);
                    }
                });

        editTextBrugernavn = view.findViewById(R.id.brugernavn);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (BrugernavnDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " skal implementere brugernavn dialog listener");
        }
    }

    public interface BrugernavnDialogListener {
        void gemBrugernavn(String brugernavn);
    }
}
