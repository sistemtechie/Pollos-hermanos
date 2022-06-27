package com.example.polloshermanos;
import android.app.Person;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public  class data extends SQLiteOpenHelper {
    public data(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase datab) {
        String queryi="create table usuarios (ID integer primary key autoincrement, Nombre text," +
                " Correo text, Direccion text, Password text )";
        String query = "create table compra(ID integer primary key autoincrement, Correo text,Direccion text, Pollo text, precio text,fecha datetime default current_timestamp ,foreign key(Correo) references usuario(Correo))";
        datab.execSQL(queryi);
        datab.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase datab, int i, int i1) {

    }
    public void  abrir(){
        this.getWritableDatabase();
    }
    public void cerrar(){
        this.close();
    }

    // crear insert de pedido

    public long insertpollo(String cor, String Dir, String Pol, String precio){
        android.database.Cursor rcursor = null;

        ContentValues valores = new ContentValues();
        valores.put("Correo",cor);
        valores.put("Direccion",Dir);
        valores.put("Pollo",Pol);
        valores.put("precio",precio);
        long pr=   this.getWritableDatabase().insert("compra",null,valores);

        return pr;
    }

    public Cursor insertuser(String nom, String cor, String Dir, String pass){
        android.database.Cursor rcursor = null;
        rcursor = this.getReadableDatabase().query("usuarios",new String[]{"ID",
                "Nombre","Correo","Direccion","Password"},"Correo like '"+cor+"' ",null,null,null,null);
        if(rcursor.getCount()>0){

        }else{
            ContentValues valores = new ContentValues();
            valores.put("Nombre",nom);
            valores.put("Correo",cor);
            valores.put("Direccion",Dir);
            valores.put("Password",pass);
            this.getWritableDatabase().insert("usuarios",null,valores);
        }
        return rcursor;

    }
    public Cursor ConsultarUser(String usu, String pass) throws SQLException {
        android.database.Cursor mcursor = null;

        mcursor = this.getReadableDatabase().query("usuarios",new String[]{"ID",
                "Nombre","Direccion","Correo","Password"},"Correo like '"+usu+"' "+
                "and Password like '"+pass+"'",null,null,null,null);
        return mcursor;

    }






}
