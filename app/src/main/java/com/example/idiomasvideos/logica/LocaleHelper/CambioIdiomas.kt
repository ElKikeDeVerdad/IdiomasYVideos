package com.example.idiomasvideos.logica.LocaleHelper

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import java.util.Locale
import androidx.core.content.edit

class LocaleHelper private constructor(base: Context) : ContextWrapper(base) {

    companion object {
        private const val idiomaSeleccionado = "IdiomaSeleccionado"
        private const val PrefName = "AppLocalePrefs"

        //funcion que guarda y cambia de locale, retorna un nuevo ContextWrapper actualizado con el idioma

        fun setLocale(context: Context, language: String): ContextWrapper {
            val locale = Locale(language)
            Locale.setDefault(locale) // Establece el Locale por defecto para Java VM (buenas prácticas, posiblemente no tengamos que hacerlo)

            val config =
                Configuration(context.resources.configuration) //crea una copia modificable de la configuracion, evita problemas con la configuración compartida de recursos.
            config.setLocale(locale)


            // Guarda el idioma seleccionado en SharedPreferences
            guardarIdioma(context, language)

            // Crea y retorna un nuevo ContextWrapper con la configuración actualizada
            return LocaleHelper(context.createConfigurationContext(config))

        }

        //Obtiene idioma guardado o string vacio si no hay ninguno
        fun getPersistedLanguage(context: Context): String {
            val prefs = context.getSharedPreferences(PrefName, Context.MODE_PRIVATE)
            return prefs.getString(idiomaSeleccionado, "") ?: ""
        }

        //Guarda el idioma en SharedPreferences
        private fun guardarIdioma(context: Context, language: String) {
            context.getSharedPreferences(PrefName, Context.MODE_PRIVATE)
                .edit() {
                    putString(idiomaSeleccionado, language)
                }
        }


        // Envuelve el contexto base de la aplicación/Activity al inicio. Esto carga el idioma guardado o predefinido
        fun wrapContext(context: Context): ContextWrapper {
            val language = getPersistedLanguage(context)
            return if (language.isEmpty()) {
                LocaleHelper(context) //Si no hay idioma guardado, usa el Contexto original
            } else {
                setLocale(context, language) // Si hay idioma guardado, lo aplica
            }
        }

        // Helper para obtener el Locale actual del Context, cada que se llame esta fun, se obtenga el objeto del idioma seleccionado, permitiendo asi hacer cambios especificos de un idioma de ser necesario
        fun getLocaleFromContext(context: Context): Locale {
            return context.resources.configuration.locales.get(0)

        }
    }
}

