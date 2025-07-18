package com.example.idiomasvideos.logica.Helper.Parallax

import android.content.res.Resources
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.idiomasvideos.R
import coil.decode.GifDecoder
import com.example.idiomasvideos.logica.Helper.Imagenes.PruebaLottie


@Composable
fun ParallaxTextoCentro() {
    val lazyListState = rememberLazyListState()
    var textoOffset by remember { mutableStateOf(0f) }
    var cajaAzulOffsetX by remember { mutableStateOf(200f) } // empieza fuera de pantalla izquierda
    var cajaRojaOffsetX by remember { mutableStateOf(400f) }  // empieza fuera de pantalla derecha

    val nestedScrollConnection = object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            val delta = available.y

            textoOffset = (textoOffset - delta * 1.5f).coerceIn(-400f, 400f)

            // Movimiento horizontal opuesto
            cajaAzulOffsetX = (cajaAzulOffsetX + delta * 0.2f).coerceIn(-500f, 0f)
            cajaRojaOffsetX = (cajaRojaOffsetX - delta * 1f).coerceIn(0f, 800f)

            return Offset.Zero
        }
    }

    LazyColumn(
        state = lazyListState,
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
            .padding(top = 40.dp)
            .background(Color.LightGray)
    ) {

        items(5) {
            Text(
                text = "Item #$it",
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }

        item {
            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color.DarkGray)
            ) {
                // Texto centrado
                Text(
                    text = stringResource(R.string.TextoImatus),
                    fontSize = 20.sp,
                    color = Color.White,
                    lineHeight = 50.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .graphicsLayer {
                            translationY = -textoOffset
                        }
                )

                // Caja azul desde la izquierda
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterStart)
                        .graphicsLayer {
                            translationX = cajaAzulOffsetX
                        }
                        .background(Color.Blue, CircleShape)
                )

                // Caja roja desde la derecha
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterEnd)
                        .graphicsLayer {
                            translationX = cajaRojaOffsetX
                        }
                        .background(Color.Red, CircleShape)
                )
            }
        }

        // Contenido para scroll
        items(3) {
            Text(
                text = "Item #$it",
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }


        item {
            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color.DarkGray)
            ) {
                // Texto centrado
                Text(
                    text = stringResource(R.string.TextoImatus),
                    fontSize = 20.sp,
                    color = Color.White,
                    lineHeight = 50.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .graphicsLayer {
                            translationY = -textoOffset
                        }
                )

                // Caja azul desde la izquierda
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterStart)
                        .graphicsLayer {
                            translationX = cajaAzulOffsetX
                        }
                        .background(Color.Blue, CircleShape)
                )

                // Caja roja desde la derecha
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterEnd)
                        .graphicsLayer {
                            translationX = cajaRojaOffsetX
                        }
                        .background(Color.Red, CircleShape)
                )
            }
        }
        items(5) {
            Text(
                text = "Item #$it",
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}