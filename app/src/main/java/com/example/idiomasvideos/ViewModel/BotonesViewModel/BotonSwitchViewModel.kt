package com.example.idiomasvideos.ViewModel.BotonesViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BotonSwitchViewModel: ViewModel() {
    private val _encendido =
        MutableStateFlow(false) // False para que cuando se cree el boton durante el proceso de creacion de la app, este sea False (apagado)
    val encendido: StateFlow<Boolean> = _encendido // Esto es lo que se puede observar

    fun cambiarEstado() {
        _encendido.value = !_encendido.value  // Recordar que ! es el operador distinto a, esto provoca que cuando ocurra la accion,
                                              // el valor de _encedido siempre va a ser distinto a antes de la accion.
    }
}