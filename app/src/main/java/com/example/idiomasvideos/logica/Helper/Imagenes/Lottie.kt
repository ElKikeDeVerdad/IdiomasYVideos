package com.example.idiomasvideos.logica.Helper.Imagenes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
@Composable
fun PruebaLottie(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("EVA.json")) //crea una composicion para poder meter varios lotties y que cargen todos juntos segun vayas poniendo lotties
    val progress by animateLottieCompositionAsState(  //es lo que permite que la composicion se mueva dependiendo de las condiciones (parametros) que pongas
        composition,
        iterations = LottieConstants.IterateForever, //iteration es un parametro que dice cuantas veces el lottie se va a repetir, en este caso, para siempre
        isPlaying = true
    )
//esto se llama Guard clause, evita errores y evita ejecutar codigo sin que se cumpla condiciones, en este caso se evita renderizar nada hasta que esté cargado correctamente. Para mas info buscar sobre guard clause
    composition?.let {
        LottieAnimation(
            composition = it,
            progress = { progress }, //es una animacion de estado, le da a Lottie una forma de saber el progreso animado en cada frame
            modifier = modifier
        )
    }
}