package com.example.projetotcc.relatorio.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.projetotcc.cliente.view.ClienteActivity
import com.example.projetotcc.databinding.ActivityRelatorioIndividualBinding
import com.example.projetotcc.home.view.HomeActivity
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

        configurarBotaoRelatorio()
        configurarBotaoCliente()
        configurarBotaoHome()
    }

    private fun chamarTelaRelatorio() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@RelatorioDetailsActivity, RelatorioActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaCliente() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@RelatorioDetailsActivity, ClienteActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun chamarTelaHome() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@RelatorioDetailsActivity, HomeActivity::class.java)
            startActivity(intent)
        }, DELAY_TELA)
    }

    private fun configurarBotaoRelatorio() {
        binding.ivRelatorio.setOnClickListener {
            chamarTelaRelatorio()
        }
    }

    private fun configurarBotaoCliente() {
        binding.ivCliente.setOnClickListener {
            chamarTelaCliente()
        }
    }

    private fun configurarBotaoHome() {
        binding.ivServico.setOnClickListener {
            chamarTelaHome()
        }
    }

}