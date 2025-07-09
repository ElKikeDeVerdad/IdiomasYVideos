package com.example.idiomasvideos.logica.Helper.Botones.BoxScreenBotones


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.idiomasvideos.logica.Helper.Botones.BotonSwitch


@Composable
fun BotonSwitchBoxUno(
    encendido: Boolean,
    onSwitchChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    // Convertimos el Boolean a MutableState para pasarlo a BotonSwitch
    val encendidoState = remember { mutableStateOf(encendido) }

    // Para sincronizar cambios externos y locales
    LaunchedEffect(encendido) {
        if (encendidoState.value != encendido) {
            encendidoState.value = encendido
        }
    }

    BotonSwitch(
        encendido = encendidoState,
        cambiarSwiche = { nuevoEstado ->
            encendidoState.value = nuevoEstado
            onSwitchChanged(nuevoEstado)
        }
    )
}



