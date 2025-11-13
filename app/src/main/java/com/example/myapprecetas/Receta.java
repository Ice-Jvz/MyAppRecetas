// Archivo: Receta.java
package com.example.myapprecetas;

import android.os.Parcel;
import android.os.Parcelable;

// Implementamos Parcelable para poder pasar objetos Receta entre Activities
public class Receta implements Parcelable {

    // 1. Atributos de la clase
    private String nombre;
    private String ingredientes;
    private String preparacion;
    private int idImagen; // Usaremos el ID del recurso drawable (ej. R.drawable.omelette)
    private String categoria;

    // 2. Constructor para crear nuevas recetas
    public Receta(String nombre, String ingredientes, String preparacion, int idImagen, String categoria) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.idImagen = idImagen;
        this.categoria = categoria;
    }

    // 3. Getters para obtener los datos
    public String getNombre() {
        return nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public String getCategoria() {
        return categoria;
    }

    // 4. Código autogenerado para Parcelable (permite pasar el objeto en un Intent)
    // No necesitas entenderlo a fondo, solo saber que es para que funcione el envío de datos.
    protected Receta(Parcel in) {
        nombre = in.readString();
        ingredientes = in.readString();
        preparacion = in.readString();
        idImagen = in.readInt();
        categoria = in.readString();
    }

    public static final Creator<Receta> CREATOR = new Creator<Receta>() {
        @Override
        public Receta createFromParcel(Parcel in) {
            return new Receta(in);
        }

        @Override
        public Receta[] newArray(int size) {
            return new Receta[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(ingredientes);
        dest.writeString(preparacion);
        dest.writeInt(idImagen);
        dest.writeString(categoria);
    }
}

