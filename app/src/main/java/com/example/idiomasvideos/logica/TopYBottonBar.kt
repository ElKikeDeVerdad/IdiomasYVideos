package com.example.idiomasvideos.logica

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.idiomasvideos.R
import com.example.idiomasvideos.navegacion.Rutas

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    showBottomBar: Boolean = true,
    content: @Composable (PaddingValues) -> Unit = {},
    navController: NavController

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
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                IconButton(
                                    onClick = { navController.navigate(Rutas.HOME)}) {
                                    Icon(
                                        Icons.Default.Home,
                                        contentDescription = "Inicio",
                                        modifier = Modifier
                                            .size(40.dp)
                                    ) }
                                IconButton(
                                    onClick = { navController.navigate(Rutas.TEXTOPRUEBASCREEN) }) {
                                    Icon(
                                        Icons.Default.Favorite,
                                        contentDescription = "Favoritos",
                                        modifier = Modifier
                                            .size(40.dp)
                                    ) }
                                IconButton(
                                    onClick = {navController.navigate(Rutas.CONFIGURACION) }) {
                                    Icon(
                                        Icons.Default.Settings,
                                        contentDescription = "Configuracion",
                                        modifier = Modifier
                                            .size(40.dp)
                                    ) }
                            }
                        }
                    }
                }
            }
        }
    ) { padding ->
        content(padding)
    }
}

