package com.example.myapprecetas;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // --- CÓDIGO PARA LA ANIMACIÓN DEL FONDO ---
        LinearLayout loginLayout = findViewById(R.id.login_layout); // Usamos el ID de este layout
        AnimationDrawable animationDrawable = (AnimationDrawable) loginLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etContrasena = findViewById(R.id.etContrasena);
        Button btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(v -> {
            String usuario = etUsuario.getText().toString();
            String contrasena = etContrasena.getText().toString();

            if (usuario.equals("admin") && contrasena.equals("1234")) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
