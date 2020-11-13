package com.example.elbazar.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elbazar.Model.Commande;
import com.example.elbazar.R;
import com.travijuu.numberpicker.library.NumberPicker;

import java.util.ArrayList;

public class Adapter_Commande extends RecyclerView.Adapter<Adapter_Commande.adapter_Commande_Holder> {

    private ArrayList<Commande> commandes = new ArrayList<>();


    @NonNull
    @Override
    public Adapter_Commande.adapter_Commande_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

         return  new adapter_Commande_Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comande,parent,false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Commande.adapter_Commande_Holder holder, int position) {
/*
    user p = users.get(position);
    holder.T.setText(p.getUsername());

    user v = users.get(position);
        holder.I.setImageResource(v.getImage());

 */
        Commande my_commande =commandes.get(position);

        holder.command_name.setText(my_commande.getNom_produit());
    String a = String.valueOf(my_commande.getPrix());

        holder.commande_prix.setText(a);
        holder.imageView.setImageResource(my_commande.getImage_commande());
        holder.numberPicker.setValue(my_commande.getQuantité());
    }

    @Override
    public int getItemCount() {
        return commandes.size();
    }

    public class adapter_Commande_Holder extends RecyclerView.ViewHolder {

        TextView command_name , commande_prix ;
        ImageView imageView ;
        NumberPicker numberPicker ;


        public adapter_Commande_Holder(@NonNull View itemView) {
            super(itemView);
            command_name = itemView.findViewById(R.id.description_txt);
            commande_prix = itemView.findViewById(R.id.prix_txt);
            imageView = itemView.findViewById(R.id.image);
            numberPicker = itemView.findViewById(R.id.number_picker_custom);

        }
    }
    public void setList(ArrayList<Commande> posts) {
        this.commandes = posts;
        notifyDataSetChanged();

    }
}
