package com.example.idiomasvideos.logica.Helper.Botones

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BotonSwitch(
   encendido: MutableState<Boolean>,
   cambiarSwiche: (Boolean) -> Unit,
){
    var transicion = updateTransition(targetState = encendido.value)

    var backgroundColor = transicion.animateColor { state ->
        if(state) Color(0xFF2196F3) else Color.LightGray } //Cambia colores, el State es encendido que es azul, si cambia se pone gris

    val circulo = transicion.animateDp { state ->
        if(state)24.dp else 0.dp } // Cambia lugar, si State es encendido, esta a 24.dp, si esta apagado, esta a 0.dp

//Este es el icono del boton
    Box( //Esta caja crea lo que esta alrededor del circulo
        modifier = Modifier
            .width(50.dp)
            .height(28.dp)
            .clip(RoundedCornerShape(50.dp)) //clip hace que nada lo que este fuera de la figura se muestre, figura es RoundedCornerShape tiene 50.dp de tamaño.
            .background(backgroundColor.value) // color de fondo es el valor de la variable de transicion backgroundColor
            .clickable {cambiarSwiche(!encendido.value)} //Clickable permite la accion de hacer click, el !encendido, hace que la funcion booleana haga lo contrario a lo que se quiere, es decir, si esta encedido queremos que se apague, la accion es apagar, contrario a encender, por lo que tiene que ser distinto a encender !encender
            .padding(horizontal = 2.dp, vertical = 2.dp), //evita que el circulo
        contentAlignment = Alignment.CenterStart
    ) {
        Box(//esta caja crea el circulo y hace que se mueva
            modifier = Modifier
                .offset(x= circulo.value) //utilizamos el valor de la variable circulo para crear la animacion de movimiento
                .size(24.dp) //se define el tamaño antes de crear el circulo para que se sepa que tamaño tendra
                .background(Color.White, CircleShape)// se crea un background circular de color blanco
        )
    }
}

@Composable
fun UsarBotonSwitch(){

    var encendido = remember { mutableStateOf(false) }

    BotonSwitch(encendido = encendido, cambiarSwiche={ encendido.value = it})
}