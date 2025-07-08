package com.example.idiomasvideos.logica.Logica_pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.idiomasvideos.R
import com.example.idiomasvideos.logica.Helper.VideosYoutube.YoutubeVideo



@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
     //       .background(Color.Green)  el padding no funcionaba asi que use esto para buscar errores
     //       .border(2.dp, Color.Blue) el padding no funcionaba asi que use esto para buscar errores
    ) {
        Text(text = stringResource(R.string.PrimerVideo))
        Spacer(modifier = Modifier.height(16.dp))
        YoutubeVideo(videoId = "5W1FkMDtcuY")
    }
}



