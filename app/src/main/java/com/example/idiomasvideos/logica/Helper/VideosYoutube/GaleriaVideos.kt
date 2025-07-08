package com.example.idiomasvideos.logica.Helper.VideosYoutube


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items


    @Composable
    fun GaleriaDeVideos(dataVideos: List<DataVideos>) {
        LazyRow {
            items(dataVideos) { videos ->
                YoutubeVideo(
                    videoId = videos.videoId,
                    titulo = videos.titulo,
                    modifier = Modifier
                        .padding(8.dp)
                        .width(200.dp)
                )
            }
        }
    }