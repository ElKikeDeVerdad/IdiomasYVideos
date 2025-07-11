package com.example.idiomasvideos.logica.Logica_pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.request.ImageRequest
import com.example.idiomasvideos.R
import android.os.Build
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import coil.decode.ImageDecoderDecoder


@Composable
//estos parametros son de ejemplo, en realidad como los valores no cambian en la funcion a la que se llama, no seria necesario ponerlos
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

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(modifier) //aplica el padding(padding) definido en el modifier despues del fillMaxSize
                .verticalScroll(scrollState),

            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            tituloBodyPrueba()
            Spacer(modifier = Modifier.height(30.dp))

            textoBodyPrueba()
            Spacer(modifier = Modifier.height(15.dp))

            imagenBodyPrueba()

            Spacer(modifier = Modifier.height(15.dp))


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            ImagenPruebaGif(
                modifier = Modifier
                    .fillMaxSize()
            )
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

@Composable
fun ImagenPruebaGif(
    modifier: Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(R.drawable.gif_pato)
            .decoderFactory(GifDecoder.Factory())
            .build(),
        contentDescription = "",
        contentScale = ContentScale.FillWidth, // Importante porque hara que las imagenes ocupen el espacio segun el aspecto que pusimos antes, este caso 2:1
        alignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()

    )
}