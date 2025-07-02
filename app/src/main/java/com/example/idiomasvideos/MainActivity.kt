package com.example.idiomasvideos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.idiomasvideos.pantallas.AppScaffold
import com.example.idiomasvideos.pantallas.HomeScreen
import com.example.idiomasvideos.ui.theme.IdiomasVideosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IdiomasVideosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        navController = rememberNavController(),
                        modifier = Modifier.padding(innerPadding))
                            TextoPruebaScreen(
                                content = { paddingValues -> },
                                modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
    @Composable
    fun TextoPruebaScreen(
        title: String = "",
        showBottomBar: Boolean = true,
        content: @Composable (PaddingValues) -> Unit = {},
        modifier: Modifier = Modifier
    ){
        AppScaffold()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewCopiarAEjercicioIdiomasVideos() {
        IdiomasVideosTheme {
            TextoPruebaScreen()
        }
    }




}

