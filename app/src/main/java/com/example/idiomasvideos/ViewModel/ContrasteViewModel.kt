package com.example.idiomasvideos.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class ContrasteViewModel: ViewModel() {

    // Usamos mutableStateOf para crear el estado mutable
    private val _encendido = mutableStateOf(false) // Estado privado de 'encendido'

    // Exponemos el valor de 'encendido' como un estado de solo lectura
    val encendido: Boolean
        get() = _encendido.value

    // Función para cambiar el estado de 'encendido'
    fun CambiarSwitche() {
        _encendido.value = !_encendido.value // Cambia el valor de 'encendido'
    }

    // Función para obtener el color según el estado
    fun obtenerColor(): Color {
        return if (encendido) Color(0xFF572364) else Color(0xFF1976D2)
    }
}