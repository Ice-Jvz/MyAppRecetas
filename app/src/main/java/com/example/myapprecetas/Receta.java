// Archivo: Receta.java
package com.example.myapprecetas;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Representa el modelo de datos para una receta en la aplicación.
 * <p>
 * Esta clase encapsula toda la información asociada a una receta, incluyendo su nombre,
 * ingredientes, pasos de preparación, una imagen y su categoría.
 * </p>
 * <p>
 * Implementa la interfaz {@link Parcelable}, lo que permite que instancias de esta clase
 * sean pasadas de una Activity a otra a través de un Intent. Esto es fundamental para,
 * por ejemplo, enviar la receta seleccionada a {@link DetalleRecetaActivity}.
 * </p>
 *
 * @version 1.0
 * @since 2025-11-17
 * @author [Jhonatan Castro]
 */
public class Receta implements Parcelable {

    // --- Atributos de la clase ---

    /** El nombre o título de la receta. */
    private String nombre;

    /** Un texto que contiene la lista de ingredientes necesarios. */
    private String ingredientes;

    /** Un texto con las instrucciones o pasos a seguir para la preparación. */
    private String preparacion;

    /** El identificador del recurso drawable (ej. R.drawable.omelette) para la imagen de la receta. */
    private int idImagen;

    /** La categoría a la que pertenece la receta (ej. "Postres", "Desayunos"). */
    private String categoria;

    /**
     * Constructor para crear una nueva instancia de una receta.
     *
     * @param nombre El nombre de la receta.
     * @param ingredientes La lista de ingredientes.
     * @param preparacion Los pasos de preparación.
     * @param idImagen El ID del recurso drawable para la imagen.
     * @param categoria La categoría de la receta.
     */
    public Receta(String nombre, String ingredientes, String preparacion, int idImagen, String categoria) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.idImagen = idImagen;
        this.categoria = categoria;
    }

    // --- Métodos "Getter" para acceder a los datos ---

    /** @return El nombre de la receta. */
    public String getNombre() {
        return nombre;
    }

    /** @return La lista de ingredientes de la receta. */
    public String getIngredientes() {
        return ingredientes;
    }

    /** @return Los pasos de preparación de la receta. */
    public String getPreparacion() {
        return preparacion;
    }

    /** @return El ID del recurso drawable de la imagen de la receta. */
    public int getIdImagen() {
        return idImagen;
    }

    /** @return La categoría de la receta. */
    public String getCategoria() {
        return categoria;
    }

    // --- Implementación de Parcelable (código autogenerado) ---
    // Esta sección permite que el objeto sea "serializado" para ser transportado en un Intent.

    /**
     * Constructor privado usado por el CREATOR para reconstruir el objeto desde un Parcel.
     * @param in El Parcel que contiene los datos del objeto.
     */
    protected Receta(Parcel in) {
        nombre = in.readString();
        ingredientes = in.readString();
        preparacion = in.readString();
        idImagen = in.readInt();
        categoria = in.readString();
    }

    /**
     * Objeto estático requerido por la interfaz Parcelable. Es responsable de crear
     * instancias de la clase Receta a partir de un Parcel.
     */
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

    /**
     * Describe tipos de objetos especiales contenidos en la representación del Parcelable.
     * Para esta clase, siempre devuelve 0.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Escribe los datos del objeto en un Parcel para su transporte.
     * @param dest El Parcel en el que se deben escribir los datos.
     * @param flags Banderas adicionales sobre cómo se debe escribir el objeto.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(ingredientes);
        dest.writeString(preparacion);
        dest.writeInt(idImagen);
        dest.writeString(categoria);
    }
}


