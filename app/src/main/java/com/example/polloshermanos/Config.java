package com.example.polloshermanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Config extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
    }

    public void menu(View view){
        String dato = getIntent().getStringExtra("correo");
        Intent i = new  Intent(this, menu.class);
        i.putExtra("correo",dato);
        startActivity(i);
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

    public void dir(View view){
        Intent i = new  Intent(this, actulDir.class);
        startActivity(i);
    }

    public void acpass(View view){
        Intent i = new  Intent(this, acpass.class);
        startActivity(i);
    }

    public void github (View view){
        Intent i = new  Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/sistemtechie/PollosHemanos"));
        startActivity(i);
    }
}