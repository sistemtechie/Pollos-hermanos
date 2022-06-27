package com.example.polloshermanos.CapaDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class CD_Usuarios extends Conexion{
    Context context;
    public CD_Usuarios(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public boolean search (String Email){
        Conexion save = new Conexion(context);
        SQLiteDatabase db = save.getWritableDatabase();
        try{
            Cursor cursor = null;
            cursor = db.query("user",new String[]{"Id","Nombre","Email","Adress","Password"},
                    "Email like '"+Email+"'",null,null,null,null);
            if(cursor.getCount()==0){
                return false;
            }else {
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean insert(String Name, String Email, String Adress,String Password){
        Conexion save = new Conexion(context);
        SQLiteDatabase db = save.getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            values.put("Nombre",Name);
            values.put("Email",Email);
            values.put("Adress",Adress);
            values.put("Password",Password);
            db.insert("user",null,values);
            return  true;
        }catch (SQLException e){
            return  true;
        }
    }
    public boolean retrieve (String Email, String password){
        Conexion save = new Conexion(context);
        SQLiteDatabase db = save.getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            values.put("Password",password);
            int result = db.update("user",values,"Email="+Email,null);
            if(result>0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return  false;
        }
    }
    public  boolean usersearh(String Email, String Password){
        Conexion save = new Conexion(context);
        SQLiteDatabase db = save.getWritableDatabase();
        try{
            Cursor cursor = null;
            cursor = db.query("user",new String[]{"Id","Nombre","Email","Adress","Password"},
                    "Email like '"+Email+"' and Password like'"+Password+"'",null,null,null,null);
            if(cursor.getCount()==0){
                return false;
            }else {
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
