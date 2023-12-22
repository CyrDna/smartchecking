package com.cyr.smartchecking;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cyr.smartchecking.Room.Person;
import com.cyr.smartchecking.Room.PersonDAO;
import com.cyr.smartchecking.Room.PersonDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private RecyclerView recyclerView;
  private static MyAdapter adapter;
  private ImageButton parametre;
  private ImageButton btnItem;
  private Toolbar toolbar;
  private EditText editTextSearch;
  private ImageView searchIcon;
  private ImageView filterIcon;
  private ArrayList<Person> personList;
  private PersonDatabase personDatabase;
  private PersonDAO personDAO;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.recycler);
    personList = new ArrayList<>(); // Initialize an empty list for now

    adapter = new MyAdapter(this, personList);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

    // Initialize views for the search bar
    editTextSearch = findViewById(R.id.editTextSearch);
    searchIcon = findViewById(R.id.searchIcon);
    filterIcon = findViewById(R.id.filter);
    searchIcon.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        performSearch();
      }
    });
    filterIcon.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        filtration();
      }

    });

    toolbar = findViewById(R.id.toolBarx);
    setSupportActionBar(toolbar);
    parametre = toolbar.findViewById(R.id.btnSettings);
    parametre.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        showPopupMenu(parametre);
      }
    });

    // Initialize your database
    personDatabase = PersonDatabase.getInstance(this);

    btnItem = findViewById(R.id.btnItem);
    btnItem.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Formulaire.class);
        startActivity(intent);
      }
    });

    // Fetch data from the database and update the adapter
    fetchDataFromDatabase();
  }

  private void fetchDataFromDatabase() {
    // Observe the LiveData returned by getAllPersons()
    personDatabase.getDao().getAllPersons().observe(this, new Observer<List<Person>>() {
      @Override
      public void onChanged(List<Person> persons) {
        // Update the adapter with the fetched data
        personList.clear();
        personList.addAll(persons);
        adapter.notifyDataSetChanged();
        adapter.setPersonList(persons);
      }
    });
  }

  private void showPopupMenu(View view) {
    PopupMenu popupMenu = new PopupMenu(this, view);
    popupMenu.getMenuInflater().inflate(R.menu.menu_select, popupMenu.getMenu());
    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
      @Override
      public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.select_settings) {
          startActivity(new Intent(MainActivity.this, MainActivity2.class));
          return true;
        }
        return false;
      }
    });

    popupMenu.show();
  }

  private void performSearch() {
    String searchText = editTextSearch.getText().toString().toLowerCase().trim();

    List<Person> filteredList = new ArrayList<>();
    for (Person person : personList) {
      if (person.getName().toLowerCase().contains(searchText) || person.getSname().toLowerCase().contains(searchText)) {
        filteredList.add(person);
      }
    }

    if (filteredList.isEmpty()) {
      Toast.makeText(this, "Aucune donnée trouvée", Toast.LENGTH_SHORT).show();
    } else {
      adapter.setfilteredList(filteredList);
    }
  }

  private void filtration() {
    // Implement logic to open filter options
  }
}
