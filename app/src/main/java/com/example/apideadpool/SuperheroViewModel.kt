package com.example.apideadpool

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SuperheroViewModel : ViewModel() {
    private val _superhero = MutableLiveData<Superhero>()
    val superhero: LiveData<Superhero> = _superhero

    fun fetchSuperhero(id: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.superheroApi.getSuperhero(id)
                _superhero.value = response
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}