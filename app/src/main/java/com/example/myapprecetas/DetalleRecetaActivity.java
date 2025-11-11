package com.example.myapprecetas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleRecetaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_receta);

        TextView tvNombreReceta = findViewById(R.id.tvNombreReceta);
        TextView tvIngredientes = findViewById(R.id.tvIngredientes);
        TextView tvPasoAPaso = findViewById(R.id.tvPasoAPaso);
        Button btnVolver = findViewById(R.id.btnVolver);

        // Obtener el nombre de la receta desde el intent
        String nombreReceta = getIntent().getStringExtra("nombreReceta");
        tvNombreReceta.setText(nombreReceta);

        // Puedes definir aquí los ingredientes y pasos de cada receta de forma sencilla
        // Esto lo puedes hacer con "if" o "switch" para cada receta
        if ("Tostadas".equals(nombreReceta)) {
            tvIngredientes.setText("Ingredientes:\n- Pan\n- Mantequilla\n- Mermelada");
            tvPasoAPaso.setText("Preparación:\n1. Tuesta el pan\n2. Unta mantequilla\n3. Añade mermelada.");
        } else if ("Omelette".equals(nombreReceta)) {
            tvIngredientes.setText("Ingredientes:\n- Huevos\n- Queso\n- Jamón");
            tvPasoAPaso.setText("Preparación:\n1. Bate los huevos\n2. Añade jamón y queso\n3. Cocina en sartén.");
        }
        //... agrega más recetas según quieras

        btnVolver.setOnClickListener(v -> finish());
    }
}
