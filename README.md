Proyecto de Ejemplo con Jetpack Compose
Descripción del Proyecto
Este proyecto es una aplicación Android desarrollada con Kotlin y Jetpack Compose que integra diversas funcionalidades y componentes.
Estructura del Proyecto
El proyecto está organizado en varios archivos que implementan diferentes funcionalidades:

MainActivity.kt: Punto de entrada principal que configura la navegación entre pantallas.
Screen1.kt: Pantalla que muestra el contador.
MoviesScreen.kt: Pantalla que muestra una lista de películas populares.
MoviesViewModel.kt: ViewModel para gestionar los datos de películas.
MovieApiService.kt: Interfaz de servicio para la API de películas.
Movie.kt: Clases de datos para las películas.
TallerGraficaScreen.kt: Pantalla que muestra una gráfica usando una biblioteca externa.
CustomBarChartScreen.kt: Pantalla que implementa una gráfica personalizada sin biblioteca externa.
ContadorViewModel.kt: ViewModel para gestionar el estado del contador.

Objetivos Conseguidos
1. Definición de Componentes y Gestión de Estados

✅ Se ha implementado un sistema de contador con ContadorViewModel que gestiona el estado del contador.
✅ Se han creado componentes reutilizables como MovieItem para mostrar información de películas.

2. Navegación entre Pantallas

✅ Se ha implementado un sistema de navegación usando NavHost y NavController.
✅ Se han definido varias rutas de navegación entre las diferentes pantallas de la aplicación.

3. Uso de Retrofit con LazyColumn

✅ Se ha integrado Retrofit para consumir datos de la API de The Movie Database.
✅ Se utiliza LazyColumn para mostrar de manera eficiente la lista de películas.

4. Uso de Biblioteca Externa para Gráficas

✅ Se ha implementado una pantalla que utiliza la biblioteca tehras.charts para mostrar gráficas de barras.

5. Creación de un Componente de Gráficas sin Biblioteca Externa

✅ Se ha desarrollado un componente personalizado (CustomBarChart) que utiliza Canvas para dibujar gráficas de barras sin depender de bibliotecas externas.

Objetivos No Conseguidos
6. Comunicación con un Servidor mediante WebSockets

❌ No se ha implementado la comunicación mediante WebSockets. 

7. Uso de VerticalPager o Similar

❌ No se ha implementado VerticalPager o algun tipo de componente similar en el proyecto.

Resumen de Características

Sistema de Contador: Implementación simple de un contador con estado persistente.
Explorador de Películas: Visualización de películas populares con datos obtenidos de la API TMDB .
Gráficas de Datos: Implementación de gráficas tanto con biblioteca externa como con componente personalizado.
Navegación: Sistema de navegación entre diferentes pantallas de la aplicación.

Tecnologías Utilizadas

Kotlin
Jetpack Compose
Retrofit para comunicación con API
Coil para carga de imágenes
Biblioteca tehras.charts para gráficas
Canvas para gráficas personalizadas
ViewModel para gestión de estados
