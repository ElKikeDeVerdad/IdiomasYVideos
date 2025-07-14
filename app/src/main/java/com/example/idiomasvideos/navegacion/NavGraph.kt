package com.example.idiomasvideos.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.idiomasvideos.logica.Helper.TransicionesPantallas.TransicionZoom
import com.example.idiomasvideos.pantallas.MostrarBoxScreen
import com.example.idiomasvideos.pantallas.MostrarCirculoGrandeScreen
import com.example.idiomasvideos.pantallas.MostrarCirculoPrueba
import com.example.idiomasvideos.pantallas.MostrarConfiguracionScreen
import com.example.idiomasvideos.pantallas.MostrarHomeScreen
import com.example.idiomasvideos.pantallas.MostrarParallaxScreen
import com.example.idiomasvideos.pantallas.MostrarTextoPruebaScreen

@Composable
fun AppNavGraph(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String = Rutas.HOME
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Rutas.TEXTOPRUEBASCREEN) {
            MostrarTextoPruebaScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(Rutas.CONFIGURACION) {
            MostrarConfiguracionScreen(
                navController = navController,
                modifier = modifier,
            )
        }

        composable(Rutas.HOME) {
            MostrarHomeScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(Rutas.BOXSCREEN) {
            MostrarBoxScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(Rutas.PARALLAXSCREEN) {
            MostrarParallaxScreen(
                navController = navController,
                modifier = modifier
            )
        }
        //Poner las transiciones de TransicionZoom
        composable(
            route = Rutas.CIRCULOPRUEBASCREEN,
            enterTransition = TransicionZoom.fadeInTransicion,
            exitTransition = TransicionZoom.fadeOutTransicion,
            popEnterTransition = TransicionZoom.fadeInTransicion,
            popExitTransition = TransicionZoom.fadeOutTransicion
        ) {
            MostrarCirculoPrueba(
                navController = navController,
                modifier = modifier
            )
        }

        composable(
            route = Rutas.CIRCULOPRUEBAGRANDESCREEN,
            enterTransition = TransicionZoom.zoomInTransicion,
            exitTransition = TransicionZoom.zoomOutTransicion,
            popEnterTransition = TransicionZoom.zoomInTransicion,
            popExitTransition = TransicionZoom.zoomOutTransicion
        ) {
            MostrarCirculoGrandeScreen(
                navController = navController,
                modifier = modifier
            )
        }

    }
}



