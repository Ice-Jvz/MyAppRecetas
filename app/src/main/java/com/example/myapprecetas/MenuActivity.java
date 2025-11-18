package com.example.myapprecetas;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * MenuActivity actúa como el menú principal de categorías de la aplicación.
 * <p>
 * Presenta al usuario una serie de botones, cada uno correspondiente a una categoría
 * de recetas (ej. "Desayuno", "Almuerzo"). Al seleccionar una categoría, esta actividad
 * inicia {@link RecetasActivity}, pasándole la categoría seleccionada para que
 * muestre las recetas correspondientes.
 * </p>
 *
 * @version 1.0
 * @since 2025-11-17
 * @author [Jhonatan Castro]
 */
public class MenuActivity extends AppCompatActivity {

    /**
     * Se llama cuando la actividad es creada.
     * <p>
     * Este método inicializa la interfaz de usuario, configura la animación de fondo
     * y asigna los listeners a los botones de categoría para manejar la navegación.
     * </p>
     *
     * @param savedInstanceState Si la actividad se está reinicializando, este Bundle
     *                           contiene datos previos. De lo contrario, es nulo.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establece el layout de la interfaz de usuario desde res/layout/activity_menu.xml
        setContentView(R.layout.activity_menu);

        // --- CÓDIGO PARA LA ANIMACIÓN DEL FONDO ---
        // Obtiene la referencia al layout principal para aplicar la animación.
        LinearLayout menuLayout = findViewById(R.id.menu_layout);
        // Obtiene el fondo del layout, que debe ser un AnimationDrawable.
        AnimationDrawable animationDrawable = (AnimationDrawable) menuLayout.getBackground();
        // Configura la duración del fundido al entrar y salir de cada frame.
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        // Inicia la animación.
        animationDrawable.start();

        // --- VINCULACIÓN DE VISTAS ---
        ImageView ivMenu = findViewById(R.id.ivMenu);
        Button btnDesayuno = findViewById(R.id.btnDesayuno);
        Button btnAlmuerzo = findViewById(R.id.btnAlmuerzo);
        Button btnSnack = findViewById(R.id.btnSnack);
        Button btnCena = findViewById(R.id.btnCena);

        // Asigna una imagen decorativa al ImageView del menú.
        ivMenu.setImageResource(R.drawable.otter_chef);

        // --- LÓGICA DE NAVEGACIÓN ---
        // Configura los listeners para cada botón de categoría.
        // Cada botón llama al método auxiliar abrirRecetas() con la categoría correspondiente.
        btnDesayuno.setOnClickListener(v -> abrirRecetas("Desayuno"));
        btnAlmuerzo.setOnClickListener(v -> abrirRecetas("Almuerzo"));
        btnSnack.setOnClickListener(v -> abrirRecetas("Snack"));
        btnCena.setOnClickListener(v -> abrirRecetas("Cena"));
    }

    /**
     * Método auxiliar para navegar a la pantalla de lista de recetas.
     * <p>
     * Encapsula la lógica para crear un Intent, añadir la categoría seleccionada
     * como un dato extra, e iniciar {@link RecetasActivity}.
     * </p>
     *
     * @param categoria La categoría de recetas que el usuario ha seleccionado (ej. "Desayuno").
     *                  Este string se pasará a la siguiente actividad.
     */
    private void abrirRecetas(String categoria) {
        // Crea un Intent para navegar desde esta actividad hacia RecetasActivity.
        Intent intent = new Intent(MenuActivity.this, RecetasActivity.class);
        // Añade la categoría seleccionada como un dato extra en el Intent.
        // La clave "categoria" se usará en RecetasActivity para recuperar este valor.
        intent.putExtra("categoria", categoria);
        // Inicia la nueva actividad.
        startActivity(intent);
    }
}

