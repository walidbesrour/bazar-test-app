package com.example.elbazar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elbazar.Model.Model_promo;
import com.example.elbazar.R;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    List<Model_promo> image ;
    Context context ;
    LayoutInflater layoutInflater ;

    public ImageAdapter(List<Model_promo> image, Context context) {
        this.image = image;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public Model_promo getItem(int position) {
        return image.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



            convertView = layoutInflater.inflate(R.layout.item_gridview,null);
        Model_promo model_promo = getItem(position);
        int image_item = model_promo.getImage();
        String title = model_promo.getTitle();
        String prix = model_promo.getDesc();

        TextView title_view = convertView.findViewById(R.id.title);
        title_view.setText(title);
        TextView title_prix = convertView.findViewById(R.id.desc);
        title_prix.setText(prix);

        ImageView imageView = convertView.findViewById(R.id.image);
        imageView.setImageResource(image_item);



        return convertView;

    }
}
