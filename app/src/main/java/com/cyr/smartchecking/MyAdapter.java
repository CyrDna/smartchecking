package com.cyr.smartchecking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cyr.smartchecking.Room.Person;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
  private List<Integer> selectedItems = new ArrayList<>();

  public void setfilteredList(List<Person> filteredList){
    this.personList = filteredList;
    notifyDataSetChanged();
  }

  private List<Person> personList = new ArrayList<>();  // Initialisez avec une liste vide par défaut
  private Context context;
  public MyAdapter(Context context, List<Person> personList) {
    this.personList = personList;
    this.context = context;
  }
  public void setPersonList(List<Person> persons) {
    this.personList = persons;
    notifyDataSetChanged();
  }
  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    return new ViewHolder(view);
  }
  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.bindData(position);
  }
  @Override
  public int getItemCount() {
    return personList.size();
  }

  public List<Person> getSelectedItems() {
    List<Person> items = new ArrayList<>();
    for (int position : selectedItems) {
      if (position >= 0 && position < personList.size()) {
        items.add(personList.get(position));
      }
    }
    return items;
  }
  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    private TextView username, usersname, userstatus, userscan, usermotif, usercarte, green_time, red_time;
    private ImageView userprofile;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);

      username = itemView.findViewById(R.id.user_name);
      usersname = itemView.findViewById(R.id.user_sname);
      userstatus = itemView.findViewById(R.id.user_statut);
      userscan = itemView.findViewById(R.id.user_scan);
      usermotif = itemView.findViewById(R.id.motif);
      usercarte = itemView.findViewById(R.id.user_id);
      green_time = itemView.findViewById(R.id.green_time);
      red_time = itemView.findViewById(R.id.red_time);
      userprofile = itemView.findViewById(R.id.user_profile);

      itemView.setOnClickListener(this);
      itemView.setOnLongClickListener(this);

    }
    public void bindData(int position) {
      Person person = personList.get(position);
      username.setText(person.getName());
      usersname.setText(person.getSname());
      userstatus.setText(person.getStatus());
      userscan.setText(person.getScan());
      usermotif.setText(person.getMotif());
      usercarte.setText(person.getCarte());
      green_time.setText(person.getHentre());
      red_time.setText(person.getHsortie());
      userprofile.setImageResource(person.getPhoto());
    }
    @Override
    public void onClick(View v) {
      int position = getAdapterPosition();
      if (position != RecyclerView.NO_POSITION) {
        Person person = personList.get(position);
        showUserDetails(person);
      }
    }
    @Override
    public boolean onLongClick(View v) {
      int position = getAdapterPosition();
      if (position != RecyclerView.NO_POSITION){
        Person person = personList.get(position);
        Intent intent = new Intent(context, MainActivity2.class);
        context.startActivity(intent);

        Toast.makeText(context, "Appui long sur " + person.getName(), Toast.LENGTH_SHORT).show();
        return true;
      }
      return false;
    }

    private void showUserDetails(Person person) {
      Intent intent = new Intent(context, Save.class);
      intent.putExtra("userprofile", person.getPhoto());
      intent.putExtra("username", person.getName());
      intent.putExtra("usersname", person.getSname());
      intent.putExtra("userstatus", person.getStatus());
      intent.putExtra("usermotif", person.getMotif());
      intent.putExtra("usercarte", person.getCarte());
      intent.putExtra("nbrpersonne", person.getNbrPersonne());
      intent.putExtra("org", person.getOrganisation());
      context.startActivity(intent);
    }

  }
}
