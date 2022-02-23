package com.dio.cartao_de_visitas

import android.app.Application
import com.dio.cartao_de_visitas.data.AppDataBase
import com.dio.cartao_de_visitas.data.CartaoVisitaRepository

class App : Application() {
    val database by lazy { AppDataBase.getDataBase(this)}
    val repo by lazy { CartaoVisitaRepository(database.cartaoDAO()) }
}