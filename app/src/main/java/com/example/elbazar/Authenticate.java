package com.example.elbazar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.elbazar.Utils.DatePickerFragment;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Authenticate extends AppCompatActivity implements DatePickerDialog.OnDateSetListener , AdapterView.OnItemSelectedListener {
    private TextInputLayout textInputDate;
    private EditText Date;
    String id_ville ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticate);


        textInputDate = findViewById(R.id.name_Date);
        Date = findViewById(R.id.Date);

        Spinner spinner = findViewById(R.id.spinner1);
        Spinner spinner_gouvernorat = findViewById(R.id.gouvernorat);
        Spinner spinner_ville = findViewById(R.id.ville);
        Spinner spinner_localite = findViewById(R.id.localite);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
          ////////////////////////////////////SPINNER JSON //////////////////////////////////////////////


        /////////////////////////////parser json //////////////////
        try{
            JSONObject obj=new JSONObject(LoadJsonFromAsset());

            JSONArray array=obj.getJSONArray("Gouvernorats");
            ArrayList<String> list = null;


            list= new ArrayList<>();
            for( int i=0;i<array.length();i++){

                JSONObject o = array.getJSONObject(i);

                String label_v =o.getString("label");

                list.add(label_v);


            }

            Log.d("*******", String.valueOf(list));


            ArrayAdapter<String> adapter_gouvernorat = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

            adapter_gouvernorat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_gouvernorat.setAdapter(adapter_gouvernorat);

            spinner_gouvernorat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            try {

                JSONObject obj_ville =new JSONObject(LoadJsonFromAsset_ville());

                JSONArray array2=obj_ville.getJSONArray("Villes");
                ArrayList<String> list_ville = null;
                list_ville= new ArrayList<>();
                for( int i=0;i<array2.length();i++){

                    JSONObject o = array2.getJSONObject(i);
                    String label_ville =o.getString("Ville");
                    String labell_IDGouvernorat = o.getString("IDGouvernorat");


            if(position == 0 && labell_IDGouvernorat.equals("1") )
            {

                       list_ville.add(label_ville);
            }
                    if(position == 1 && labell_IDGouvernorat.equals("2") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 2 && labell_IDGouvernorat.equals("3") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 3 && labell_IDGouvernorat.equals("4") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 4 && labell_IDGouvernorat.equals("5") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 5 && labell_IDGouvernorat.equals("6") )
                    {
                        list_ville.add(label_ville);
                    }if(position == 6 && labell_IDGouvernorat.equals("7") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 7 && labell_IDGouvernorat.equals("8") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 8 && labell_IDGouvernorat.equals("9") )
                    {
                        list_ville.add(label_ville);
                    }if(position == 9 && labell_IDGouvernorat.equals("10") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 10 && labell_IDGouvernorat.equals("11") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 11 && labell_IDGouvernorat.equals("12") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 12 && labell_IDGouvernorat.equals("13") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 13 && labell_IDGouvernorat.equals("14") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 14 && labell_IDGouvernorat.equals("15") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 15 && labell_IDGouvernorat.equals("16") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 16 && labell_IDGouvernorat.equals("17") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 17 && labell_IDGouvernorat.equals("18") )
                    {
                        list_ville.add(label_ville);
                    }
                    if(position == 18 && labell_IDGouvernorat.equals("19") )
                    {
                        list_ville.add(label_ville);
                    }  if(position == 19 && labell_IDGouvernorat.equals("20") )
                    {
                        list_ville.add(label_ville);
                    }  if(position == 20 && labell_IDGouvernorat.equals("21") )
                    {
                        list_ville.add(label_ville);
                    }  if(position == 21 && labell_IDGouvernorat.equals("22") )
                    {
                        list_ville.add(label_ville);
                    }  if(position == 22 && labell_IDGouvernorat.equals("23") )
                    {
                        list_ville.add(label_ville);
                    }  if(position == 23 && labell_IDGouvernorat.equals("24") )
                    {
                        list_ville.add(label_ville);
                    }




                }

          ArrayAdapter<String> adapter_ville = new ArrayAdapter<String>(Authenticate.this, android.R.layout.simple_spinner_item, list_ville);
                spinner_ville.setAdapter(new ArrayAdapter<String>(Authenticate.this, android.R.layout.simple_spinner_item, list_ville));




                spinner_ville.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                       // Log.d("==> position ", String.valueOf(position));

                        try {
                            String Ville_sp = parent.getSelectedItem().toString() ;

                            JSONObject obj_ville2 =new JSONObject(LoadJsonFromAsset_ville());

                            JSONArray array22=obj_ville2.getJSONArray("Villes");
                            ArrayList<String> list_ville2 = null;
                            list_ville2= new ArrayList<>();
                            for( int i=0;i<array22.length();i++) {

                                JSONObject o = array22.getJSONObject(i);
                                String label_ville2 = o.getString("Ville");
                                String ID = o.getString("ID");
                                        if (label_ville2.equals(Ville_sp))
                                        {
                                            id_ville = ID ;
                                        }

                            }

                            Toast.makeText(parent.getContext(), id_ville, Toast.LENGTH_SHORT).show();



                            JSONObject obj_Localite = new JSONObject(LoadJsonFromAsset_localite());
                            JSONArray array3 = obj_Localite.getJSONArray("Localites");



                            ArrayList<String> list_Localites = null;
                            list_Localites= new ArrayList<>();



                            for( int i=0;i<array3.length();i++){
                                JSONObject o = array3.getJSONObject(i);
                                String label_localites =o.getString("Localite");
                                String labell_IDVille = o.getString("IDVille");

                               if(id_ville.equals(labell_IDVille)){
                                   list_Localites.add(label_localites);
                               }




                            }

                            spinner_localite.setAdapter(new ArrayAdapter<String>(Authenticate.this, android.R.layout.simple_spinner_item, list_Localites));



                        }catch (Exception exe){exe.printStackTrace(); }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                ////////////////
                      /*

                    */
//////////

                }catch (Exception ex){ ex.printStackTrace(); }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }catch (JSONException e){
            e.printStackTrace();
        }





        // //////////////////////////////////////////////////////////////////////////////
        Date.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }




    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        Date = findViewById(R.id.Date);;
        Date.setText(currentDateString);
    }
    ///////////// spinner//////////:
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text = parent.getItemAtPosition(position).toString();
    //    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    ///////////// spinner //////////:
    public String LoadJsonFromAsset(){
        String json=null;
        try{
            InputStream in=this.getAssets().open("gouvernorat.json");
            int size=in.available();
            byte[] bbuffer=new byte[size];
            in.read(bbuffer);
            in.close();
            json=new String(bbuffer,"UTF-8");

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }

    public String LoadJsonFromAsset_ville(){
        String json=null;
        try{
            InputStream in=this.getAssets().open("villes.json");
            int size=in.available();
            byte[] bbuffer=new byte[size];
            in.read(bbuffer);
            in.close();
            json=new String(bbuffer,"UTF-8");

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }

    public String LoadJsonFromAsset_localite(){
        String json=null;
        try{
            InputStream in=this.getAssets().open("localite.json");
            int size=in.available();
            byte[] bbuffer=new byte[size];
            in.read(bbuffer);
            in.close();
            json=new String(bbuffer,"UTF-8");

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
}