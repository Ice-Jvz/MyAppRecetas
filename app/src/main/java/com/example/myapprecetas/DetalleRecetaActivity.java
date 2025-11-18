// Archivo: DetalleRecetaActivity.java
package com.example.myapprecetas;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * DetalleRecetaActivity es la pantalla que muestra toda la información de una
 * receta específica seleccionada por el usuario.
 * <p>
 * Esta actividad se inicia esperando recibir un objeto {@link Receta} a través
 * de un Intent. El objeto debe ser {@link android.os.Parcelable} para poder ser
 * transferido entre actividades. Una vez recibido, utiliza los datos de la receta
 * para poblar los diferentes componentes de la interfaz de usuario.
 * </p>
 *
 * @version 1.0
 * @since 2025-11-17
 * @author [Jhonatan Castro]
 */
public class DetalleRecetaActivity extends AppCompatActivity {

    /**
     * Se llama cuando la actividad es creada por primera vez.
     * <p>
     * Se encarga de inicializar la interfaz, configurar la animación, recibir el objeto
     * {@link Receta} de la actividad anterior y mostrar sus detalles en las vistas
     * correspondientes (TextViews, ImageView, etc.).
     * </p>
     *
     * @param savedInstanceState Si la actividad se está reinicializando, este Bundle
     *                           contiene datos previos. De lo contrario, es nulo.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establece el layout de la interfaz de usuario desde res/layout/activity_detalle_receta.xml
        setContentView(R.layout.activity_detalle_receta);

        // --- CÓDIGO PARA LA ANIMACIÓN DEL FONDO ---
        // Obtiene la referencia al layout principal para aplicar la animación.
        LinearLayout detalleLayout = findViewById(R.id.detalle_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) detalleLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        // --- VINCULACIÓN DE VISTAS ---
        // Obtiene las referencias a los componentes de la interfaz de usuario.
        ImageView ivReceta = findViewById(R.id.ivReceta);
        TextView tvNombreReceta = findViewById(R.id.tvNombreReceta);
        TextView tvIngredientes = findViewById(R.id.tvIngredientes);
        TextView tvPasoAPaso = findViewById(R.id.tvPasoAPaso);
        Button btnVolver = findViewById(R.id.btnVolver);

        // --- RECEPCIÓN Y PROCESAMIENTO DE DATOS ---
        // Recupera el objeto Receta que fue pasado desde la actividad anterior.
        // La clave "receta_seleccionada" debe coincidir con la usada en el putExtra() del Intent.
        Receta receta = getIntent().getParcelableExtra("receta_seleccionada");

        // Comprueba que el objeto recibido no sea nulo antes de usarlo.
        if (receta != null) {
            // Puebla los componentes de la UI con los datos del objeto Receta.
            tvNombreReceta.setText(receta.getNombre());
            tvIngredientes.setText(receta.getIngredientes());
            tvPasoAPaso.setText(receta.getPreparacion());
            ivReceta.setImageResource(receta.getIdImagen());
        }

        // --- LÓGICA DE NAVEGACIÓN ---
        // Configura el listener para el botón de "Volver".
        // finish() cierra la actividad actual y regresa al usuario a la pantalla anterior.
        btnVolver.setOnClickListener(v -> finish());
    }
}




