package com.andersen.caroline.galgeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class RedigerOrdFragment extends Fragment {
    ArrayList<OrdListeItem> ordListe;

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private EditText indtastOrd;
    private Button tilføjOrd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rediger_ord, container, false);

        ordListe = new ArrayList<>();
        ordListe.add(new OrdListeItem("ære"));
        ordListe.add(new OrdListeItem("abe"));
        ordListe.add(new OrdListeItem("bagdør"));
        ordListe.add(new OrdListeItem("drøfte"));
        ordListe.add(new OrdListeItem("evner"));
        ordListe.add(new OrdListeItem("farve"));
        ordListe.add(new OrdListeItem("formel"));
        ordListe.add(new OrdListeItem("følsom"));
        ordListe.add(new OrdListeItem("gryde"));
        ordListe.add(new OrdListeItem("idol"));
        ordListe.add(new OrdListeItem("mønter"));
        ordListe.add(new OrdListeItem("nudler"));
        ordListe.add(new OrdListeItem("sejer"));
        ordListe.add(new OrdListeItem("slæbe"));
        ordListe.add(new OrdListeItem("tæer"));
        ordListe.add(new OrdListeItem("øgler"));
        ordListe.add(new OrdListeItem("adgang"));
        ordListe.add(new OrdListeItem("advarsel"));
        ordListe.add(new OrdListeItem("baseball"));
        ordListe.add(new OrdListeItem("begravet"));

        indtastOrd = v.findViewById(R.id.indtastOrd);
        tilføjOrd = v.findViewById(R.id.tilføjOrd);

        tilføjOrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tilføjItem();
            }
        });

        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new ItemAdapter(ordListe);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                fjernItem(position);
            }
        });

        return v;
    }

    public void fjernItem(int position) {
        ordListe.remove(position);
        adapter.notifyItemRemoved(position);
    }
    
    public void tilføjItem() {
        ordListe.add(new OrdListeItem(indtastOrd.getText().toString()));
        adapter.notifyDataSetChanged();
    }
}
