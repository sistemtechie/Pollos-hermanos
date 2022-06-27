package com.example.polloshermanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabItem;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }



    public void lista(View view){
        String dato = getIntent().getStringExtra("correo");
        Intent i = new  Intent(this, Lista.class);
        i.putExtra("correo",dato);
        startActivity(i);
    }

    public void Config(View view){
        String dato = getIntent().getStringExtra("correo");
        Intent i = new  Intent(this, Config.class);
        i.putExtra("correo",dato);
        startActivity(i);
    }


    public void Apollo_cuarto(View view){
        String dato = getIntent().getStringExtra("correo"), pollo = "Un 1/4 de pollo apando",
        precio= "7.900";
        Intent i = new  Intent(this, Domicilio.class);
        i.putExtra("precio",precio);
        i.putExtra("pollo",pollo);
        i.putExtra("correo",dato);
        startActivity(i);
    }

    public void Apollo_medio(View view){
        String dato = getIntent().getStringExtra("correo"), pollo = "Un 1/2 de pollo apando",
                precio= "14.000";
        Intent i = new  Intent(this, Domicilio.class);
        i.putExtra("precio",precio);
        i.putExtra("pollo",pollo);
        i.putExtra("correo",dato);
        startActivity(i);
    }

    public void Apollo_entero(View view){
        String dato = getIntent().getStringExtra("correo"), pollo = "pollo entero apando",
                precio= "31.000";
        Intent i = new  Intent(this, Domicilio.class);
        i.putExtra("precio",precio);
        i.putExtra("pollo",pollo);
        i.putExtra("correo",dato);
        startActivity(i);
    }


    public void Apollo_Combo(View view){
        String dato = getIntent().getStringExtra("correo"), pollo = "Combo con papas",
                precio= "12.000";
        Intent i = new  Intent(this, Domicilio.class);
        i.putExtra("precio",precio);
        i.putExtra("pollo",pollo);
        i.putExtra("correo",dato);
        startActivity(i);
    }

    public void Aspollo_cuarto(View view){
        String dato = getIntent().getStringExtra("correo"), pollo = "Un 1/4 de pollo Asado",
                precio= "6.900";
        Intent i = new  Intent(this, Domicilio.class);
        i.putExtra("precio",precio);
        i.putExtra("pollo",pollo);
        i.putExtra("correo",dato);
        startActivity(i);
    }

    public void Aspollo_medio(View view){
        String dato = getIntent().getStringExtra("correo"), pollo = "Un 1/2 de pollo Asado",
                precio= "12.000";
        Intent i = new  Intent(this, Domicilio.class);
        i.putExtra("precio",precio);
        i.putExtra("pollo",pollo);
        i.putExtra("correo",dato);
        startActivity(i);
    }

    public void Aspollo_entero(View view){
        String dato = getIntent().getStringExtra("correo"), pollo = "pollo entero Asado",
                precio= "30.000";
        Intent i = new  Intent(this, Domicilio.class);
        i.putExtra("precio",precio);
        i.putExtra("pollo",pollo);
        i.putExtra("correo",dato);
        startActivity(i);
    }


    public void Aspollo_Combo(View view){
        String dato = getIntent().getStringExtra("correo"), pollo = "Combo con papas",
                precio= "9.000";
        Intent i = new  Intent(this, Domicilio.class);
        i.putExtra("precio",precio);
        i.putExtra("pollo",pollo);
        i.putExtra("correo",dato);
        startActivity(i);
    }
}