package com.example.idiomasvideos.logica.Helper.BoxScreenFunciones

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.idiomasvideos.R


@Composable
fun BoxUno(modifier: Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            text = stringResource(R.string.Box1),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(color = Color.Green)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Image(
            painter = painterResource(R.drawable.placeholder),
            contentDescription = "", //revisar porque sale texto cuando usas una fun
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
fun BoxDos(modifier: Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.error),
                contentDescription = "",
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxSize(0.5f)

            )

            Spacer(modifier = Modifier.width(30.dp))

            Text(
                text = stringResource(R.string.Box2),
                modifier = Modifier
                    .background(color = Color.Yellow)
                    .fillMaxSize(0.5f)
            )
        }
    }
}

@Composable
fun BoxTres(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.placeholder),
        contentDescription = contentDescription3(),
        modifier = modifier
            .size(50.dp)
    )

    Text(
        text = stringResource(R.string.Box1),
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Green)
    )
}

//Lei que no es necesario hacer esto para imagenes que no tienen alguna utilidad, pero igual es bueno saber que hay que hacerlo asi
@Composable
fun BoxCuatro(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.placeholder),
        contentDescription = contentDescription4(),
        modifier = modifier
            .size(50.dp)
    )

    Text(
        text = stringResource(R.string.Box1),
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Green)
    )
}

@Composable
fun contentDescription1(): String {
    val texto = Text(
        text = stringResource(R.string.perritou)
    )
    return texto.toString()
}

@Composable
fun contentDescription2(): String {
    val texto = Text(
        text = stringResource(R.string.perritouTriste)
    )
    return texto.toString()
}

@Composable
fun contentDescription3(): String {
    val texto = Text(
        text = stringResource(R.string.meme1)
    )
    return texto.toString()
}

@Composable
fun contentDescription4(): String {
    val texto = Text(
        text = stringResource(R.string.meme2)
    )
    return texto.toString()
}