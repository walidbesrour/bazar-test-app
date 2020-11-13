package com.example.elbazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Produit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);
    }

    public void Acheter(View view) {
        Intent intent = new Intent(this,Ordered.class);
        startActivity(intent);
        finish();
    }
}