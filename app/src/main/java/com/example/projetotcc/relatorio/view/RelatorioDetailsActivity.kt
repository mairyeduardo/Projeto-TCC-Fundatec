package com.example.projetotcc.relatorio.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.databinding.ActivityRelatorioIndividualBinding
import com.example.projetotcc.relatorio.domain.RelatorioModel

private const val DELAY_TELA = 1000L

class RelatorioDetailsActivity : AppCompatActivity(){

    private lateinit var binding: ActivityRelatorioIndividualBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRelatorioIndividualBinding.inflate(layoutInflater)

        getSupportActionBar()?.hide()
        setContentView(binding.root)

        val relatorio = intent.extras?.getSerializable("relatorio") as? RelatorioModel
        if (relatorio == null) {
            finish()
            return
        }

        binding.dataInicio.text = relatorio.dataInicio
        binding.dataFinal.text = relatorio.dataFinal
        binding.tituloServico.text = relatorio.tituloTarefa
        binding.descricaoServico.text = relatorio.descricaoTarefa
        binding.diasServico.text = relatorio.totalDeDias.toString()
        binding.nomeCliente.text = relatorio.nomeCliente
        binding.enderecoCliente.text = relatorio.enderecoServico
        binding.valorBruto.text = relatorio.valorServico.toString()
        binding.despesasTotais.text = relatorio.custoAtual.toString()
        binding.liquidoTotal.text = relatorio.valorLiquido.toString()

    }
}