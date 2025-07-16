package com.example.idiomasvideos.logica.Helper.Parallax

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.idiomasvideos.R
import coil.decode.GifDecoder
import com.example.idiomasvideos.logica.Helper.Imagenes.PruebaLottie


@Composable
fun FuncionParallaxUno(
    modifier: Modifier = Modifier
) {
    val perritoFelizScrollSpeed = 2f

    val perritoTristeScrollSpeed = 0.5f

    val gifPatoScrollSpeed = 3f

    val gifLottieUnoSpeed = 0.1f


    val mapaMundiAltura =
        (LocalConfiguration.current.screenWidthDp * (1f)).dp //necesitas saber el aspect ratio para hacer esto bien, en mi caso esta imagen el aspect ratio es 2:1 investigar bien como hacer para que cubra el espacio

    val lazyListStateUno =
        rememberLazyListState() //Para recordar el sitio de este bloque de parllax, define que objetos se van a ver

    var perritoFelizOffset: Float by remember { mutableStateOf(0f) }

    var perritoTristeOffset by remember { mutableStateOf(0f) }

    var mapaMundiOffset by remember { mutableStateOf(0f) }

    var gifPatoOffset by remember { mutableStateOf(0f) }

    var giftLottieUnoOffset by remember { mutableStateOf(0f) }

    val scrollProgress =
        remember { mutableStateOf(0f) } //Aqui manejamos el la varibale de PruebaLottie

    val nestedScrollConnection = object : NestedScrollConnection {
        override fun onPreScroll( //antes de que la funcion del scroll sea procesado, ocurrira esta funcion
            available: Offset,
            source: NestedScrollSource
        ): Offset {
            val delta =
                available.y //saber cuantos pixeles scroleamos comparado con que tanto se mueve los dedos al scrolear
            //Checkea si el primer item es visible. esto es para evitar efectos raros de scroll cuando scroleas por encima y por debajo
            val layoutInfo = lazyListStateUno.layoutInfo
            if (lazyListStateUno.firstVisibleItemIndex == 0) {
                return Offset.Zero
            }
//Checkea si el ultimo item es visible
            if (layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1) {
                return Offset.Zero
            }

            perritoFelizOffset += delta * perritoFelizScrollSpeed
            perritoTristeOffset += delta * perritoTristeScrollSpeed
            gifPatoOffset += delta * gifPatoScrollSpeed
            giftLottieUnoOffset += delta * gifLottieUnoSpeed
            scrollProgress.value = (scrollProgress.value + delta / 500f).let { (it % 1f + 1f) % 1f } //Esto esta diciendo que, primero sumamos delta y si el resultado es negativo, sumamos 1, asegurando que siempre este entre 0 y 1 y no hayan negativos



            //scrollProgress.value = (scrollProgress.value + delta / 500f) % 1f // de esta manera se repite el ciclo de la animacion
            // pero en este caso, cuando bajamos el delta es negativo y hace que la operacion matematica de negativo y rompe la animacion

            //scrollProgress.value = (scrollProgress.value + delta / 500f).coerceIn(0f, 1f)  De esta forma solo se repite la animacion sin repetir el ciclo de la animacion

            //mientras sea mas pequeño el numero x en: delta / x, mas rapido sera el movimiento
            //Para que la animacion no se repita, no se pone el operador de 1% que hace que cuando la animacion llegue a 1, regrese a 0.
            //scrollProgress guarda el numero flotante que representa el progreso del scroll
            //Se suma al progreso un valor proporcional al desplazamiento (delta), escalado por 1000f para que sea más pequeño.
            //coerceIn es una función que asegura que un valor esté dentro de un rango específico, en este caso 0f y 1f.

            // return Offset(x = 0f, y =delta/2) //con esto se puede controlar cosas como que la lista se scrolea la mitad de lo que detecta la app al mover los dedos en la pantalla
            return Offset.Zero //esto hace que no cambie nada
        }
    }//nestedScrollConnection da funciones que podemos usar para obtener informacion sobre la "fuerza de scroll" (que tan rapido o lento se usa el scroll) y con esto se hace las calculaciones para los offsets

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .nestedScroll(nestedScrollConnection),
        state = lazyListStateUno
    ) {


        items(count = 10) {
            Text(
                text = "ObjetoEjemplo",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }


        item {
            Box(
                modifier = Modifier
                    .clipToBounds() // Hace que las imagenes / cosas dentro de la caja no salgan de la caja
                    .fillMaxWidth()
                    .height(mapaMundiAltura + mapaMundiOffset.toDp()) //si quieres que la imagen por arriba se haga un poco mas pequeña se hace lo de +midBgOffset
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color.DarkGray,
                                Color.LightGray
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(R.drawable.mapamundi),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth, // Importante porque hara que las imagenes ocupen el espacio segun el aspecto que pusimos antes, este caso 2:1
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer() {  //permite transformar el contenido de la imagen sin que afecte a otros composables
                            translationY = mapaMundiOffset
                        }
                )



                Image(
                    painter = painterResource(R.drawable.error),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth, // Importante porque hara que las imagenes ocupen el espacio segun el aspecto que pusimos antes, este caso 2:1
                    alignment = Alignment.BottomCenter,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(mapaMundiAltura)
                        .graphicsLayer() {  //permite transformar el contenido de la imagen sin que afecte a otros composables
                            translationY = perritoTristeOffset
                        }
                )
                Image(
                    painter = painterResource(R.drawable.placeholder),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth, // Importante porque hara que las imagenes ocupen el espacio segun el aspecto que pusimos antes, este caso 2:1
                    alignment = Alignment.BottomCenter,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(mapaMundiAltura)
                        .graphicsLayer() {  //permite transformar el contenido de la imagen sin que afecte a otros composables
                            translationY = perritoFelizOffset
                        }
                )

            }

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.gif_pato)
                    .decoderFactory(GifDecoder.Factory())
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.FillWidth, // Importante porque hara que las imagenes ocupen el espacio segun el aspecto que pusimos antes, este caso 2:1
                alignment = Alignment.BottomCenter,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(mapaMundiAltura)
                    .graphicsLayer() {  //permite transformar el contenido de la imagen sin que afecte a otros composables
                        translationY = gifPatoOffset
                    }
            )
            PruebaLottie(
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        translationY = giftLottieUnoOffset
                    },
                scrollProgress = scrollProgress.value
            )


        }


        items(count = 10) {
            Text(
                text = "ObjetoEjemplo",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

        }

    }

}

private fun Float.toDp(): Dp {
    return (this / Resources.getSystem().displayMetrics.density).dp
}//esto es para cambiar las cosas de pixel a dp

/*detalle imporante:

Controlar la velocidad con la fuerza del scroll
El delta que se usa en onPreScroll es la distancia del scroll. Si se quiere usar como velocidad, eso es lo que se esta haciendo
Pero se puede cambiar la velocidad con algo como:

val speedFactor = abs(delta) / 1000f  // solo la magnitud sin signo
scrollProgress.value = (scrollProgress.value + speedFactor) % 1f,
Con lo anterior,  seria proporcional a la fuerza del scroll, no la velocidad que ponemos con el onPreScroll.



Si queremos que la direccion importe, se usa
scrollProgress.value = (scrollProgress.value + delta / 1000f) % 1f
*/