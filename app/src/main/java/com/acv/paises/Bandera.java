package com.acv.paises;

public class Bandera {

   private int idImagen;
   private String nombrePais;

    Bandera(int id, String nombre){
        this.idImagen = id;
        this.nombrePais = nombre;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
}
