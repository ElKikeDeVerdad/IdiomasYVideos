package com.example.idiomasvideos.logica.Helper.VideosYoutube

import com.example.idiomasvideos.R
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun YoutubeVideo(videoId: String, titulo: String, modifier: Modifier){
    val context = LocalContext.current
    val thumbnailUrl = "https://img.youtube.com/vi/$videoId/0.jpg"

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable {
                val abrirYoutube =
                    Intent(        //Intent permite abrir un navegador o app externa, en este caso youtube
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/watch?v=$videoId") //Uri.parse cambiar un texto URL en un Uri, y Uri es una direccion como URL
                    )
                context.startActivity(abrirYoutube)

            }
    ){
        AsyncImage(
            model = thumbnailUrl,
            contentDescription = "Youtube Thumbnail",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize(),
            placeholder = painterResource(id = R.drawable.placeholder), //esto era una prueba porque crasheaba, no es necesario ponerlo
            error = painterResource(id = R.drawable.error)// esto era una prueba porque crasheaba, no es necesario ponerlo
        )
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "Play",
            tint = Color.White,
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.Center)

        )
    }
}
