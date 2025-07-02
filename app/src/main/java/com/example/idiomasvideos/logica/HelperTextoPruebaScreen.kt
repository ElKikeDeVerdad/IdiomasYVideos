package com.example.idiomasvideos.logica

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.idiomasvideos.R


@Composable
fun BodyTextoPruebaScreen(
    modifier: Modifier = Modifier,
    tituloBodyPrueba: @Composable () -> Unit = {},
    textoBodyPrueba: @Composable () -> Unit = {},
    imagenBodyPrueba: @Composable () -> Unit = {},
    fondoBodyPrueba: @Composable () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        fondoBodyPrueba()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(modifier), //aplica el padding(padding) definido en el modifier despues del fillMaxSize
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Spacer(modifier = Modifier.height(30.dp))

            tituloBodyPrueba()
            Spacer(modifier = Modifier.height(30.dp))

            textoBodyPrueba()
            Spacer(modifier = Modifier.height(15.dp))

            imagenBodyPrueba()

        }
    }
}

@Composable
fun tituloBodyPrueba() {
    Text(
        text = stringResource(R.string.tituloBody),
        fontSize = 40.sp,
        fontWeight = FontWeight.W400,
        color = Color.Gray
    )

}

@Composable
fun textoBodyPrueba() {
    Text(
        text = stringResource(R.string.bodyTexto),
        fontSize = 20.sp,
    )
}

@Composable
fun imagenBodyPrueba() {
    Image(
        painter = painterResource(R.drawable.mapamundi),
        contentDescription = "Mapa Mundial",
        modifier = Modifier
            .fillMaxSize(0.5f)
    )
}

@Composable
fun fondoBodyPrueba() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.fondo_1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop

        )
    }
}
