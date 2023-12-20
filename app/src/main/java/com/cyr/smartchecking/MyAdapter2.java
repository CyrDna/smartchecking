package com.cyr.smartchecking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cyr.smartchecking.Model.ModelPerson;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder> {
 List<ModelPerson> modelPersonList;
 MainActivity2 mainActivity2;

  public MyAdapter2(ArrayList<ModelPerson> modelPersonList, MainActivity2 mainActivity2) {
    this.modelPersonList = modelPersonList;
    this.mainActivity2 = mainActivity2;

  }
  public void setfilteredList(List<ModelPerson> filteredList){
      this.modelPersonList = filteredList;
      notifyDataSetChanged();
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_select,parent,false);
    ViewHolder viewHolder = new ViewHolder(V, mainActivity2);
    return viewHolder;
  }
  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.username.setText(modelPersonList.get(position).getName());
    holder.usersname.setText(modelPersonList.get(position).getSname());
    holder.userstatus.setText(modelPersonList.get(position).getStatus());
    holder.userscan.setText(modelPersonList.get(position).getScan());
    holder.usermotif.setText(modelPersonList.get(position).getMotif());
    holder.usercarte.setText(modelPersonList.get(position).getCarte());
    holder.green_time.setText(modelPersonList.get(position).getHentre());
    holder.red_time.setText(modelPersonList.get(position).getHsortie());
    holder.userprofile.setImageResource(modelPersonList.get(position).getPhoto());
    holder.checkBox.setChecked(mainActivity2.selectionList.contains(modelPersonList.get(position)));
    if (mainActivity2.isContexualModeEnabled){
        holder.checkBox.setVisibility(View.VISIBLE);
        holder.checkBox.setChecked(false);
    }

  }
  @Override
  public int getItemCount() {
    return modelPersonList.size();
  }
  public void RemoveItem(ArrayList<ModelPerson> selectionList) {
      for (int i = 0;i < selectionList.size(); i++){
          modelPersonList.remove(selectionList.get(i));
          notifyDataSetChanged();
        }
      // Réinitialiser l'état dans MainActivity2
      mainActivity2.resetState();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView username,usersname, userstatus, userscan, usermotif, usercarte, green_time, red_time;
    ImageView userprofile;
    CheckBox checkBox;

    public ViewHolder(@NonNull View itemView, MainActivity2 mainActivity2) {
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
      checkBox = itemView.findViewById(R.id.check_box);

      checkBox.setOnClickListener(mainActivity2);
      checkBox.setOnClickListener(this);

    }
        @Override
        public void onClick(View v) {
            mainActivity2.MakeSelection(v,getAdapterPosition());
        }
  }

}
