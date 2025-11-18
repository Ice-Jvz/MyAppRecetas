package com.example.myapprecetas;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * LoginActivity es la pantalla de inicio de la aplicación y actúa como un punto de autenticación.
 * El usuario debe ingresar un nombre de usuario y una contraseña válidos para acceder
 * al resto de la aplicación.
 *
 * <p>Esta actividad es el punto de entrada principal (LAUNCHER) según está definido
 * en el AndroidManifest.xml.</p>
 *
 * @version 1.0
 * @since 2025-11-17 //
 * @author [Jhonatan Castro] //
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Este método se llama cuando la actividad se crea por primera vez.
     * Se encarga de inicializar la interfaz de usuario, configurar la animación de fondo
     * y establecer la lógica de autenticación para el botón de "Entrar".
     *
     * @param savedInstanceState Si la actividad se está reinicializando después de haber sido cerrada,
     *                           este Bundle contiene los datos que suministró más recientemente en onSaveInstanceState.
     *                           De lo contrario, es nulo.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establece el layout de la interfaz de usuario desde res/layout/activity_login.xml
        setContentView(R.layout.activity_login);

        // --- CÓDIGO PARA LA ANIMACIÓN DEL FONDO ---
        // Obtiene la referencia al layout principal para aplicar la animación.
        LinearLayout loginLayout = findViewById(R.id.login_layout);
        // Obtiene el fondo del layout, que debe ser un AnimationDrawable definido en XML.
        AnimationDrawable animationDrawable = (AnimationDrawable) loginLayout.getBackground();
        // Configura la duración del fundido al entrar y salir de cada frame de la animación.
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        // Inicia la animación del fondo.
        animationDrawable.start();

        // --- VINCULACIÓN DE VISTAS ---
        // Obtiene las referencias a los componentes de la interfaz de usuario.
        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etContrasena = findViewById(R.id.etContrasena);
        Button btnEntrar = findViewById(R.id.btnEntrar);

        // --- LÓGICA DE AUTENTICACIÓN ---
        // Configura el listener para el evento de clic en el botón de "Entrar".
        btnEntrar.setOnClickListener(v -> {
            // Obtiene el texto ingresado por el usuario en los campos de texto.
            String usuario = etUsuario.getText().toString();
            String contrasena = etContrasena.getText().toString();

            // Valida las credenciales. Actualmente están "hardcodeadas" (fijas en el código).
            if (usuario.equals("admin") && contrasena.equals("1234")) {
                // Si la validación es exitosa, crea un Intent para navegar a MainActivity.
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent); // Inicia la siguiente actividad.
                finish(); // Cierra LoginActivity para que el usuario no pueda volver a ella con el botón de retroceso.
            } else {
                // Si la validación falla, muestra un mensaje de error al usuario.
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

