//Archivo: MainActivity.java

package com.example.myapprecetas;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

/**
 * MainActivity es la pantalla de inicio de la aplicación "MyAppRecetas".
 * Sirve como punto de entrada y presenta al usuario la opción de navegar
 * hacia el menú principal de la aplicación.
 *
 * @author [Jhonatan Castro]
 * @version 1.0
 * @since [Fecha de Creación, ej. 2023-10-27]
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Este método se llama cuando la actividad es creada por primera vez.
     * Aquí se inicializa la interfaz de usuario, se configura la animación
     * de fondo y se establece el listener para el botón de navegación.
     *
     * @param savedInstanceState Si la actividad se está re-inicializando después
     *                           de haber sido cerrada previamente, este Bundle contiene
     *                           los datos que suministró más recientemente en onSaveInstanceState.
     *                           De lo contrario, es nulo.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establece el layout de la interfaz de usuario definido en R.layout.activity_main
        setContentView(R.layout.activity_main);

        // --- CÓDIGO PARA LA ANIMACIÓN DEL FONDO ---
        // Obtiene la referencia al layout principal para aplicar la animación.
        LinearLayout mainLayout = findViewById(R.id.main_layout);
        // Obtiene el fondo del layout, que debe ser un AnimationDrawable definido en XML.
        AnimationDrawable animationDrawable = (AnimationDrawable) mainLayout.getBackground();
        // Configura la duración del fade al entrar y salir de cada frame de la animación.
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        // Inicia la animación del fondo.
        animationDrawable.start();

        // --- CÓDIGO PARA LA NAVEGACIÓN ---
        // Obtiene la referencia del botón para ir al menú.
        Button btnMenu = findViewById(R.id.btnMenu);

        // Configura un listener para el evento de clic en el botón.
        btnMenu.setOnClickListener(v -> {
            // Crea un Intent para navegar desde MainActivity hacia MenuActivity.
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            // Inicia la nueva actividad.
            startActivity(intent);
        });
    }
}

