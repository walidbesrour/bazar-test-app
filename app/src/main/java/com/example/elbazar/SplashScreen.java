package com.example.elbazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elbazar.menu.Menu;

public class SplashScreen extends AppCompatActivity {
     ImageView imageView ;
     TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash_screen);
        textView = findViewById(R.id.txt_elbazar);
        imageView = findViewById(R.id.img_screen);
        imageView.animate().rotation(360*5).setDuration(2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              textView.setVisibility(View.VISIBLE);
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);
                finish();



            }
        }, 4000);
    }
}