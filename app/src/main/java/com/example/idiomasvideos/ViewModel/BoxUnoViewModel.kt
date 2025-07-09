package com.example.idiomasvideos.ViewModel


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BoxUnoViewModel : ViewModel() {
    private val _encendido = mutableStateOf(false)
    val encendido: State<Boolean> = _encendido

    fun cambiarEstado() {
        _encendido.value = !_encendido.value
    }
}


