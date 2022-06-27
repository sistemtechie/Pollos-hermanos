package com.example.polloshermanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class acpass extends AppCompatActivity {
    EditText edtc,edtap,edtup,edtps;
    data datab = new data(this,"BD1",null,1);
    TextInputLayout l1,l2,l3,l4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acpass);
        edtc = findViewById(R.id.editReMailu);
        edtap = findViewById(R.id.passwordold);
        edtup = findViewById(R.id.editpassu);
        edtps = findViewById(R.id.editpassp);
        l1 = findViewById(R.id.Pemail);
        l2 = findViewById(R.id.Ppassold);
        l3 = findViewById(R.id.Ppassnew);
        l4 = findViewById(R.id.editpassu);

    }
    public void actulizarpas(View view) {
        String correo = edtc.getText().toString();
        String pasold = edtap.getText().toString();
        String passud = edtup.getText().toString();
        String passco = edtps.getText().toString();

        if (!correo.isEmpty() && !pasold.isEmpty() && !passud.isEmpty() && !passco.isEmpty()) {
            boolean cor= false;
            SQLiteDatabase data = datab.getWritableDatabase();
            Cursor rcursor;
            rcursor = data.query("usuarios",new String[]{"ID",
                    "Nombre","Direccion","Correo","Password"},"Correo like '"+correo+"' "+
                    "and Password like '"+pasold+"'",null,null,null,null);
            if (passud.equals(passco)) {
                if (rcursor.getCount() > 0) {
                    try {
                        data.execSQL("update usuarios set Password = '"+passud+"'where Correo= '"+correo+"'");
                        cor= true;
                    }catch (SQLException e){
                        e.printStackTrace();
                        cor= false;
                    }finally {
                        data.close();
                    }
                    if(cor){
                        Toast.makeText(this,"La contraseña  actualizada ",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(this,ingreso.class);
                        i.putExtra("correo",correo);
                        startActivity(i);
                    }else{
                        Toast.makeText(this,"Error al actualizar la contraseña",Toast.LENGTH_LONG).show();
                    }
                }else{
                    l1.setError("Correo y contraseña incorrectos");
                    l2.setError("Correo y contraseña incorrectos");
                    Toast.makeText(this,"Correo y contraseña incorrectos ",Toast.LENGTH_LONG).show();
                    edtup.isFocused();
                }
            }else{
                l3.setError("Las contraseñas no coincide");
                l4.setError("Las contraseñas no coincide");
                Toast.makeText(this,"Las contraseñas no coincide",Toast.LENGTH_LONG).show();
                edtup.isFocused();
            }
        }else{
            l3.setError("Por favor no dejar ningun espacio en blanco");
            l4.setError("Por favor no dejar ningun espacio en blanco");
            l3.setError("Por favor no dejar ningun espacio en blanco");
            l4.setError("Por favor no dejar ningun espacio en blanco");
            Toast.makeText(this,"Por favor no dejar ningun espacio en blanco",Toast.LENGTH_LONG).show();
            edtup.isFocused();
        }
    }

}