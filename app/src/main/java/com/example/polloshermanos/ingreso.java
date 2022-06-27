package com.example.polloshermanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class ingreso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);
        String dato = getIntent().getStringExtra("correo");
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(ingreso.this,menu.class);
                intent.putExtra("correo",dato);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(tarea,1500);
    }
}