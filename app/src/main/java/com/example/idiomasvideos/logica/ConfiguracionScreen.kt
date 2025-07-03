package com.example.idiomasvideos.logica

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.idiomasvideos.R
import com.example.idiomasvideos.logica.Helper.UsarBotonSwitch
//A diferencia de TextoPruebaScreen, aqui no pondre los parametros de las funciones ya que no van a cambiar
@Composable
fun ConfiguracionScreen(
    modifier: Modifier = Modifier
){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        fondoConfigurationScreen()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(modifier)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.2f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                tituloConfigurationScreen()
            }
            Spacer(modifier = Modifier.height(30.dp))

            Row {
                UsarBotonSwitch()
            }
            Spacer(modifier = Modifier.height(30.dp))

            Row {
                UsarBotonSwitch()
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row {
                UsarBotonSwitch()
            }
        }
    }
}

@Composable
fun tituloConfigurationScreen(){
    Text(
        text = stringResource(R.string.tituloConfiguracion))

}

@Composable
fun fondoConfigurationScreen(){
    Image(
        painter = painterResource(R.drawable.fondo_1),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
    )
}



