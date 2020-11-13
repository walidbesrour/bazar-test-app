package com.example.elbazar;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.elbazar.Adapter.Adapter_Commande;
import com.example.elbazar.Model.Commande;
import com.example.elbazar.databinding.ActivityOrderedBinding;

import java.util.ArrayList;

public class Ordered extends AppCompatActivity {


    MovieViewModel movieViewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityOrderedBinding binding =  DataBindingUtil.setContentView(this,R.layout.activity_ordered);

        Log.d("/////", "//////////: ");
       // setContentView(R.layout.activity_ordered);

        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        binding.setModelView(movieViewModel);
        movieViewModel.getlist_Friend();
        final Adapter_Commande adapter = new Adapter_Commande();
        binding.Recycle1.setAdapter(adapter);
        movieViewModel.mutableLiveData.observe(this, new Observer<ArrayList<Commande>>() {
            @Override
            public void onChanged(ArrayList<Commande> users) {
                adapter.setList(users);
            }
        });
        binding.Recycle1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.setLifecycleOwner(this);
    }

    public void acheter(View view) {
        Intent intent = new Intent(this , Register.class);
        startActivity(intent);
        finish();
    }
}