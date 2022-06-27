package com.example.polloshermanos.CapaEntidad;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.core.util.PatternsCompat;

import com.example.polloshermanos.CapaDatos.CD_Usuarios;

import java.util.regex.Pattern;

public class CE_Usuarios extends CD_Usuarios {
    Context context;

    public CE_Usuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public int Vregis (String Nombre,String Email,String Adress,String Password, String Password2){
        Pattern conta = Pattern.compile("^"+".{8,}"+"$");
        if(Nombre.isEmpty()){
            return 1;
        }else if(!PatternsCompat.EMAIL_ADDRESS.matcher(Email).matches()){
            return 2;
        }else if(Adress.isEmpty()){
            return 3;
        }else if(Password.isEmpty() && Password.isEmpty()){
            return 4;
        }else if(!Password.equals(Password2)){
            return 5;
        }else if(!conta.matcher(Password).matches()){
            return 6;
        }else{
            return 0;
        }
    }
    public boolean ingre (String Nombre,String Email,String Adress,String Password){
        boolean check;
        CD_Usuarios save = new CD_Usuarios(context);
        check = save.insert(Nombre,Email,Adress,Password);
        if(check){
            return true;
        }else{
            return  false;
        }
    }
    public boolean searche (String Email, String password){
        boolean check;
        CD_Usuarios save = new CD_Usuarios(context);
        check = save.usersearh(Email,password);
        if(check){
            return true;
        }else {
            return  false;
        }
    }
    public boolean search(String Email){
        boolean check;
        CD_Usuarios save = new CD_Usuarios(context);
        check = save.search(Email);
        if(check){
            return true;
        }else{
            return false;
        }
    }

    public boolean Verifca(String Email, String password){
        if(!Email.isEmpty() && !password.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
