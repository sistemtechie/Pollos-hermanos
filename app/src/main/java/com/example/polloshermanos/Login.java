package com.example.polloshermanos;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    EditText et_mail, et_password;
    data datab = new data(this,"BD1",null,1);
    TextInputLayout la,la2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        la = findViewById(R.id.corl);
        la2 = findViewById(R.id.pas);
        et_mail = findViewById(R.id.mail_into);
        et_password = findViewById(R.id.pass_into);
    }

    public void register(View view) {
        Intent intent = new Intent(Login.this, register.class);
        startActivity(intent);
    }

    public void login(View view){
        String  password = et_password.getText().toString(), user = et_mail.getText().toString();
        try {
            Cursor cursor = datab.ConsultarUser(user, password);
            if(cursor.getCount()>0){
                Intent i = new Intent(this,ingreso.class);
                i.putExtra("correo",user);
                startActivity(i);
            }else{
                la.setError("usuario incorrecto");
                Toast.makeText(this,"usuario y/o contraseña Incorrectos", Toast.LENGTH_LONG).show();
                la2.setError("Contraseña incorrecta");
            }
            et_password.setText("");
            et_mail.setText("");
            et_password.isFocused();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}