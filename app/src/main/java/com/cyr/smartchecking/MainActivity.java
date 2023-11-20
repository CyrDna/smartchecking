package com.cyr.smartchecking;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure activity_main.xml exists and contains a RecyclerView with the ID 'recycler'
        recyclerView = findViewById(R.id.recycler);

        String[] name ={
                "Pierre",
                "Behanzin",
                "Cyriaque",
                "Aspartic ",
                "Elodie",
                "Glutamic ",
                "Gildas",
        };
        String[] status = {
                "Etudiant",
                "Etudiant",
                "Etudiant",
                "Etudiant",
                "Etudiant",
                "Etudiant",
                "Etudiant",
        };
        String[] scan = {
                "Manuel",
                "Manuel",
                "Manuel",
                "Manuel",
                "Manuel",
                "Manuel",
                "Manuel",
        };
        String[] motif = {
                "Visite",
                "Visite",
                "Visite",
                "Etudes",
                "Etudes",
                "Etudes",
                "Etudes",
        };
        String[] carte = {
                "CNI",
                "CNI",
                "CNI",
                "CNI",
                "CNI",
                "CNI",
                "CNI",
        };
        String[] hentre = {
                "9h",
                "9h",
                "9h",
                "9h",
                "9h",
                "9h",
                "9h",
        };
        String[] hsortie = {
                "19h",
                "19h",
                "19h",
                "19h",
                "19h",
                "19h",
                "19h",
        };
        int[] photo = {
                R.drawable.user_profile,
                R.drawable.user_profile,
                R.drawable.user_profile,
                R.drawable.user_profile,
                R.drawable.annuler,
                R.drawable.annuler,
                R.drawable.annuler,
        };


        String[] nbrpersonne ={
                "1",
                "1",
                "1",
                "3",
                "5",
                "7",
                "9",
        };
        String[] taffs ={
                "CERCO",
                "CERCO",
                "CERCO",
                "CERCO",
                "CERCO",
                "CERCO",
                "CERCO",
        };

        adapter = new Adapter(this, name, status, scan, motif, carte, hentre, hsortie, photo, nbrpersonne, taffs);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1)); // Set spanCount to 1 for a single column
    }

}
