package com.example.idiomasvideos.pantallas

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.idiomasvideos.logica.AppScaffold
import com.example.idiomasvideos.logica.ConfiguracionScreen
import com.example.idiomasvideos.logica.tituloConfigurationScreen

@Composable
fun MostrarConfiguracionScreen (
    modifier: Modifier,
    content: @Composable (PaddingValues) -> Unit = {},
) {
    AppScaffold(
        content = { padding ->
            ConfiguracionScreen(
                modifier = Modifier
                    .fillMaxSize(),
              tituloConfigurationScreen= {tituloConfigurationScreen()},

            )
            content(padding)
        }
    )
}
