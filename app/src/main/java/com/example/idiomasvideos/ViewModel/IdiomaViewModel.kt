package com.example.idiomasvideos.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.idiomasvideos.logica.LocaleHelper.LocaleHelper


class IdiomaViewModel(application: Application) : AndroidViewModel(application) {

    // Cambia el idioma y reinicia el contexto
    fun cambiarIdioma(language: String) {
        val context = getApplication<Application>().applicationContext
        LocaleHelper.setLocale(context, language)
    }

    // Para obtener el idioma actual (por ejemplo, para mostrar qué idioma está activo)
    fun idiomaActual(): String {
        val context = getApplication<Application>().applicationContext
        return LocaleHelper.getPersistedLanguage(context)
    }
}