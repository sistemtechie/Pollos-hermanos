package com.example.polloshermanos.CapaDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class Conexion extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "Pollo" ;
    public Conexion(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String users="create table user(Id Integer primary key autoincrement,Nombre text,Email text ,Adress text," +
                "Password text)";
        String orders = "create table orden(Id Integer primary key autoincrement,Email text ,Nombre text," +
                "Precio text,Direccion text, fecha data default current_time, foreign key (Email) references users(Email))";
        db.execSQL(users);
        db.execSQL(orders);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table "+DATABASE_NOMBRE);
        onCreate(db);
    }
}
