package com.example.idiomasvideos.logica.Helper.TransicionesPantallas

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.ui.graphics.TransformOrigin
import androidx.navigation.NavBackStackEntry

object TransicionZoom {

    //Definir duracion milisegundo, cambiar esto para que sea mas rapido o lento la transicion, esta puesto muy lento para que se aprecie mejor la transicion.
    private const val duracionZoom = 2000

    //Zoom in
    val zoomInTransicion: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
        scaleIn(
            animationSpec = tween(durationMillis = duracionZoom),
            initialScale = 0f,
            transformOrigin = TransformOrigin(0.5f, 0.5f)
        ) + fadeIn(animationSpec = tween(durationMillis = duracionZoom))
    }

    //Zoom Out
    val zoomOutTransicion: AnimatedContentTransitionScope<NavBackStackEntry>.() ->ExitTransition =
    {
        scaleOut(
            animationSpec = tween(durationMillis = duracionZoom),
            targetScale = 0f,
            transformOrigin = TransformOrigin(0.5f, 0.5f)
        ) + fadeOut(animationSpec = tween(durationMillis = duracionZoom))
    }

    //Fundido simple
    val fadeInTransicion: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition =
    {
        fadeIn(animationSpec = tween(durationMillis = duracionZoom))
    }

    val fadeOutTransicion: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition =
    {
        fadeOut(animationSpec = tween(durationMillis = duracionZoom))

    }
}