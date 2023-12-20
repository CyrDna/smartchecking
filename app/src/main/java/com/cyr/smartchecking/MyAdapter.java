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

import com.cyr.smartchecking.Model.ModelPerson;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

  private List<ModelPerson> modelPersonList;
  private List<Integer> selectedItems = new ArrayList<>();
  private Context context;

  public void setfilteredList(List<ModelPerson> filteredList){
    this.modelPersonList = filteredList;
    notifyDataSetChanged();

  }

  public MyAdapter(Context context, List<ModelPerson> modelPersonList) {
    this.modelPersonList = modelPersonList;
    this.context = context;
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
    return modelPersonList.size();
  }

  public List<ModelPerson> getSelectedItems() {
    List<ModelPerson> items = new ArrayList<>();
    for (int position : selectedItems) {
      if (position >= 0 && position < modelPersonList.size()) {
        items.add(modelPersonList.get(position));
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
      ModelPerson modelPerson = modelPersonList.get(position);
      username.setText(modelPerson.getName());
      usersname.setText(modelPerson.getSname());
      userstatus.setText(modelPerson.getStatus());
      userscan.setText(modelPerson.getScan());
      usermotif.setText(modelPerson.getMotif());
      usercarte.setText(modelPerson.getCarte());
      green_time.setText(modelPerson.getHentre());
      red_time.setText(modelPerson.getHsortie());
      userprofile.setImageResource(modelPerson.getPhoto());
    }
    @Override
    public void onClick(View v) {
      int position = getAdapterPosition();
      if (position != RecyclerView.NO_POSITION) {
        ModelPerson modelPerson = modelPersonList.get(position);
        showUserDetails(modelPerson);
      }
    }
    @Override
    public boolean onLongClick(View v) {
      int position = getAdapterPosition();
      if (position != RecyclerView.NO_POSITION){
        ModelPerson modelPerson = modelPersonList.get(position);
        Intent intent = new Intent(context, MainActivity2.class);
        context.startActivity(intent);

        Toast.makeText(context, "Appui long sur " + modelPerson.getName(), Toast.LENGTH_SHORT).show();
        return true;
      }
      return false;
    }

    private void showUserDetails(ModelPerson modelPerson) {
      Intent intent = new Intent(context, Save.class);
      intent.putExtra("userprofile", modelPerson.getPhoto());
      intent.putExtra("username", modelPerson.getName());
      intent.putExtra("usersname", modelPerson.getSname());
      intent.putExtra("userstatus", modelPerson.getStatus());
      intent.putExtra("usermotif", modelPerson.getMotif());
      intent.putExtra("usercarte", modelPerson.getCarte());
      intent.putExtra("nbrpersonne", modelPerson.getNbrPersonne());
      intent.putExtra("org", modelPerson.getOrganisation());
      context.startActivity(intent);
    }

  }
}
