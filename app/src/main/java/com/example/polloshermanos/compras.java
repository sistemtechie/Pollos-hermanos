package com.example.polloshermanos;

import java.io.Serializable;

public class compras implements Serializable {

    private String pollo;
    private String precio;
    private String dir;
    private String fecha;
    public compras(String pollo,String precio ,String dir) {
        this.pollo = pollo;
        this.precio = precio;
        this.dir = dir;
    }
    public compras(){

    }
    public String getPollo() {
        return pollo;
    }

    public void setPollo(String pollo) {
        this.pollo = pollo;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getPrecio() {
        return precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
