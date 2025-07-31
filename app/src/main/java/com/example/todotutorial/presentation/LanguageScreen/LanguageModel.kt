package com.example.todotutorial.presentation.LanguageScreen

import androidx.compose.runtime.Composable
import com.example.todotutorial.R


data class LanguagesModel(
    val img: Int,
    val languageName: String,
    val nativeName: String,
    val shortCode: String,
    val isSelected: Boolean = false
)



val languageList = listOf(
    LanguagesModel(R.drawable.ic_eng, "English (UK)", "English", "en"),
    LanguagesModel(R.drawable.ic_afrikaans, "Afrikaans", "Afrikaans", "af"),
    LanguagesModel(R.drawable.ic_albanian, "Albanian", "shqiptare", "sq"),
    LanguagesModel(R.drawable.ic_amharic, "Amharic", "አማርኛ", "am"),
    LanguagesModel(R.drawable.ic_arabic, "Arabic", "العربية", "ar"),
    LanguagesModel(R.drawable.ic_armenian, "Armenian", "հայերեն", "hy"),
    LanguagesModel(R.drawable.ic_azeerbaijani, "Azerbaijan", "Azərbaycan", "az"),
    LanguagesModel(R.drawable.ic_basque, "Basque", "baque", "eu"),
    LanguagesModel(R.drawable.ic_bengali, "Bengali", "বাংলা", "bn"),
    LanguagesModel(R.drawable.ic_bosnian, "Bosnian", "bosanski", "bs"),
    LanguagesModel(R.drawable.ic_bulgaria, "Bulgaria", "bulgarian", "bg")
)
