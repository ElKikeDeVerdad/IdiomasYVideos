package com.example.idiomasvideos.logica.Logica_pantallas


import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.idiomasvideos.ViewModel.BoxUnoViewModel
import com.example.idiomasvideos.logica.Helper.Botones.BoxScreenBotones.BotonSwitchBoxUno
import com.example.idiomasvideos.logica.Helper.BoxScreenFunciones.BoxUno
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.getValue
import com.example.idiomasvideos.logica.Helper.BoxScreenFunciones.BoxUnoAccion.AccionBoxUno


@Composable
fun BoxScreen(
    modifier: Modifier = Modifier,
    boxUnoViewModel: BoxUnoViewModel
) {
    val encendido by boxUnoViewModel.encendido
    val offsetX by animateDpAsState(
        targetValue = if (encendido) 1000.dp else 0.dp,
        animationSpec = tween(
            durationMillis = 1000,  // velocidad de la animación
            easing = FastOutSlowInEasing // Cambiar el estilo de aceleración
        )
    )

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(x = offsetX)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    BoxUno(
                        modifier = Modifier
                            .fillMaxSize()
                    )


                    BotonSwitchBoxUno(
                        encendido = encendido,
                        onSwitchChanged = { nuevoEstado ->
                            boxUnoViewModel.cambiarEstado()
                        })


                    AccionBoxUno(encendido = encendido)


                }

            }
        }
    }
}







