package com.dio.cartao_de_visitas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.dio.cartao_de_visitas.App
import com.dio.cartao_de_visitas.databinding.ActivityMainBinding
import com.dio.cartao_de_visitas.util.Image

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels {
        MainViewModelFactory((application as App).repo)
    }
    private val adapter by lazy { CartaoVisitaAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCards.adapter = adapter
        getAllCartaoVisita()
        setListeners()
    }

    private fun setListeners(){
        binding.fabAddCard.setOnClickListener(){
            val intent = Intent(this, AddNewCardActivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = {card->
            Image.share(this@MainActivity,card)
        }
    }

    private fun getAllCartaoVisita(){
        mainViewModel.getAll().observe(this) { cards ->
            adapter.submitList(cards)
        }
    }
}