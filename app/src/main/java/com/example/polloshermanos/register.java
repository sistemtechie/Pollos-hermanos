package com.example.polloshermanos;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class register extends AppCompatActivity {

    EditText et_Nombre, et_mail, et_password, et_password2,et_map;
    data datab = new data(this,"BD1",null,1);
    TextInputLayout l1,l2,l3,l4,l5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_Nombre = findViewById(R.id.editReName);
        et_mail = findViewById(R.id.editReMail);
        et_map = findViewById(R.id.editMap);
        et_password = findViewById(R.id.editRePass);
        et_password2 = findViewById(R.id.editRePassw);
        l1 = findViewById(R.id.Lname);
        l2 = findViewById(R.id.Lgmail);
        l3 = findViewById(R.id.Ldir);
        l4 = findViewById(R.id.Lpass);
        l5 = findViewById(R.id.Lpass2);
    }
// Metodo para devolver al login
    public void enter (View view) {

        Intent intent = new Intent(register.this, Login.class);
        startActivity(intent);
    }
// metodo para registrarse

    public void regester (View view){


        String password = et_password.getText().toString();
        String pass2 = et_password2.getText().toString();
        String name = et_Nombre.getText().toString();
        String mail = et_mail.getText().toString();
        String map = et_map.getText().toString();

        if(!password.isEmpty() && !pass2.isEmpty() && !name.isEmpty() && !mail.isEmpty() && !map.isEmpty()){

            if(password.equals(pass2)){
                datab.abrir();
               Cursor cursor = datab.insertuser(String.valueOf(et_Nombre.getText()),
                        String.valueOf(et_mail.getText()),
                        String.valueOf(et_map.getText()),
                        String.valueOf(et_password.getText()));
                if(cursor.getCount()>0){
                    datab.cerrar();
                    l2.setError("El usuario ya existe ");
                    Toast.makeText(this,"El usuario ya existe ",Toast.LENGTH_LONG).show();
                }else{
                    Intent i= new Intent(this,ingreso.class);
                    i.putExtra("correo",mail);
                    startActivity(i);
                    Toast.makeText(this,"Registro almacenado con exito",Toast.LENGTH_LONG).show();
                }
            }else{
                l4.setError("Las contraseñas no coniciden");
                l5.setError("Las contraseñas no coniciden");
                Toast.makeText(this,"Las contraseñas no coniciden", Toast.LENGTH_LONG).show();
                et_password2.isFocused();
            }
        }else{
            l1.setError("No se puden dejar espacios en blanco");
            l2.setError("No se puden dejar espacios en blanco");
            l3.setError("No se puden dejar espacios en blanco");
            l4.setError("No se puden dejar espacios en blanco");
            l5.setError("No se puden dejar espacios en blanco");
            Toast.makeText(this,"No se puden dejar espacios en blanco", Toast.LENGTH_LONG).show();
            et_Nombre.isFocused();
        }

    }
}