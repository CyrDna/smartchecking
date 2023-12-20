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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cyr.smartchecking.Model.ModelPerson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  RecyclerView recyclerView;
  private static MyAdapter adapter;

  ImageButton parametre;
  ImageButton btnItem;
  Toolbar toolbar ;
  private EditText editTextSearch;
  private ImageView searchIcon;
  private ImageView filterIcon;
  private List<ModelPerson> modelPersonList;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.recycler);
    modelPersonList = generatePersonList();

    adapter = new MyAdapter(this, modelPersonList);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    //Initilisation des vue pour la barre de recherche
    editTextSearch = findViewById(R.id.editTextSearch);
    searchIcon = findViewById(R.id.searchIcon);
    filterIcon = findViewById(R.id.filter);
    searchIcon.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
        performSearch();
      }
    });
    filterIcon.setOnClickListener(new View.OnClickListener(){
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
	btnItem = findViewById(R.id.btnItem);
 	btnItem.setOnClickListener(new View.OnClickListener() {
		  @Override
		  public void onClick(View v) {
              Intent intent = new Intent(MainActivity.this, Formulaire.class);
              startActivity(intent);
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
  private List<ModelPerson> generatePersonList() {
    List<ModelPerson> modelPeople = new ArrayList<>();
    modelPeople.add(new ModelPerson("Pierre", "BEHANZIN","Etudiant", "Manuel", "Visite", "CNI", "9h", "19h", R.drawable.user_profile, "1", "CERCO"));
    modelPeople.add(new ModelPerson("John","BEHANZIN" ,"Student", "Manual", "Visit", "ID1", "8h", "18h", R.drawable.user_profile, "1", "CERCO"));
    modelPeople.add(new ModelPerson("Alice", "BEHANZIN" ,"Employee", "Auto", "Meeting", "ID2", "10h", "20h", R.drawable.user_profile, "2", "ABC Company"));
    modelPeople.add(new ModelPerson("Bob", "DONA" ,"Visitor", "Manual", "Appointment", "ID3", "11h", "21h", R.drawable.user_profile, "1", "XYZ Organization"));
    modelPeople.add(new ModelPerson("Eva", "DONA" ,"Student", "Auto", "Research", "ID4", "9h", "17h", R.drawable.user_profile, "1", "University"));
    modelPeople.add(new ModelPerson("Mike", "DONA" ,"Employee", "Auto", "Conference", "ID5", "8h", "16h", R.drawable.user_profile, "2", "Tech Corp"));
    modelPeople.add(new ModelPerson("Sophie","DONA" , "Visitor", "Manual", "Event", "ID6", "10h", "22h", R.drawable.user_profile, "1", "Event Planner"));
    modelPeople.add(new ModelPerson("Chris", "DONA" ,"Student", "Auto", "Study", "ID7", "9h", "18h", R.drawable.user_profile, "1", "College"));
    modelPeople.add(new ModelPerson("Emma", "DONA" ,"Employee", "Manual", "Training", "ID8", "8h", "17h", R.drawable.user_profile, "2", "Training Institute"));
    return modelPeople;
  }
  private void performSearch() {
    String searchText = editTextSearch.getText().toString().toLowerCase().trim();

    List<ModelPerson> filteredList = new ArrayList<>();
    for (ModelPerson modelPerson : modelPersonList) {
      if (modelPerson.getName().toLowerCase().contains(searchText)) {
        filteredList.add(modelPerson);
      }
      if (modelPerson.getSname().toLowerCase().contains(searchText)){
        filteredList.add(modelPerson);
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



