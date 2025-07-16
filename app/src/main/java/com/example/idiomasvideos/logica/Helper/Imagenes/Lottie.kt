package com.example.idiomasvideos.logica.Helper.Imagenes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun PruebaLottie(
    modifier: Modifier = Modifier,
    scrollProgress: Float
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("EVA.json")) //crea una composicion para poder meter varios lotties y que cargen todos juntos segun vayas poniendo lotties

    LottieAnimation(
        composition = composition,
        progress = { scrollProgress }, //Manejaremos este parametro en el paralax y no aqui
        modifier = modifier
    )
    if (composition != null) {
        LottieAnimation(
            composition = composition,
            progress = { scrollProgress },
            modifier = modifier
        )
    } else {
        Text("Cargando animación...", color = Color.White)
    }


}