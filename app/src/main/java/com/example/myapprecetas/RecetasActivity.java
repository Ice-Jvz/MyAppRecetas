package com.example.myapprecetas;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RecetasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        TextView tvCategoria = findViewById(R.id.tvCategoria);
        Button btnReceta1 = findViewById(R.id.btnReceta1);
        Button btnReceta2 = findViewById(R.id.btnReceta2);
        Button btnReceta3 = findViewById(R.id.btnReceta3);
        Button btnVolver = findViewById(R.id.btnVolver);

        // Obtiene el nombre de la categoría enviada desde el menú
        String categoria = getIntent().getStringExtra("categoria");
        if (categoria != null) {
            tvCategoria.setText("Recetas de " + categoria);
        }

        // Cambia nombres de recetas según categoría (ejemplo sencillo)
        if ("Desayuno".equals(categoria)) {
            btnReceta1.setText("Tostadas");
            btnReceta2.setText("Omelette");
            btnReceta3.setText("Smoothie");
        } else if ("Almuerzo".equals(categoria)) {
            btnReceta1.setText("Pasta");
            btnReceta2.setText("Ensalada");
            btnReceta3.setText("Sopa de verduras");
        } else if ("Snack".equals(categoria)) {
            btnReceta1.setText("Fruta picada");
            btnReceta2.setText("Sandwich");
            btnReceta3.setText("Yogur griego");
        } else if ("Cena".equals(categoria)) {
            btnReceta1.setText("Pollo a la plancha");
            btnReceta2.setText("Arroz con verduras");
            btnReceta3.setText("Sopa rápida");
        }

        // Cada botón lleva a la vista detalle de receta
        btnReceta1.setOnClickListener(v -> abrirDetalle(btnReceta1.getText().toString()));
        btnReceta2.setOnClickListener(v -> abrirDetalle(btnReceta2.getText().toString()));
        btnReceta3.setOnClickListener(v -> abrirDetalle(btnReceta3.getText().toString()));

        // Botón para volver al menú
        btnVolver.setOnClickListener(v -> finish());
    }

    private void abrirDetalle(String nombreReceta) {
        Intent intent = new Intent(RecetasActivity.this, DetalleRecetaActivity.class);
        intent.putExtra("nombreReceta", nombreReceta);
        startActivity(intent);
    }
}