package com.example.idiomasvideos.pantallas

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.idiomasvideos.logica.Helper.Barras.AppScaffold
import com.example.idiomasvideos.logica.Logica_pantallas.BodyTextoPruebaScreen
import com.example.idiomasvideos.logica.Logica_pantallas.fondoBodyPrueba
import com.example.idiomasvideos.logica.Logica_pantallas.imagenBodyPrueba
import com.example.idiomasvideos.logica.Logica_pantallas.textoBodyPrueba
import com.example.idiomasvideos.logica.Logica_pantallas.tituloBodyPrueba

//El parametro content es el que define que va a ir entre el top y bottom bar
@Composable
fun MostrarTextoPruebaScreen(
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit = {},
    navController: NavHostController,) {
    AppScaffold(
        navController = navController,
        content = { padding ->
            BodyTextoPruebaScreen(
                modifier = modifier
                    .padding(padding)
                    .fillMaxSize(),

                fondoBodyPrueba = { fondoBodyPrueba() },
                tituloBodyPrueba = { tituloBodyPrueba() },
                textoBodyPrueba = { textoBodyPrueba() },
                imagenBodyPrueba = { imagenBodyPrueba() }
            )
            content(padding)
        }
    )
}

