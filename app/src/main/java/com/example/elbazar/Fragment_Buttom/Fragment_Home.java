package com.example.elbazar.Fragment_Buttom;

import android.animation.ArgbEvaluator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.elbazar.Adapter.Adapter;
import com.example.elbazar.Adapter.Adapter_Nouveau_Produit;
import com.example.elbazar.Adapter.ImageAdapter;
import com.example.elbazar.Adapter.Slider_Adapter_Promo;
import com.example.elbazar.Adapter.adapterVente;
import com.example.elbazar.Model.Model_promo;
import com.example.elbazar.Model.Produit_Model;
import com.example.elbazar.Model.SliderItem;
import com.example.elbazar.Produit;
import com.example.elbazar.R;
import com.example.elbazar.Adapter.SliderAdapterExample;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class Fragment_Home  extends Fragment {

    SliderView sliderView;
    ViewPager2 viewPager2 ;
    private Handler sliderHandler = new Handler();
    private SliderAdapterExample adapter;
    GridView gridView , gridView2 , gridView3;
    FloatingTextButton btn_droit , btn_marche , btn_avantage ;
    ViewPager viewPager;
    Adapter adapter_promo;
    List<Model_promo> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private int delay = 3000;
    private int page = 0;
    private Handler handler = new Handler();




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View v = inflater.inflate(R.layout.fragment_home, container, false);

        sliderView = v.findViewById(R.id.imageSlider);
        viewPager2 = v.findViewById(R.id.ViewPageImage);
        viewPager = v.findViewById(R.id.viewPager);
        gridView = v.findViewById(R.id.myGrid);
        gridView2 = v.findViewById(R.id.myGrid2);
        gridView3 = v.findViewById(R.id.myGrid3);
        btn_droit = v.findViewById(R.id.btn_droit);
        btn_marche = v.findViewById(R.id.btn_marche);
        btn_avantage = v.findViewById(R.id.btn_avantage);
        //////////////////////////////////
        btn_droit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShoxDialogBox();
                }
            });

        btn_marche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoxDialogBox2 ();
            }
        });

        btn_avantage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoxDialogBox3 ();
            }
        });


        met_gridView(gridView);
        met_gridView2(gridView2);
        met_gridView3(gridView3);
        pub(sliderView);
        promo(viewPager);
        pub2(viewPager2);

        return v ;

    }

    private void met_gridView(GridView gridView ){
        ArrayList<Model_promo> list1 = new ArrayList <>();
        list1.add(new Model_promo(R.drawable.r,"yahour","100"));
        list1.add(new Model_promo(R.drawable.rrr,"lait","1.500"));
        list1.add(new Model_promo(R.drawable.yaourt,"jue","300"));
        list1.add(new Model_promo(R.drawable.confiture,"delice","1200"));

        gridView.setAdapter(new ImageAdapter(list1, getActivity()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent A = new Intent(getActivity(), Produit.class);
                startActivity(A);
            }
        });
    }
    private void met_gridView2(GridView gridView2){
        ArrayList<Produit_Model> list2 = new ArrayList <>();
        list2.add(new Produit_Model("lait",1000,"https://dari-shop.tn/3580/2508.jpg"));
        list2.add(new Produit_Model("ban",5000,"https://ministop.tn/wp-content/uploads/2013/06/lben.jpg"));
        list2.add(new Produit_Model("cake moulin d'or",5000,"https://moulindor.tn/images/Muffins-cake-01.png"));
        list2.add(new Produit_Model("BARQUETTE MOULIN D'OR",1000,"https://mountik.com/756-large_default/barquette-moulin-d-or-.jpg"));



        gridView2.setAdapter(new adapterVente(list2, getActivity()));



        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //  int item_post = image2.get(position);
                //   ShoxDialogBox(item_post);
            }
        });
    }
    private void met_gridView3(GridView gridView3){
        ArrayList<Produit_Model> list3 = new ArrayList <>();
        list3.add(new Produit_Model("Nokia 5.3", 350.000,"https://images-na.ssl-images-amazon.com/images/I/61L1ItFgFHL._SL1500_.jpg"));
        list3.add(new Produit_Model("CYBERPOWERPC Gamer Xtreme",5000.000,"https://images-na.ssl-images-amazon.com/images/I/71fVpfx5oiL._AC_SX466_.jpg"));
        list3.add(new Produit_Model("lilas tunisie",20.000,"https://tn.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/18/0942/1.jpg?7486"));
        list3.add(new Produit_Model("Peaudouce Lot de 2 Couches bébé",20.000,"https://tn.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/36/5242/1.jpg?3366"));

        gridView3.setAdapter(new Adapter_Nouveau_Produit(list3, getActivity()));



        gridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // int item_post = image3.get(position);
                //   ShoxDialogBox(item_post);
            }
        });
    }

    private void pub(SliderView sliderView){

        adapter = new SliderAdapterExample(getContext());
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);



        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();


        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
            }
        });

        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        for (int i = 0; i < 5; i++) {
            SliderItem sliderItem = new SliderItem();
            sliderItem.setDescription("Slider Item " + i);
            switch (i){
                case 0 :
                    sliderItem.setImageUrl("https://www.usinenouvelle.com/mediatheque/4/4/2/000843244_image_896x598/samsung-galaxy-s20.jpg");
                    break;
                case 1 :
                    sliderItem.setImageUrl("https://i1.wp.com/www.leconomistemaghrebin.com/wp-content/uploads/2019/03/image_news_get.jpg?fit=1200%2C444&ssl=1");
                    break;
                case 2 :
                    sliderItem.setImageUrl("https://i2.wp.com/tunivisions.net/wp-content/uploads/2019/08/Fruits-Rouges.jpg?resize=767%2C1024&ssl=1");
                    break;
                case 3 :
                    sliderItem.setImageUrl("https://thd.tn/wp-content/uploads/2020/03/image001.jpg");
                    break;
                case 4 :
                    sliderItem.setImageUrl("https://www.coca-cola-france.fr/content/dam/one/fr/fr/lead/le-logo-coca-cola-huit-lettres-un-trait-dunion.jpg");
                    break;

            }
            /*if (i % 2 == 0) {
                sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
            } else {
                sliderItem.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
            }*/
            sliderItemList.add(sliderItem);
        }
        adapter.renewItems(sliderItemList);
    }
    private void pub2(ViewPager2 viewPager2){
        List<SliderItem> slider = new ArrayList<>();

        //dummy data
        slider.add(new SliderItem("https://www.marketing-etudiant.fr/wp-content/uploads/2016/01/taste-the-feeling.jpg"));
        slider.add(new SliderItem("https://i.pinimg.com/originals/4d/68/bd/4d68bd92f0293d1e5b48a09e8bc0efea.jpg"));
        slider.add(new SliderItem("https://www.journaldugeek.com/content/uploads/2016/03/Screenshot-40.png"));
        slider.add(new SliderItem("https://mediacomeulalie.weebly.com/uploads/3/8/8/4/38842785/2885011_orig.jpg"));
        slider.add(new SliderItem("https://www.sportbuzzbusiness.fr/wp-content/uploads/2016/05/pub-Volvo-Zlatan-Ibrahimovic-euro-2016-V90.jpg"));
        viewPager2.setAdapter(new Slider_Adapter_Promo(slider,viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r =1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(slideRunnable);
                sliderHandler.postDelayed(slideRunnable,3000);
            }
        });

    }
    private Runnable slideRunnable = new Runnable() {
        @Override
        public void run() {
    viewPager2.setCurrentItem(viewPager2.getCurrentItem()+ 1);
        }
    };


    private Runnable slideRunnable_promo = new Runnable() {
        @Override
        public void run() {
            if (adapter_promo.getCount() == page) {
                page = 0;
            } else {
                page++;
            }
            viewPager.setCurrentItem(page, true);
            handler.postDelayed(this, delay);
        }

    };

    private void promo(ViewPager viewPager){

        models = new ArrayList<>();
        models.add(new Model_promo("Nettoyant Sol Kalyon Golden Rose 1,5L", "100.000", "https://www.blanlys.ma/372-large_default/nettoyant-sol-kalyon-golden-rose-15l.jpg"));
        models.add(new Model_promo("Essuie tout Lilas ", "3.000", "https://lh3.googleusercontent.com/proxy/FfCmOuhHdKjIPu4EYLVdJeSc0DGp3fQKo5eboLTblsgfifZKhSdeLX2lYGxPSZwrCoiI_fKkfUmvcG9PRkpuLchGb7FhmpkoI6Y"));
        models.add(new Model_promo("samsung 43 pouce", "1200.000", "https://www.mega.tn/assets/uploads/img/pr_televiseurs/1021_1.jpg"));
        models.add(new Model_promo("Lampe à poser Blanc", "60.000", "https://www.cdiscount.com/pdt2/4/7/1/1/700x700/ina6957599321471/rw/lampe-de-chevet-2pcs-lampe-de-table-en-bois-et-tis.jpg"));
        models.add(new Model_promo("mac ios", "6000.000", "https://support.apple.com/library/content/dam/edam/applecare/images/en_US/social/macos-mojave-bootcamp-social-card.jpg"));
        models.add(new Model_promo("tv UHD samsung", "3100.000", "https://www.samsungshop.tn/15270-thickbox_default/49-ru7300-curved-smart-4k-uhd-tv-samsung-tunisie-prix.jpg"));


        adapter_promo = new Adapter(models, getContext());


        viewPager.setAdapter(adapter_promo);
        viewPager.setPadding(130, 0, 130, 0);


        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter_promo.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {
                page = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(slideRunnable_promo, delay);
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(slideRunnable_promo);
    }

    public  void ShoxDialogBox ()
    {
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.droits_et_garantis);

        dialog.show();

    }
    public  void ShoxDialogBox2 ()
    {
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.les_avantage);

        dialog.show();

    }
    public  void ShoxDialogBox3 ()
    {
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.avantage_fidelite);

        dialog.show();

    }
}
