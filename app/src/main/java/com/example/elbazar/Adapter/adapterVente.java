package com.example.elbazar.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elbazar.Model.Model_promo;
import com.example.elbazar.Model.Produit_Model;
import com.example.elbazar.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class adapterVente extends BaseAdapter {
    List<Produit_Model> produit_models ;
    Context context ;
    LayoutInflater layoutInflater ;

    public adapterVente(List<Produit_Model> produit_models, Context context) {
        this.produit_models = produit_models;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return produit_models.size();
    }

    @Override
    public Object getItem(int position) {
        return produit_models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        convertView = layoutInflater.inflate(R.layout.item_gridview,null);


        Produit_Model produit_models = (Produit_Model) getItem(position);
        String image_item = produit_models.getImage_produit();
        String title = produit_models.getNom_produit();
        double prix = produit_models.getPrix_produit();

        TextView title_view = convertView.findViewById(R.id.title);
        title_view.setText(title);

        TextView title_prix = convertView.findViewById(R.id.desc);
        title_prix.setText(String.valueOf(prix));

        ImageView imageView = convertView.findViewById(R.id.image);

        Picasso.get()
                .load(image_item)
                .into(imageView);



        return convertView;


    }
}
