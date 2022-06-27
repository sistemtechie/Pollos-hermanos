package com.example.polloshermanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class actulDir extends AppCompatActivity {
    EditText cor,pas,mao;
    data datab = new data(this,"BD1",null,1);
    TextInputLayout l1,l2,l3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actul_dir);
        cor = findViewById(R.id.editReMailc);
        pas = findViewById(R.id.passworup);
        mao = findViewById(R.id.editdir);

        l1 = findViewById(R.id.Ldgma);
        l2 = findViewById(R.id.passworup);
        l3 = findViewById(R.id .Lddir);
    }

    public void dirc(View view){
        String corr = cor.getText().toString();
        String pass = pas.getText().toString();
        String dir = mao.getText().toString();
        boolean confir = false;
        if(!corr.isEmpty()&&!pass.isEmpty()&&!dir.isEmpty()){
            SQLiteDatabase data = datab.getWritableDatabase();
            Cursor rcursor;
            rcursor = data.query("usuarios",new String[]{"ID",
                    "Nombre","Direccion","Correo","Password"},"Correo like '"+corr+"' "+
                    "and Password like '"+pass+"'",null,null,null,null);
            if(rcursor.getCount()>0){
                try {
                    data.execSQL("update usuarios set Direccion = '"+dir+"'where Correo= '"+corr+"'");
                    confir= true;
                }catch (SQLException e){
                    e.printStackTrace();
                    confir = false;
                }finally {
                    data.close();
                }
                if(confir){
                    Toast.makeText(this,"La contraseña ha sido Direccion ",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this,ingreso.class);
                    i.putExtra("correo",corr);
                    startActivity(i);
                }else{
                    Toast.makeText(this,"Error al actualizar la Direccion  ",Toast.LENGTH_LONG).show();
                    cor.isFocused();
                }
            }else{
                l1.setError("Correo y contraseña no coinciden");
                l2.setError("Error al actualizar la Direccion ");
                Toast.makeText(this,"Correo y contraseña no coinciden",Toast.LENGTH_LONG).show();
                cor.isFocused();
            }
        }else{
            l1.setError("Correo y contraseña no coinciden");
            l2.setError("Error al actualizar la Direccion ");
            l3.setError("Error al actualizar la Direccion ");
            Toast.makeText(this,"Por favor no dejar ningun espacio en blanco",Toast.LENGTH_LONG).show();
            cor.isFocused();
        }
    }
}