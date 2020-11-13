package com.example.elbazar.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.elbazar.Model.SliderItem;
import com.example.elbazar.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Slider_Adapter_Promo extends RecyclerView.Adapter<Slider_Adapter_Promo.SlideViewHolder> {

    private List<SliderItem> sliderItems ;
    private ViewPager2 viewPager2 ;

    public Slider_Adapter_Promo(List<SliderItem> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public Slider_Adapter_Promo.SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SlideViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slide_item_promotion,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Slider_Adapter_Promo.SlideViewHolder holder, int position) {
        holder.set_image(sliderItems.get(position));
        if (position == sliderItems.size() - 2){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }



    public class SlideViewHolder extends RecyclerView.ViewHolder {

        private RoundedImageView imageView ;

         SlideViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_slide);
        }
        void set_image(SliderItem sliderItem){
            //imageView.setImageResource(sliderItem.getImage());

                        Picasso.get()
                    .load(sliderItem.getImageUrl())
                    .into(imageView);



        }
        
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };
}
