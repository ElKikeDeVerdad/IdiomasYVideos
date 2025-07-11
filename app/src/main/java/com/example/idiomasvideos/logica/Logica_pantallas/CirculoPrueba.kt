package com.example.idiomasvideos.logica.Logica_pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.request.ImageRequest
import com.example.idiomasvideos.R


@Composable
fun CirculoPrueba(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center // Centra el círculo dentro del contenedor
    ) {
        Box(
            modifier = Modifier
                .size(200.dp) // Asegura forma circular; puedes ajustar esto
                .clip(CircleShape)
                .background(Color.Blue),
            contentAlignment = Alignment.Center // Centra el contenido dentro del círculo
        ) {
            ContenidoCirculo()
        }
    }
}


@Composable
fun ContenidoCirculo() {
    Column(
        modifier = Modifier
            .clipToBounds()
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

        ) {
        Text(
            text = stringResource(R.string.textCirculo),
            color = Color.White
        )
        Spacer(modifier = Modifier
            .height(10.dp))

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(R.drawable.vacabailando)
                .decoderFactory(GifDecoder.Factory())
                .build(),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )

    }
}


