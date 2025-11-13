package com.example.myapprecetas;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // --- CÓDIGO PARA LA ANIMACIÓN DEL FONDO ---
        // 1. Obtener el layout principal usando el ID que le dimos
        LinearLayout menuLayout = findViewById(R.id.menu_layout);

        // 2. Obtener el fondo y convertirlo a AnimationDrawable
        AnimationDrawable animationDrawable = (AnimationDrawable) menuLayout.getBackground();

        // 3. Configurar la animación para que entre y salga suavemente
        animationDrawable.setEnterFadeDuration(2000); // 2 segundos para entrar
        animationDrawable.setExitFadeDuration(4000);  // 4 segundos para salir

        // 4. Iniciar la animación
        animationDrawable.start();

        ImageView ivMenu = findViewById(R.id.ivMenu);
        ivMenu.setImageResource(R.drawable.otter_chef); // Nombre real de tu imagen


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
