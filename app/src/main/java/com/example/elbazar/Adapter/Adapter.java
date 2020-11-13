package com.example.elbazar.Adapter;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.elbazar.DetailActivity;
import com.example.elbazar.Model.Model_promo;
import com.example.elbazar.Model.Produit_Model;
import com.example.elbazar.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<Model_promo> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Model_promo> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);



        ImageView imageView;
        TextView title, desc;

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);



        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());
Picasso.get()
                .load(models.get(position).getImage_produit())
                .into(imageView);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("param", models.get(position).getTitle());
                context.startActivity(intent);
                // finish();
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }


}
