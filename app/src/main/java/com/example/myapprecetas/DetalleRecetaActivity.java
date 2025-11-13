// Archivo: DetalleRecetaActivity.java
package com.example.myapprecetas;

import android.graphics.drawable.AnimationDrawable; // <-- Importar
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout; // <-- Importar
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleRecetaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_receta);

        // --- CÓDIGO PARA LA ANIMACIÓN DEL FONDO ---
        LinearLayout detalleLayout = findViewById(R.id.detalle_layout); // Usamos el ID de este layout
        AnimationDrawable animationDrawable = (AnimationDrawable) detalleLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        // --- El resto de tu código de detalle queda exactamente igual ---
        // 1. Vinculamos las vistas del XML
        ImageView ivReceta = findViewById(R.id.ivReceta);
        TextView tvNombreReceta = findViewById(R.id.tvNombreReceta);
        TextView tvIngredientes = findViewById(R.id.tvIngredientes);
        TextView tvPasoAPaso = findViewById(R.id.tvPasoAPaso);
        Button btnVolver = findViewById(R.id.btnVolver);

        // 2. Recibimos el OBJETO Receta completo que nos envió la actividad anterior
        Receta receta = getIntent().getParcelableExtra("receta_seleccionada");

        // ¡Se acabaron los if/else! Ahora simplemente usamos el objeto.
        if (receta != null) {
            // 3. Poblamos las vistas con los datos del objeto Receta
            tvNombreReceta.setText(receta.getNombre());
            tvIngredientes.setText(receta.getIngredientes());
            tvPasoAPaso.setText(receta.getPreparacion());
            ivReceta.setImageResource(receta.getIdImagen());
        }

        // 4. Configuramos el botón de volver
        btnVolver.setOnClickListener(v -> finish());
    }
}


