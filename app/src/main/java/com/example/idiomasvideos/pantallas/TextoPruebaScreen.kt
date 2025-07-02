package com.example.idiomasvideos.pantallas

import android.R.attr.padding
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.idiomasvideos.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    title: String = "Prueba",
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
                    .fillMaxHeight(0.3f),

                title = {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        text = stringResource(R.string.tituloTopBar),
                        textAlign = TextAlign.Center,
                    )
                }

                )
        },
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.1f)
                    //.background(
                    //     color = Color.Blue,
                    //     shape = RectangleShape
                    // )


                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            textAlign = TextAlign.Center,
                            fontSize = 25.sp,
                            text = "Este es el BottomBar"

                        )
                        Row {
                            IconButton(
                                onClick = { /* acción */ }) {
                                Icon(Icons.Default.Home, contentDescription = "Inicio")
                            }
                            IconButton(onClick = { /* acción */ }) {
                                Icon(Icons.Default.Favorite, contentDescription = "Favoritos")
                            }
                        }
                    }
                }
            }
        }
    ) { padding ->
        Text(
            text = "Prueba"
        )
        content(padding)
    }
}