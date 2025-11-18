package com.example.myapprecetas;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

/**
 * RecetasActivity muestra una lista de recetas filtradas por una categoría específica.
 * <p>
 * Esta actividad recibe una categoría como un String a través de un Intent desde
 * {@link MenuActivity}. Luego, consulta el {@link RepositorioRecetas} para obtener
 * la lista de recetas correspondientes a esa categoría y las muestra en una serie
 * de botones que se hacen visibles dinámicamente.
 * </p>
 * <p>
 * La implementación actual utiliza tres botones fijos y puede mostrar un máximo de
 * tres recetas. Una futura mejora sería reemplazar este sistema por un RecyclerView
 * para manejar un número variable de recetas de forma más eficiente.
 * </p>
 *
 * @version 1.0
 * @since 2025-11-17
 * @author [Jhonatan Castro]
 */
public class RecetasActivity extends AppCompatActivity {

    /**
     * Lista que almacena las recetas filtradas por categoría, obtenidas del repositorio.
     */
    private List<Receta> recetasMostradas;

    /**
     * Se llama cuando la actividad es creada.
     * <p>
     * Este método se encarga de:
     * 1. Inicializar la interfaz y la animación de fondo.
     * 2. Recibir la categoría del Intent.
     * 3. Obtener las recetas filtradas del {@link RepositorioRecetas}.
     * 4. Configurar dinámicamente la visibilidad y el texto de los botones de receta.
     * 5. Asignar los listeners para la navegación.
     * </p>
     *
     * @param savedInstanceState Si la actividad se está reinicializando, este Bundle
     *                           contiene datos previos. De lo contrario, es nulo.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establece el layout desde res/layout/activity_recetas.xml
        setContentView(R.layout.activity_recetas);

        // --- CÓDIGO PARA LA ANIMACIÓN DEL FONDO ---
        LinearLayout recetasLayout = findViewById(R.id.recetas_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) recetasLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        // --- VINCULACIÓN DE VISTAS ---
        TextView tvCategoria = findViewById(R.id.tvCategoria);
        Button btnReceta1 = findViewById(R.id.btnReceta1);
        Button btnReceta2 = findViewById(R.id.btnReceta2);
        Button btnReceta3 = findViewById(R.id.btnReceta3);
        Button btnVolver = findViewById(R.id.btnVolver);

        // --- RECEPCIÓN Y FILTRADO DE DATOS ---
        // Recupera la categoría pasada desde MenuActivity.
        String categoria = getIntent().getStringExtra("categoria");
        if (categoria != null) {
            // Actualiza el título de la pantalla para reflejar la categoría actual.
            tvCategoria.setText("Recetas de " + categoria);
        }
        // Obtiene la lista de recetas filtradas consultando el repositorio.
        recetasMostradas = RepositorioRecetas.getRecetasPorCategoria(categoria);

        // --- LÓGICA DE VISIBILIDAD DINÁMICA DE BOTONES ---
        // Oculta todos los botones al inicio para asegurar un estado limpio.
        btnReceta1.setVisibility(View.GONE);
        btnReceta2.setVisibility(View.GONE);
        btnReceta3.setVisibility(View.GONE);

        // Comprueba cuántas recetas se encontraron y configura un botón para cada una.
        // Asigna el nombre de la receta, hace visible el botón y le añade un OnClickListener.

        if (recetasMostradas.size() > 0) {
            btnReceta1.setText(recetasMostradas.get(0).getNombre());
            btnReceta1.setVisibility(View.VISIBLE);
            btnReceta1.setOnClickListener(v -> abrirDetalle(recetasMostradas.get(0)));
        }
        if (recetasMostradas.size() > 1) {
            btnReceta2.setText(recetasMostradas.get(1).getNombre());
            btnReceta2.setVisibility(View.VISIBLE);
            btnReceta2.setOnClickListener(v -> abrirDetalle(recetasMostradas.get(1)));
        }
        if (recetasMostradas.size() > 2) {
            btnReceta3.setText(recetasMostradas.get(2).getNombre());
            btnReceta3.setVisibility(View.VISIBLE);
            btnReceta3.setOnClickListener(v -> abrirDetalle(recetasMostradas.get(2)));
        }

        // Configura el botón "Volver" para que cierre la actividad actual.
        btnVolver.setOnClickListener(v -> finish());
    }

    /**
     * Método auxiliar para navegar a la pantalla de detalle de una receta.
     * <p>
     * Encapsula la lógica para crear un Intent, añadir el objeto {@link Receta}
     * seleccionado como un dato extra (debe ser Parcelable), e iniciar
     * {@link DetalleRecetaActivity}.
     * </p>
     *
     * @param receta El objeto Receta que el usuario ha seleccionado y cuyos detalles
     *               se quieren mostrar.
     */
    private void abrirDetalle(Receta receta) {
        Intent intent = new Intent(RecetasActivity.this, DetalleRecetaActivity.class);
        // Empaqueta el objeto Receta completo para pasarlo a la siguiente actividad.
        intent.putExtra("receta_seleccionada", receta);
        startActivity(intent);
    }
}



