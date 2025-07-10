package com.example.idiomasvideos.logica.Helper.BoxScreenFunciones.BoxUnoAccion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.idiomasvideos.logica.Helper.BoxScreenFunciones.BoxUno
import com.example.idiomasvideos.R




@Composable
fun AccionBoxUno(encendido: Boolean) {
    if (encendido) {
        BoxUno(
            modifier = Modifier
                .background(Color.Magenta)
                .size(100.dp)
        )
    } else {
        Image(
            painter = painterResource(R.drawable.error2),
            contentDescription = "Error Fatal del Sistema",
            modifier = Modifier
                .size(100.dp)


        )
    }
}