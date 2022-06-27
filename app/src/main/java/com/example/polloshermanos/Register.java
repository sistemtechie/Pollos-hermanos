package com.example.polloshermanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.polloshermanos.CapaDatos.CD_Usuarios;
import com.example.polloshermanos.CapaEntidad.CE_Usuarios;
import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {
    TextInputLayout la1,la2,la3,la4,la5;
    EditText et_Nombre, et_mail, et_password, et_password2,et_map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_Nombre = findViewById(R.id.editReName);
        et_mail = findViewById(R.id.editReMail);
        et_map = findViewById(R.id.editMap);
        et_password = findViewById(R.id.editRePass);
        et_password2 = findViewById(R.id.editRePassw);
        la1 = findViewById(R.id.laName);
        la2 = findViewById(R.id.laEmail);
        la3 = findViewById(R.id.laAdre);
        la4 = findViewById(R.id.laPass);
        la5 = findViewById(R.id.laPass2);
    }
    public void signin (View view) {

        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
    }

    public void  signup(View view){
        int verificacion;
        boolean encon, registro;
        String Nombre = et_Nombre.getText().toString().trim(), Email=et_mail.getText().toString().trim(),
                Map=et_map.getText().toString().trim(),Password=et_password.getText().toString().trim(),
                Password2=et_password2.getText().toString().trim();
        CE_Usuarios regis = new CE_Usuarios(Register.this);
        verificacion =  regis.Vregis(Nombre,Email,Map,Password,Password2);
        switch (verificacion){
            case 1: la1.setError("No dejar El campo del nombre vacio");
                la2.setErrorEnabled(false);
                la3.setErrorEnabled(false);
                la4.setErrorEnabled(false);
                la2.setErrorEnabled(false);
                break;
            case 2: la1.setErrorEnabled(false);
                la2.setError("Ingresar un  correo valido");
                la3.setErrorEnabled(false);
                la4.setErrorEnabled(false);
                la5.setErrorEnabled(false);
                break;
            case 3: la1.setErrorEnabled(false);
                la2.setErrorEnabled(false);
                la3.setError("No dejar El campo de la dirección vacia");
                la4.setErrorEnabled(false);
                la2.setErrorEnabled(false);
                break;
            case 4: la1.setErrorEnabled(false);
                la2.setErrorEnabled(false);
                la3.setErrorEnabled(false);
                la4.setError("No dejar el campo de la contraseña vacio");
                la5.setError("No dejar el campo de la contraseña vacio");
                break;
            case 5: la1.setErrorEnabled(false);
                la2.setErrorEnabled(false);
                la3.setErrorEnabled(false);
                la4.setError("Las contraseñas no coinciden");
                la5.setError("Las contraseñas no coinciden");
                break;
            case 6: la1.setErrorEnabled(false);
                la2.setErrorEnabled(false);
                la3.setErrorEnabled(false);
                la4.setError("Ingresar una contraseña mayor a 7 caracteres");
                la5.setErrorEnabled(false);
                break;
            default: encon = regis.search(Email);
                if(encon){
                    Toast.makeText(this,"El usuario ya existe",Toast.LENGTH_LONG).show();
                }else{
                    registro =  regis.ingre(Nombre,Email,Map,Password);
                    if(registro){
                        Toast.makeText(this,"usuario creado",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(this,Load.class);
                        i.putExtra("Email",Email);
                        startActivity(i);
                    }else{
                        Toast.makeText(this,"Error al crear la cuenta",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }
}