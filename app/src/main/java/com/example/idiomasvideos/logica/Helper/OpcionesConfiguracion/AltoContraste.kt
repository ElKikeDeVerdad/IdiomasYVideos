package com.example.idiomasvideos.logica.Helper.OpcionesConfiguracion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.idiomasvideos.ViewModel.ConfiguracionViewModel.ContrasteViewModel
import com.example.idiomasvideos.logica.Helper.Botones.BotonSwitch
import com.example.idiomasvideos.logica.Helper.Botones.UsarBotonSwitch

@Composable
fun BotonSwitcheAltoContraste(
    contrasteViewModel: ContrasteViewModel = viewModel()
){
    var encendido = remember { mutableStateOf(contrasteViewModel.encendido)}

    BotonSwitch(
        encendido = encendido ,
        cambiarSwiche = {
            contrasteViewModel.CambiarSwitche()
            encendido.value = contrasteViewModel.encendido
        }
    )
}