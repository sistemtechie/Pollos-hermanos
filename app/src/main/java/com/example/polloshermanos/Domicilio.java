package com.example.polloshermanos;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Domicilio extends AppCompatActivity {
    data datab = new data(this,"BD1",null,1);
    TextView et1,et2,et3,et4,et5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domicilio);
        SQLiteDatabase db = datab.getReadableDatabase();
        et1 = findViewById(R.id.Nombre);
        et2 = findViewById(R.id.correo);
        et3 = findViewById(R.id.Direccion);
        et4 = findViewById(R.id.tipo);
        et5 = findViewById(R.id.Precio);

        String Correo = getIntent().getStringExtra("correo");
        String precio = getIntent().getStringExtra("precio");
        String pollo = getIntent().getStringExtra("pollo");
        Cursor  cursor = db.query("usuarios",new String[]{"ID",
                "Nombre","Correo","Direccion","Password"},"Correo like '"+Correo+"' ",null,null,null,null);
        cursor.moveToFirst();
        String a = cursor.getString(0);

        et1.setText(cursor.getString(1));
        et2.setText(Correo);
        et3.setText(cursor.getString(3));
        et4.setText(pollo);
        et5.setText(precio);

    }

    public void ingresar(View view){
        String Correo = getIntent().getStringExtra("correo");
        String precio = getIntent().getStringExtra("precio");
        String pollo = getIntent().getStringExtra("pollo");
        String direccion = et3.getText().toString();
        long  inser = datab.insertpollo(Correo,direccion,pollo,precio);
        if(inser>0){
            Toast.makeText(this,"La compra se a realizado con exito",Toast.LENGTH_LONG);
            Intent i = new Intent(this,ingreso.class);
            i.putExtra("correo",Correo);
            startActivity(i);
        }else{
            Toast.makeText(this,"Compra no realizada",Toast.LENGTH_LONG);
            Intent i = new Intent(this,ingreso.class);
            i.putExtra("correo",Correo);
            startActivity(i);
        }

    }

    public void volver (View view){
        String Correo = getIntent().getStringExtra("correo");
        Intent i = new Intent(this,menu.class);
        i.putExtra("correo",Correo);
        startActivity(i);
    }

}