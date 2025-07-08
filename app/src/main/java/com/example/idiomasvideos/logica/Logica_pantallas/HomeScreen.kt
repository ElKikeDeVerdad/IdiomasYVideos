package com.example.idiomasvideos.logica.Logica_pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.idiomasvideos.R
import com.example.idiomasvideos.ViewModel.VideosViewModel
import com.example.idiomasvideos.logica.Helper.VideosYoutube.GaleriaDeVideos
import androidx.compose.runtime.getValue



@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    videosViewModel: VideosViewModel = viewModel()
) {
    val listaVideos by videosViewModel.videos.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
     //       .background(Color.Green)  el padding no funcionaba asi que use esto para buscar errores
     //       .border(2.dp, Color.Blue) el padding no funcionaba asi que use esto para buscar errores
    ) {
        Text(text = stringResource(R.string.PrimerVideo))
        Spacer(modifier = Modifier.height(16.dp))

        GaleriaDeVideos(dataVideos = listaVideos)
    }
}



