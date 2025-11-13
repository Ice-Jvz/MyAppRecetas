package com.example.myapprecetas;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class RecetasActivity extends AppCompatActivity {

    private List<Receta> recetasMostradas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        // --- CÓDIGO PARA LA ANIMACIÓN DEL FONDO ---
        LinearLayout recetasLayout = findViewById(R.id.recetas_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) recetasLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        // --- Vinculación de Vistas ---
        TextView tvCategoria = findViewById(R.id.tvCategoria);
        Button btnReceta1 = findViewById(R.id.btnReceta1);
        Button btnReceta2 = findViewById(R.id.btnReceta2);
        Button btnReceta3 = findViewById(R.id.btnReceta3);
        Button btnVolver = findViewById(R.id.btnVolver);

        // --- Lógica del Repositorio ---
        String categoria = getIntent().getStringExtra("categoria");
        if (categoria != null) {
            tvCategoria.setText("Recetas de " + categoria);
        }
        recetasMostradas = RepositorioRecetas.getRecetasPorCategoria(categoria);

        // --- Ocultar botones ---
        btnReceta1.setVisibility(View.GONE);
        btnReceta2.setVisibility(View.GONE);
        btnReceta3.setVisibility(View.GONE);


        // --- SOLUCIÓN 2: LÓGICA DE VISIBILIDAD Y CLICS CORREGIDA ---
        // Asignamos texto y listener solo si la receta existe.

        if (recetasMostradas.size() > 0) {
            btnReceta1.setText(recetasMostradas.get(0).getNombre());
            btnReceta1.setVisibility(View.VISIBLE);
            btnReceta1.setOnClickListener(v -> abrirDetalle(recetasMostradas.get(0)));
        }
        if (recetasMostradas.size() > 1) {
            btnReceta2.setText(recetasMostradas.get(1).getNombre());
            btnReceta2.setVisibility(View.VISIBLE);
            btnReceta2.setOnClickListener(v -> abrirDetalle(recetasMostradas.get(1)));
        }
        if (recetasMostradas.size() > 2) {
            btnReceta3.setText(recetasMostradas.get(2).getNombre());
            btnReceta3.setVisibility(View.VISIBLE);
            btnReceta3.setOnClickListener(v -> abrirDetalle(recetasMostradas.get(2)));
        }


        btnVolver.setOnClickListener(v -> finish());
    }

    private void abrirDetalle(Receta receta) {
        Intent intent = new Intent(RecetasActivity.this, DetalleRecetaActivity.class);
        intent.putExtra("receta_seleccionada", receta);
        startActivity(intent);
    }
}


