package com.example.idiomasvideos.ViewModel.ConfiguracionViewModel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class ConfiguracionViewModel : ViewModel() {

    private val _contrasteEncendido = MutableStateFlow(false)

    val contrasteEncendido: StateFlow<Boolean> = _contrasteEncendido

    fun CambiarContraste() {
        _contrasteEncendido.value = !_contrasteEncendido.value
    }

    fun ObtenerColorContraste(encendido: Boolean): Color {
        return if (encendido) Color(0xFF572364) else Color(0xFF1976D2)
    }
}
