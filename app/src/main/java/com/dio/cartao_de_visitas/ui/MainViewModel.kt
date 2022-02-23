package com.dio.cartao_de_visitas.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dio.cartao_de_visitas.data.CartaoVisita
import com.dio.cartao_de_visitas.data.CartaoVisitaRepository
import java.lang.IllegalArgumentException

class MainViewModel (private val cartaoRepository: CartaoVisitaRepository) : ViewModel(){

    fun insert(cartaoVisita: CartaoVisita){
        cartaoRepository.insert(cartaoVisita)
    }
    fun getAll() : LiveData<List<CartaoVisita>>{
        return cartaoRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: CartaoVisitaRepository) :
    ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}