package com.dio.cartao_de_visitas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.dio.cartao_de_visitas.App
import com.dio.cartao_de_visitas.R
import com.dio.cartao_de_visitas.data.CartaoVisita
import com.dio.cartao_de_visitas.databinding.ActivityAddNewCardBinding

class AddNewCardActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddNewCardBinding.inflate(layoutInflater) }
    private val mainViewModel : MainViewModel by viewModels {
        MainViewModelFactory((application as App).repo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners(){
        binding.btnClose.setOnClickListener(){
            finish()
        }
        binding.btnConfirm.setOnClickListener {
            val card = CartaoVisita(
                nome = binding.tilNome.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                background = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(card)
            Toast.makeText(this, R.string.tast_onAdd_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}