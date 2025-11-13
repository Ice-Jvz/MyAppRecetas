// Archivo: RepositorioRecetas.java
package com.example.myapprecetas;

import java.util.ArrayList;
import java.util.List;

public class RepositorioRecetas {

    // --- SOLUCIÓN: Separar el comentario del método ---
    // Método que devuelve TODAS las recetas que tienes
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

        return recetas;
    }

    // El resto de tu archivo no necesita cambios, funcionará automáticamente.
    public static List<Receta> getRecetasPorCategoria(String categoria) {
        List<Receta> recetasFiltradas = new ArrayList<>();
        List<Receta> todasLasRecetas = getRecetas();
        for (Receta receta : todasLasRecetas) {
            if (receta.getCategoria().equalsIgnoreCase(categoria)) {
                recetasFiltradas.add(receta);
            }
        }
        return recetasFiltradas;
    }
}


