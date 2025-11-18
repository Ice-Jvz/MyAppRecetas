// Archivo: RepositorioRecetas.java
package com.example.myapprecetas;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidad que actúa como el repositorio de datos de recetas para la aplicación.
 * <p>
 * Su responsabilidad es crear, almacenar y proporcionar acceso a la lista de todas
 * las recetas disponibles. Al usar métodos estáticos, funciona como una fuente de datos
 * única y centralizada (patrón Singleton simple) sin necesidad de instanciar la clase.
 * </p>
 * <p>
 * Actualmente, los datos de las recetas están "hardcodeados" (escritos directamente
 * en el código), lo cual es adecuado para una lista fija de recetas.
 * </p>
 *
 * @version 1.0
 * @since 2025-11-17
 * @author [Jhonatan Castro]
 */
public class RepositorioRecetas {

    /**
     * Construye y devuelve una lista completa con todas las recetas disponibles en la aplicación.
     * <p>
     * Este método es la fuente principal de datos. Cada vez que se llama, crea una nueva
     * lista y la puebla con todos los objetos {@link Receta} predefinidos.
     * </p>
     *
     * @return Una {@code List<Receta>} que contiene todas las recetas.
     */
    public static List<Receta> getRecetas() {
        List<Receta> recetas = new ArrayList<>();

        // --- DESAYUNOS ---
        recetas.add(new Receta(
                "Tostadas con Aguacate",
                "• 2 rebanadas de pan\n• 1 aguacate maduro\n• Sal y pimienta al gusto",
                "1. Tuesta el pan.\n2. Machaca el aguacate y úntalo sobre las tostadas.\n3. Sazona con sal y pimienta.",
                R.drawable.tostadas,
                "Desayuno"
        ));

        recetas.add(new Receta(
                "Omelette de Jamón y Queso",
                "• 2 huevos\n• 2 lonchas de jamón\n• 30g de queso rallado\n• Sal y aceite",
                "1. Bate los huevos con sal.\n2. Vierte en una sartén caliente con aceite.\n3. Antes de que cuaje, añade el jamón y el queso.\n4. Dobla y sirve.",
                R.drawable.omelette_jamon_queso,
                "Desayuno"
        ));

        // --- ALMUERZOS ---
        recetas.add(new Receta(
                "Ensalada César con Pollo",
                "• 1 pechuga de pollo\n• Lechuga romana\n• Pan tostado (croutons)\n• Queso parmesano\n• Aderezo César",
                "1. Cocina el pollo a la plancha y córtalo en tiras.\n2. Mezcla la lechuga con el aderezo.\n3. Añade el pollo, los croutons y el queso parmesano.",
                R.drawable.ensalada_cesar,
                "Almuerzo"
        ));

        // --- SNACKS ---
        recetas.add(new Receta(
                "Brochetas de Fruta",
                "• Fresas\n• Uvas\n• Trozos de melón\n• Trozos de piña\n• Palitos de brocheta",
                "1. Lava y corta la fruta en trozos de tamaño similar.\n2. Inserta la fruta en los palitos de brocheta, alternando colores y sabores.\n3. Refrigera hasta el momento de servir.",
                R.drawable.brochetas_fruta,
                "Snack"
        ));

        recetas.add(new Receta(
                "Yogur con Granola y Miel",
                "• 1 taza de yogur natural o griego\n• 1/2 taza de granola\n• 1 cucharada de miel",
                "1. Vierte el yogur en un bol o vaso.\n2. Cubre con la granola de tu preferencia.\n3. Rocía con miel justo antes de comer.",
                R.drawable.yogurt_granola,
                "Snack"
        ));

        recetas.add(new Receta(
                "tostada",
                "• 2 rodajas de pan\n• Mermelada de fresa",
                "1. Tuesta el pan .\n2. Vierte la mermelada en el pan.\n3. acomapañar con un vaso de Leche.",
                R.drawable.tostada,
                "Cena"

        ));

        // Devuelve la lista completa de recetas.
        return recetas;
    }

    /**
     * Filtra la lista completa de recetas y devuelve solo aquellas que pertenecen a una categoría específica.
     * <p>
     * Este método es utilizado por {@link RecetasActivity} para mostrar al usuario
     * únicamente las recetas que ha solicitado ver. La comparación de categorías
     * no distingue entre mayúsculas y minúsculas.
     * </p>
     *
     * @param categoria El nombre de la categoría por la cual filtrar (ej. "Desayuno", "Almuerzo").
     * @return Una nueva {@code List<Receta>} que contiene solo las recetas de la categoría especificada.
     *         Si no se encuentra ninguna receta para esa categoría, devuelve una lista vacía.
     */
    public static List<Receta> getRecetasPorCategoria(String categoria) {
        List<Receta> recetasFiltradas = new ArrayList<>();
        List<Receta> todasLasRecetas = getRecetas(); // Obtiene la lista completa de recetas.

        // Itera sobre cada receta para comprobar si su categoría coincide.
        for (Receta receta : todasLasRecetas) {
            if (receta.getCategoria().equalsIgnoreCase(categoria)) {
                recetasFiltradas.add(receta); // Añade la receta a la lista filtrada si coincide.
            }
        }
        return recetasFiltradas; // Devuelve la lista de recetas que coinciden.
    }
}



