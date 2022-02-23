package com.dio.cartao_de_visitas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CartaoVisita::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun cartaoDAO() : CartaoVisitaDAO

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null
        fun getDataBase(context: Context) : AppDataBase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "cartaoVisita_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}