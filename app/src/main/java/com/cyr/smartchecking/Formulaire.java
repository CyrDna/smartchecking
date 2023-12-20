package com.cyr.smartchecking;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Formulaire extends Activity  {
    private ImageView engImg;
    private ImageButton annulerButton, validerButton;
    private EditText engNom, engSnom, engMail, engNum;
    private AutoCompleteTextView engSex, engMotif, engCarte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);

        // Initialiser les composants de la mise en page
        engImg = findViewById(R.id.engImg);
        engNom = findViewById(R.id.engNom);
        engSnom = findViewById(R.id.engSnom);
        engMail = findViewById(R.id.engMail);
        engNum = findViewById(R.id.engNum);

        engSex = findViewById(R.id.engSex);
        engMotif = findViewById(R.id.engMotif);
        engCarte = findViewById(R.id.engCarte);

        annulerButton = findViewById(R.id.btn_annuler);
        validerButton = findViewById(R.id.btn_valider);

        // Définir les suggestions pour chaque AutoCompleteTextView
        String[] sexes = {"Masculin", "Féminin"};
        String[] motifs = {"Taff", "Etude"};
        String[] typesCartes = {"CNI", "PassePort"};

        // Créer un adaptateur pour chaque AutoCompleteTextView
        ArrayAdapter<String> sexAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_dropdown_item_1line, sexes);
        ArrayAdapter<String> motifAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_dropdown_item_1line, motifs);
        ArrayAdapter<String> carteAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_dropdown_item_1line, typesCartes);

        // Définir les adaptateurs sur chaque AutoCompleteTextView
        engSex.setAdapter(sexAdapter);
        engMotif.setAdapter(motifAdapter);
        engCarte.setAdapter(carteAdapter);

        // Gestion des événements de sélection des champs exposés
        engSex.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSex = (String) parent.getItemAtPosition(position);
                Toast.makeText(Formulaire.this, "Sexe sélectionné : " + selectedSex, Toast.LENGTH_SHORT).show();
            }
        });

        engMotif.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedMotif = (String) parent.getItemAtPosition(position);
                Toast.makeText(Formulaire.this, "Motif sélectionné : " + selectedMotif, Toast.LENGTH_SHORT).show();
            }
        });

        engCarte.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCarte = (String) parent.getItemAtPosition(position);
                Toast.makeText(Formulaire.this, "Type de carte sélectionné : " + selectedCarte, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
