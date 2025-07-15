package com.example.idiomasvideos.logica.Logica_pantallas

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.idiomasvideos.R
import com.example.idiomasvideos.ViewModel.IdiomaViewModel
import com.example.idiomasvideos.logica.Helper.Botones.UsarBotonSwitch
import com.example.idiomasvideos.logica.Helper.OpcionesConfiguracion.BotonSwitcheAltoContraste

//A diferencia de TextoPruebaScreen, aqui no pondre los parametros de las funciones ya que no van a cambiar
@Composable
fun ConfiguracionScreen(
    modifier: Modifier = Modifier
) {
    val idiomaVM: IdiomaViewModel = viewModel()
    val context = LocalContext.current
    val activity = context as? Activity

    var expanded by remember { mutableStateOf(false) }
    val idiomasDisponibles = listOf("es", "en", "fr") // Idiomas
    val etiquetas = mapOf("es" to "Español", "en" to "Inglés", "fr" to "Francés")

    // Estado local para el idioma seleccionado
    var idiomaSeleccionado by remember { mutableStateOf(idiomaVM.idiomaActual()) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        fondoConfigurationScreen()

        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                tituloConfigurationScreen()
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Alto Contraste
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.AltoContraste))
                Spacer(modifier = Modifier.width(168.dp))
                BotonSwitcheAltoContraste()
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Subtítulos
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.SubitulosAutomaticos))
                Spacer(modifier = Modifier.width(100.dp))
                UsarBotonSwitch()
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Ubicación
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.Ubicacion))
                Spacer(modifier = Modifier.width(210.dp))
                UsarBotonSwitch()
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Sección de idioma
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Idioma actual: ${etiquetas[idiomaSeleccionado]}") // Mostrara el valor actual de la etiqueta dependiendo de la funcion idiomaSeleccionado
                Spacer(modifier = Modifier.width(16.dp))

                //crear el boton para seleccionar idioma de tipo dropdownmenu
                Box {
                    Button(onClick = { expanded = true }) { //cuando le hagas click se hace true por lo que muestra la lista
                        Text("Seleccionar idioma")
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false } //OnDismissRequest es cuando la accion termine, ocurrira que el expanded ahora se false, quitando la lista
                    ) {

                        //esto realiza la accion de cambiar el idioma utilizando el viewmodel.
                        idiomasDisponibles.forEach { idioma ->
                            DropdownMenuItem(
                                onClick = {
                                    idiomaSeleccionado = idioma
                                    expanded = false
                                    idiomaVM.cambiarIdioma(idioma)
                                    activity?.recreate()
                                },
                                text = {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        //Muestra por medio de un boton circular cual idioma esta seleccionado rellenando el circulo interno
                                        RadioButton(
                                            selected = idiomaSeleccionado == idioma,
                                            onClick = null // manejado por el onClick de DropdownMenuItem
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(etiquetas[idioma] ?: idioma)
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun tituloConfigurationScreen() {
    Text(
        text = stringResource(R.string.tituloConfiguracion),
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        color = Color.Blue

    )

}

@Composable
fun fondoConfigurationScreen() {
    Image(
        painter = painterResource(R.drawable.fondo_1),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
    )
}



