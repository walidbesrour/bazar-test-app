package com.example.elbazar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.elbazar.Model.Commande;

import java.util.ArrayList;

public class MovieViewModel extends ViewModel {



    public MutableLiveData<ArrayList<Commande>> mutableLiveData = new MutableLiveData<>();



    public void getlist_Friend()
    {
        mutableLiveData.setValue(getCommande());
    }




    public ArrayList<Commande> getCommande(){
        ArrayList<Commande> commandes = new ArrayList<>();

        commandes.add(new Commande("delice",500,3,R.drawable.yaourt));

        return commandes ;
    }
}
