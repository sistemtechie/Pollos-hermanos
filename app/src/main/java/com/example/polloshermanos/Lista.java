package com.example.polloshermanos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
    data datab = new data(this,"BD1",null,1);

    ListView lista;
    ArrayList<String> informacion;
    ArrayList<compras> Compra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        lista = findViewById(R.id.liscompra);
        consultar();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,informacion);
        lista.setAdapter(adapter);
    }

    private void consultar() {
        String Correo = getIntent().getStringExtra("correo");
        compras Compras = null;
        SQLiteDatabase db = datab.getReadableDatabase();
        Compra = new ArrayList<compras>();
        Cursor cursor = db.query("compra",new String[]{"ID",
                "Correo","Direccion","Pollo","precio","fecha"},"Correo like '"+Correo+"' ",null,null,null,null);

        while (cursor.moveToNext()){
            Compras = new compras();
            Compras.setDir(cursor.getString(2));
            Compras.setPollo(cursor.getString(3));
            Compras.setPrecio(cursor.getString(4));
            Compras.setFecha(cursor.getString(5));
            Compra.add(Compras);
        }
        obtenerListar();
    }

    private void obtenerListar() {
        informacion = new ArrayList<String>();

        for(int i=0; i<Compra.size();i++){
            informacion.add("Producto:"+Compra.get(i).getPollo()+"  Precio:"+Compra.get(i).getPrecio()+" Direccion:"+Compra.get(i).getDir() + "Fecha de compra"+Compra.get(i).getFecha());
        }
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
}