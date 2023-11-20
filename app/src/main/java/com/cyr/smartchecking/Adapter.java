package com.cyr.smartchecking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    String[] name;
    String[] status;
    String[] scan;
    String[] motif;
    String[] carte;
    String[] hentre;
    String[] hsortie;
    int[] photo;
    String[] nbrpersonne;
    String[] org;
    Context context;
    LayoutInflater inflater;

    public Adapter (Context context, String[] name, String[] status, String[] scan,
                    String[] motif, String[] carte, String[] hentre, String[] hsortie,int[] photo, String[] nbrpersonne, String[] org){

        this.name = name;
        this.status = status;
        this.scan = scan;
        this.motif = motif;
        this.carte = carte;
        this.hentre = hentre;
        this.hsortie = hsortie;
        this.photo = photo;
        this.nbrpersonne = nbrpersonne;
        this.org = org;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.username.setText(name[position]);
        holder.userstatus.setText(status[position]);
        holder.userscan.setText(scan[position]);
        holder.usermotif.setText(motif[position]);
        holder.usercarte.setText(carte[position]);
        holder.green_time.setText(hentre[position]);
        holder.red_time.setText(hsortie[position]);
        holder.userprofile.setImageResource(photo[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView username, userstatus;

        TextView userscan;
        TextView usermotif;
        TextView usercarte;
        TextView green_time;
        TextView red_time;
        ImageView userprofile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.user_name);
            userstatus = itemView.findViewById(R.id.user_statut);
            userscan = itemView.findViewById(R.id.user_scan);
            usermotif = itemView.findViewById(R.id.motif);
            usercarte = itemView.findViewById(R.id.user_id);
            green_time = itemView.findViewById(R.id.green_time);
            red_time = itemView.findViewById(R.id.red_time);
            userprofile = itemView.findViewById(R.id.user_profile);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, Save.class);
                    intent.putExtra("username", name[getAdapterPosition()]);
                    intent.putExtra("userstatus", status[getAdapterPosition()]);
                    intent.putExtra("usermotif", motif[getAdapterPosition()]);
                    intent.putExtra("userprofile", photo[getAdapterPosition()]);
                    intent.putExtra("usercarte", carte[getAdapterPosition()]);
                    intent.putExtra("nbrpersonne", nbrpersonne[getAdapterPosition()]);
                    intent.putExtra("org", org[getAdapterPosition()]);
                    context.startActivity(intent);
                }
            });

        }
    }
}
