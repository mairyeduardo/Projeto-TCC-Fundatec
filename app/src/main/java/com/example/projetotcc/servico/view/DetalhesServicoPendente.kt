package com.example.projetotcc.servico.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.projetotcc.databinding.ActivityDetalhesServicoPendenteBinding
import com.example.projetotcc.home.domain.ServicoModel

private const val DELAY_TELA = 1000L

class DetalhesServicoPendente : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesServicoPendenteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesServicoPendenteBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        val servico = intent.extras?.getSerializable("servico") as? ServicoModel
        if (servico == null) {
            finish()
            return
        }
        binding.textTitulo.text = servico.titulo
        binding.textDescricao.text = servico.descricao
        binding.textEndereco.text = servico.enderecoServico
        binding.textValor.text = servico.valorServico.toString()
        binding.textCusto.text = servico.custoAtual.toString()
        binding.textData.text = servico.dataInicio
        binding.textNomeCliente.text = servico.nomeCliente
        Log.e("teste", servico.toString())


    }
}