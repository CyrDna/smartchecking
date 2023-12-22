package com.cyr.smartchecking;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cyr.smartchecking.Room.Person;
import com.cyr.smartchecking.Room.PersonDAO;
import com.cyr.smartchecking.Room.PersonDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Formulaire extends AppCompatActivity {
    ImageView engImg;
    ImageButton annulerButton, validerButton;
    EditText engNom, engSnom, engMail, engNum , engDatelivr, engDatexpir, engVisitor;
    AutoCompleteTextView engSex, engMotif, engCarte;
    private PersonDatabase personDatabase;
    private PersonDAO personDAO;

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

        engDatelivr = findViewById(R.id.engDatelivr);
        engDatexpir= findViewById(R.id.engDatexpir);
        engVisitor= findViewById(R.id.engVisitor);

        engSex = findViewById(R.id.engSex);
        engMotif = findViewById(R.id.engMotif);
        engCarte = findViewById(R.id.engCarte);

        annulerButton = findViewById(R.id.btn_annuler);
        validerButton = findViewById(R.id.btn_valider);

        // Initialisation de la base de données et du DAO
        personDatabase = PersonDatabase.getInstance(this);
        personDAO = personDatabase.getDao();

        // Charger les options depuis la base de données pour les AutoCompleteTextView
        loadOptionsFromDatabase();

        // Écouteurs pour les AutoCompleteTextView
        setupAutoCompleteListeners();

        // Sélection d'une image depuis la galerie
        engImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImageFromGallery();
            }
        });

        // Enregistrement des données dans la base de données
        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToDatabase();
            }
        });
    }

    // Charger les options depuis la base de données pour les AutoCompleteTextView
    private void loadOptionsFromDatabase() {
        String[] sexes = {"Masculin", "Féminin"};
        String[] motifs = {"Réunion", "Visite", "Travail"};
        String[] typesCartes = {"CNI", "PassePort"};

        // Adapters pour les AutoCompleteTextView
        ArrayAdapter<String> sexAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_dropdown_item_1line, sexes);
        ArrayAdapter<String> motifAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_dropdown_item_1line, motifs);
        ArrayAdapter<String> carteAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_dropdown_item_1line, typesCartes);
        // Associer les adapters aux AutoCompleteTextView
        engSex.setAdapter(sexAdapter);
        engMotif.setAdapter(motifAdapter);
        engCarte.setAdapter(carteAdapter);
    }

    // Écouteurs pour les AutoCompleteTextView
    private void setupAutoCompleteListeners() {
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
    // Méthode pour sélectionner une image depuis la galerie
    private void pickImageFromGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, 1);
    }

    // Méthode pour sauvegarder les données dans la base de données
    private void saveDataToDatabase() {
        String nom = engNom.getText().toString();
        String snom = engSnom.getText().toString();
        String mail = engMail.getText().toString();
        String num = engNum.getText().toString();
        String sex = engSex.getText().toString();
        String motif = engMotif.getText().toString();
        String carte = engCarte.getText().toString();
        String hentre= getCurrentTime();
        String nbrPersonne = engVisitor.getText().toString();
        String status = "";
        String datelivr = getCurrentDate();
        String datexpir = engDatexpir.getText().toString();

        // Ajouter des conditions pour définir la valeur de status en fonction du motif
        if ("Réunion".equals(motif) || "Travail".equals(motif)) {
            status = "Employer";
        } else if ("Visite".equals(motif)) {
            status = "Visiteur";
        }

        // Création d'un objet Person avec les données du formulaire
        Person person = new Person(0, nom, snom, status, "Manuel",
                motif, carte, hentre, "hsortie", R.drawable.user_profile,
                nbrPersonne, "CERCO",datelivr , datexpir);
        // Exécution de l'insertion dans un AsyncTask
        new InsertPersonAsyncTask().execute(person);
    }
    private class InsertPersonAsyncTask extends AsyncTask<Person, Void, Void> {
        @Override
        protected Void doInBackground(Person... people) {
            // Insertion de la personne dans la base de données
            personDAO.insert(people[0]);
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            // Effacement des champs du formulaire après l'insertion
            engNom.setText("");
            engSnom.setText("");
            engMail.setText("");
            engNum.setText("");
            engSex.setText("");
            engMotif.setText("");
            engCarte.setText("");
            engVisitor.setText("");
            // Affichage d'un message de réussite
            Toast.makeText(Formulaire.this, "Données sauvegardées avec succès", Toast.LENGTH_SHORT).show();
        }
    }

    private String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat
                ("HH:mm", Locale.getDefault());
        return simpleDateFormat.format(new Date());
    }
    private String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return simpleDateFormat.format(new Date());
    }

}
