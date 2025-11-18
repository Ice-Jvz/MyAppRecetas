## Estructura del Proyecto

com.example.myapprecetas
│
├── LoginActivity.java
├── MenuActivity.java
├── RecetasActivity.java
├── DetalleRecetaActivity.java
├── Receta.java
├── RepositorioRecetas.java
├── res/
│ ├── layout/
│ │ ├── activity_login.xml
│ │ ├── activity_menu.xml
│ │ ├── activity_recetas.xml
│ │ └── activity_detallereceta.xml
│ ├── drawable/
│ │ └── imágenes de recetas y animaciones
└── AndroidManifest.xml
undefined


# MyAppRecetas

Aplicación Android para consultar recetas rápidas y sencillas por categoría (Desayuno, Almuerzo, Snack, Cena).

## Características

- Autenticación básica de usuario
- Menú por categorías
- Visualización rápida de recetas
- Detalle completo de cada receta (ingredientes, pasos, imagen)
- Navegación sencilla e intuitiva

## Instalación

1. Clona el repositorio: git clone https://github.com/Ice-Jvz/MyAppRecetas.git
2. Abre el proyecto en Android Studio.
3. Conecta un emulador o dispositivo físico.
4. Ejecuta el proyecto.

## Uso

- Login: usuario `admin`, contraseña `1234`.
- Selecciona una categoría para ver recetas disponibles.
- Toca el nombre de una receta para ver los detalles.

## Estructura del Proyecto

- `LoginActivity.java`: Autenticación
- `MenuActivity.java`: Menú de categorías
- `RecetasActivity.java`: Listado de recetas filtradas
- `DetalleRecetaActivity.java`: Detalle de cada receta
- `RepositorioRecetas.java`: Datos en memoria

## Tecnologías usadas

- Java (Android)
- XML para interfaces gráficas
- AnimationDrawable para animación de fondos

## Mejoras Sugeridas

- Persistencia con base de datos
- Usuarios y recetas dinámicas
- Interfaz más moderna (`RecyclerView`)

## Autor

Jhonatan Castro  
[jcastro21@udi.edu.co]
