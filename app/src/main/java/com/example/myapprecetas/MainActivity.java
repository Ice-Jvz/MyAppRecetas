package com.example.myapprecetas;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- CÓDIGO PARA LA ANIMACIÓN DEL FONDO (COPIADO DE MENUACTIVITY) ---
        LinearLayout mainLayout = findViewById(R.id.main_layout); // Usamos el ID de este layout
        AnimationDrawable animationDrawable = (AnimationDrawable) mainLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        Button btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
        });
    }
}
