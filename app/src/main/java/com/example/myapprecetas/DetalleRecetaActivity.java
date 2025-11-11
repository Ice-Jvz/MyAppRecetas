package com.example.myapprecetas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView; // <<< SOLUCIÓN 1: Importar ImageView
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleRecetaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_receta);

        // --- 1. Vinculamos todas las vistas del XML ---
        ImageView ivReceta = findViewById(R.id.ivReceta);
        TextView tvNombreReceta = findViewById(R.id.tvNombreReceta);
        TextView tvIngredientes = findViewById(R.id.tvIngredientes);
        TextView tvPasoAPaso = findViewById(R.id.tvPasoAPaso);
        Button btnVolver = findViewById(R.id.btnVolver);

        // --- 2. Obtenemos la información pasada desde la pantalla anterior (UNA SOLA VEZ) ---
        String nombreReceta = getIntent().getStringExtra("nombreReceta");

        // --- 3. Actualizamos toda la UI (interfaz de usuario) con la información ---
        tvNombreReceta.setText(nombreReceta);

        // Usamos "if/else if" para configurar la imagen, ingredientes y pasos según la receta
        if ("Tostadas".equals(nombreReceta)) {
            ivReceta.setImageResource(R.drawable.tostada);
            tvIngredientes.setText("Ingredientes:\n- Pan\n- Mantequilla\n- Mermelada");
            tvPasoAPaso.setText("Preparación:\n1. Tuesta el pan\n2. Unta mantequilla\n3. Añade mermelada.");

        } else if ("Omelette".equals(nombreReceta)) {
            // <<< SOLUCIÓN 2: Usar el nombre del recurso en minúsculas
            ivReceta.setImageResource(R.drawable.omelette_jamon_queso);
            tvIngredientes.setText("Ingredientes:\n- Huevos\n- Queso\n- Jamón");
            tvPasoAPaso.setText("Preparación:\n1. Bate los huevos\n2. Añade jamón y queso\n3. Cocina en sartén.");
        }
        // ... aquí puedes agregar más `else if` para otras recetas ...


        // --- 4. Configuramos los listeners de los botones ---
        btnVolver.setOnClickListener(v -> finish()); // Cierra esta pantalla y vuelve a la anterior
    }
}

