package com.example.idiomasvideos.pantallas

import android.R.attr.padding
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.idiomasvideos.R
import com.example.idiomasvideos.logica.BodyTextoPruebaScreen
import com.example.idiomasvideos.logica.fondoBodyPrueba
import com.example.idiomasvideos.logica.imagenBodyPrueba
import com.example.idiomasvideos.logica.textoBodyPrueba
import com.example.idiomasvideos.logica.tituloBodyPrueba

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    title: String = "",
    showBottomBar: Boolean = true,
    onNavigationClick: () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit = {},
    shape: Shape = RectangleShape

) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.15f),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1976D2)
                ),

                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center

                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = stringResource(R.string.tituloTopBar),
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.W600

                        )
                    }
                }

            )
        },
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.1f),
                    containerColor = Color(0xFF1976D2)


                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                            .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                            Text(
                                modifier = Modifier,
                                textAlign = TextAlign.Center,
                                fontSize = 25.sp,
                                text = "Este es el BottomBar",
                                color = Color.White

                            )
                            Row{
                                IconButton(
                                    onClick = { /* acción */ }) {
                                    Icon(
                                        Icons.Default.Home,
                                        contentDescription = "Inicio",
                                        modifier = Modifier
                                            .size(40.dp)
                                        )
                                }
                                IconButton(
                                    onClick = { /* acción */ }) {
                                    Icon(
                                        Icons
                                            .Default
                                            .Favorite,
                                        contentDescription = "Favoritos",
                                        modifier = Modifier
                                            .size(40.dp)


                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    ) { padding ->
BodyTextoPruebaScreen(
    modifier = Modifier
        .padding(padding),
    fondoBodyPrueba = {fondoBodyPrueba()},
    tituloBodyPrueba = {tituloBodyPrueba()},
    textoBodyPrueba = {textoBodyPrueba()},
    imagenBodyPrueba = {imagenBodyPrueba()}
)
        content(padding)
    }
}