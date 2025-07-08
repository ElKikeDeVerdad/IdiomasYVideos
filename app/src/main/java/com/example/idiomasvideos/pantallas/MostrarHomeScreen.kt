package com.example.idiomasvideos.pantallas

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.idiomasvideos.logica.Helper.Barras.AppScaffold
import com.example.idiomasvideos.logica.Logica_pantallas.HomeScreen



    @Composable
    fun MostrarHomeScreen(
        modifier: Modifier,
        navController: NavHostController
    ){
        AppScaffold(
            navController = navController,
            content = {padding ->
                HomeScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                   // .background(Color.Yellow) el padding no funcionaba asi que use esto para buscar errores
                  //  .border(2.dp, Color.Red) el padding no funcionaba asi que use esto para buscar errores
                )
            }

        )


    }

