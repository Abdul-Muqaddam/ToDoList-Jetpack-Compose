package com.example.todotutorial.presentation.LanguageScreen

import androidx.lifecycle.ViewModel
import com.example.todotutorial.data.AppPreference
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class LanguageDetails(
    val languages: List<LanguagesModel> = emptyList(),
    val selectedLanguage: String = ""
)

class LanguageScreenViewModel : ViewModel() {
    private val _state = MutableStateFlow(LanguageDetails())
    val state: StateFlow<LanguageDetails> = _state


    fun onLanguageSelect(languageAbbr: String) {
        _state.update { currentState ->
            currentState.copy(
                selectedLanguage = languageAbbr,
            )
        }
    }
    fun onLanguageSearch(query:String){
        val allLanguages= languageList
        val filtered = if(query.isBlank()){
            allLanguages
        }else{
            allLanguages.filter {
                it.languageName.contains(query, ignoreCase = true)
            }
        }
        _state.update {
            it.copy(
                languages = filtered
            )
        }

    }

    init {
        val savedLang = AppPreference.getLanguageCode()
        val updatedList = languageList.map {
            it.copy(isSelected = it.shortCode == savedLang)
        }
        _state.update {
            it.copy(
                selectedLanguage = savedLang,
                languages = updatedList
            )
        }


    }


}