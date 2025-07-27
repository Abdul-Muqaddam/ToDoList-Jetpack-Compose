package com.example.todotutorial.presentation.LanguageScreen

import androidx.compose.runtime.Composable
import com.example.todotutorial.R


enum class LanguagesModel(
    val img: Int,
    val languageName: String,
    val nativeName: String
) {
    ENGLISH(img = R.drawable.ic_eng, languageName = "English (UK)", nativeName = "English"),
    Afrikaans(img = R.drawable.ic_afrikaans, languageName = "Afrikaans", nativeName = "Afrikaans"),
    Albanian(img = R.drawable.ic_albanian, languageName = "Albanian", nativeName = "shqiptare"),
    Amharic(img = R.drawable.ic_amharic, languageName = "Amharic", nativeName = "አማርኛ"),
    Arabic(img = R.drawable.ic_arabic, languageName = "Arabic", nativeName = "العربية"),
    Armenian(img = R.drawable.ic_armenian, languageName = "Armenian", nativeName = "հայերեն"),
    Azerbaijani(
        img = R.drawable.ic_azeerbaijani,
        languageName = "Azerbaijan",
        nativeName = "Azərbaycan"
    ),
    Basque(img = R.drawable.ic_basque, languageName = "Basque", nativeName = "baque"),
    Bengali(img = R.drawable.ic_bengali, languageName = "Bengali", nativeName = "বাংলা"),
    Bosnian(img = R.drawable.ic_bosnian, languageName = "Bosnian", nativeName = "bosanski"),
    Bulgaria(img = R.drawable.ic_bulgaria, languageName = "Bulgaria", nativeName = "bulgarian"),
}
