package com.example.idiomasvideos.logica.Logica_pantallas


import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.request.ImageRequest
import com.example.idiomasvideos.R
import com.example.idiomasvideos.navegacion.Rutas
import java.nio.file.WatchEvent

@Composable
fun CirculoPruebaGrandeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    // Estado para controlar la posición X del círculo.
   // var targetOffsetX by remember { mutableStateOf(-400.dp) }

    // Estado animado que sigue a targetOffsetX.
   // val animatedOffsetX by animateOffsetAsState(

    /*targetValue = Offset(
        x = targetOffsetX.value.toFloat(),
        y = 0f
    ), // targetValue es un Offset. Solo nos importa la X, pero si sale algun erorr en el Offset, probablemente sea porque hay que poner toFloat y un valor en y.
    animationSpec =
        tween<Offset>(durationMillis = 1000),// Duración de la animación en milisegundos (1 segundo)
    )

    // Un LaunchedEffect activa la animación tan pronto como la pantalla se componga.
    LaunchedEffect(Unit) {
        targetOffsetX = 0.dp // Mueve el círculo a la posición central (0 dp de offset)*/
    //}
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center // Centra el círculo dentro del contenedor
    ) {
        Box(
            modifier = Modifier
                .size(800.dp) // Asegura forma circular; puedes ajustar esto
                .clip(CircleShape)
               /* .offset(
                    x = animatedOffsetX.x.dp,
                    y = animatedOffsetX.y.dp
                ) *///Sin esto no ocurrira la animacion ya que esto indica que debe usar la ubicacion animada en vez de una fija.
                .background(Color.Green)
                .clickable(onClick = { navController.navigate(Rutas.CIRCULOPRUEBASCREEN) }),

            contentAlignment = Alignment.Center // Centra el contenido dentro del círculo
        ) {
            ContenidoCirculoGrande()
        }
    }
}


@Composable
fun ContenidoCirculoGrande() {

    Column(
        modifier = Modifier
            .clipToBounds()
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = stringResource(R.string.textCirculo),
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(R.drawable.vacabailando)
                .decoderFactory(GifDecoder.Factory())
                .build(),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth(0.8f)
        )
    }
}
