package com.cyr.smartchecking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder> {
 ArrayList<Person> personList;
 MainActivity2 mainActivity2;

  public MyAdapter2(ArrayList<Person> personList, MainActivity2 mainActivity2) {
    this.personList = personList;
    this.mainActivity2 = mainActivity2;

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
//    Person currentPerson = personList.get(position);
    holder.username.setText(personList.get(position).getName());
    holder.userstatus.setText(personList.get(position).getStatus());
    holder.userscan.setText(personList.get(position).getScan());
    holder.usermotif.setText(personList.get(position).getMotif());
    holder.usercarte.setText(personList.get(position).getCarte());
    holder.green_time.setText(personList.get(position).getHentre());
    holder.red_time.setText(personList.get(position).getHsortie());
    holder.userprofile.setImageResource(personList.get(position).getPhoto());
    if (mainActivity2.isContexualModeEnabled){
        holder.checkBox.setVisibility(View.VISIBLE);
        holder.checkBox.setChecked(false);
    }

  }
  @Override
  public int getItemCount() {
    return personList.size();
  }
  public void RemoveItem(ArrayList<Person> selectionList) {
      for (int i = 0;i < selectionList.size(); i++){
          personList.remove(selectionList.get(i));
          notifyDataSetChanged();
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView username, userstatus, userscan, usermotif, usercarte, green_time, red_time;
    ImageView userprofile;
    CheckBox checkBox;
    View view;

    public ViewHolder(@NonNull View itemView, MainActivity2 mainActivity2) {
      super(itemView);

      username = itemView.findViewById(R.id.user_name);
      userstatus = itemView.findViewById(R.id.user_statut);
      userscan = itemView.findViewById(R.id.user_scan);
      usermotif = itemView.findViewById(R.id.motif);
      usercarte = itemView.findViewById(R.id.user_id);
      green_time = itemView.findViewById(R.id.green_time);
      red_time = itemView.findViewById(R.id.red_time);
      userprofile = itemView.findViewById(R.id.user_profile);
      checkBox = itemView.findViewById(R.id.check_box);

     // view=itemView;
      checkBox.setOnClickListener(mainActivity2);
      checkBox.setOnClickListener(this);

    }

        @Override
        public void onClick(View v) {
            mainActivity2.MakeSelection(v,getAdapterPosition());
        }

  }

}
