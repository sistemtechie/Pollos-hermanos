package com.example.polloshermanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.polloshermanos.CapaEntidad.CE_Usuarios;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    EditText et1,et2;
    TextInputLayout l1,l2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1 = findViewById(R.id.mail_into);
        et2 = findViewById(R.id.pass_into);
        l1 = findViewById(R.id.corl);
        l2 = findViewById(R.id.pas);
    }

    public void singup(View view){
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }

    public void singin (View view){
        String Email = et1.getText().toString();
        String Password = et2.getText().toString();
        Intent i = new Intent(this,Index.class);
        boolean Ver, Into;
        CE_Usuarios Usuarios = new CE_Usuarios(Login.this);
        Ver = Usuarios.Verifca(Email,Password);
        if(Ver){
            Into = Usuarios.searche(Email,Password);
            if(Into){
                startActivity(i);
            }else{
                l1.setError("Usuarios y contraseña incorrecto");
                l2.setError("Usuarios y contraseña incorrecto");
            }
        }else{
            l1.setError("No dejar ningun campo en blanco");
            l2.setError("No dejar ningun campo en blanco");
        }
    }
}