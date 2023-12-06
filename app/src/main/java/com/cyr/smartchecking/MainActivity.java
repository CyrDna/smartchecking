package com.cyr.smartchecking;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  RecyclerView recyclerView;
  private MyAdapter adapter;
  private List<Person> personList;
  private ActionMode actionMode;
  ImageButton parametre;
  Toolbar toolbar ;




  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.recycler);
    personList = generatePersonList();

    adapter = new MyAdapter(this, personList);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new GridLayoutManager(this, 1));


    toolbar = findViewById(R.id.toolBarx);
    setSupportActionBar(toolbar);

    parametre = toolbar.findViewById(R.id.btnSettings);
    parametre.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        showPopupMenu(parametre);
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

  private List<Person> generatePersonList() {
    List<Person> persons = new ArrayList<>();
    persons.add(new Person("Pierre", "Etudiant", "Manuel", "Visite", "CNI", "9h", "19h", R.drawable.user_profile, "1", "CERCO"));
    persons.add(new Person("John", "Student", "Manual", "Visit", "ID1", "8h", "18h", R.drawable.user_profile, "1", "CERCO"));
    persons.add(new Person("Alice", "Employee", "Auto", "Meeting", "ID2", "10h", "20h", R.drawable.user_profile, "2", "ABC Company"));
    persons.add(new Person("Bob", "Visitor", "Manual", "Appointment", "ID3", "11h", "21h", R.drawable.user_profile, "1", "XYZ Organization"));
    persons.add(new Person("Eva", "Student", "Auto", "Research", "ID4", "9h", "17h", R.drawable.user_profile, "1", "University"));
    persons.add(new Person("Mike", "Employee", "Auto", "Conference", "ID5", "8h", "16h", R.drawable.user_profile, "2", "Tech Corp"));
    persons.add(new Person("Sophie", "Visitor", "Manual", "Event", "ID6", "10h", "22h", R.drawable.user_profile, "1", "Event Planner"));
    persons.add(new Person("Chris", "Student", "Auto", "Study", "ID7", "9h", "18h", R.drawable.user_profile, "1", "College"));
    persons.add(new Person("Emma", "Employee", "Manual", "Training", "ID8", "8h", "17h", R.drawable.user_profile, "2", "Training Institute"));
    persons.add(new Person("Alex", "Visitor", "Auto", "Tour", "ID9", "11h", "20h", R.drawable.user_profile, "1", "Tourism Agency"));
    persons.add(new Person("Grace", "Student", "Manual", "Project", "ID10", "10h", "19h", R.drawable.user_profile, "1", "Project Group"));

    return persons;
  }


}

