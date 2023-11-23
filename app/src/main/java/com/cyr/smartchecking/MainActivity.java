package com.cyr.smartchecking;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.ActionMode;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private Adapter adapter;
    private List<Person> personList;

    private ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        personList = generatePersonList();
        adapter = new Adapter(this, personList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        adapter.setOnItemLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (actionMode == null) {
                    actionMode = startActionMode(actionModeCallback);
                    v.setSelected(true);
                    adapter.notifyDataSetChanged();
                }
                return true;
            }
        });
    }

    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_selection, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.supp_settings) {
                deleteSelectedItems();
                mode.finish();
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
            adapter.clearSelection();
        }
    };

    private void deleteSelectedItems() {
        adapter.deleteSelectedItems();
    }

    private List<Person> generatePersonList() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Pierre", "Etudiant", "Manuel", "Visite", "CNI", "9h", "19h", R.drawable.user_profile, "1", "CERCO"));
        persons.add(new Person("Nom2", "Statut2", "Scan2", "Motif2", "Carte2", "HeureEntrée2", "HeureSortie2", R.drawable.user_profile, "NombrePersonne2", "Organisation2"));
        // Ajoutez d'autres personnes ici...
        return persons;
    }
}
