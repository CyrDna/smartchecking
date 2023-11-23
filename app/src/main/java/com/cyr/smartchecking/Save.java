package com.cyr.smartchecking;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cyr.smartchecking.R;

public class Save extends AppCompatActivity {

    ImageView user_profile;
    TextView user_name, user_statut, user_motif, user_id, s_people, s_building;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrement);

        user_profile = findViewById(R.id.user_profile);
        user_name = findViewById(R.id.user_name);
        user_statut = findViewById(R.id.user_statut);
        user_motif = findViewById(R.id.motif);
        user_id = findViewById(R.id.user_id);
        s_people = findViewById(R.id.s_people);
        s_building = findViewById(R.id.s_building);

        Intent intent = getIntent();

        user_profile.setImageResource(intent.getIntExtra("userprofile",0));
        user_name.setText(intent.getStringExtra("username"));
        user_statut.setText(intent.getStringExtra("userstatus"));
        user_motif.setText(intent.getStringExtra("usermotif"));
        user_id.setText(intent.getStringExtra("usercarte"));
        s_people.setText(intent.getStringExtra("nbrpersonne"));
        s_building.setText(intent.getStringExtra("org"));

    }

}