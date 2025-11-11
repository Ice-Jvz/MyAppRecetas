package com.example.myapprecetas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnDesayuno = findViewById(R.id.btnDesayuno);
        Button btnAlmuerzo = findViewById(R.id.btnAlmuerzo);
        Button btnSnack = findViewById(R.id.btnSnack);
        Button btnCena = findViewById(R.id.btnCena);

        btnDesayuno.setOnClickListener(v -> abrirRecetas("Desayuno"));
        btnAlmuerzo.setOnClickListener(v -> abrirRecetas("Almuerzo"));
        btnSnack.setOnClickListener(v -> abrirRecetas("Snack"));
        btnCena.setOnClickListener(v -> abrirRecetas("Cena"));
    }

    private void abrirRecetas(String categoria) {
        Intent intent = new Intent(MenuActivity.this, RecetasActivity.class);
        intent.putExtra("categoria", categoria);
        startActivity(intent);
    }
}
