package com.example.idiomasvideos.ViewModel


import androidx.lifecycle.ViewModel
import com.example.idiomasvideos.logica.Helper.VideosYoutube.DataVideos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class VideosViewModel: ViewModel(){

    private val _videos = MutableStateFlow<List<DataVideos>>(emptyList())
    val videos: StateFlow<List<DataVideos>> = _videos


    init {
        cargarVideos()
    }

    private fun cargarVideos(){
        _videos.value = listOf(
            DataVideos("5W1FkMDtcuY", "Perrito"),
            DataVideos("mbPasem4kK0", "Perro Peruano"),
            DataVideos("Hkz21qHMdvw", "Huh?")
        )
    }
}