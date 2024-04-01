package br.com.alura.ceep.webclient.services

import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.RetrofitInicializador
import br.com.alura.ceep.webclient.model.NotaResposta

class NotaWebClient {
    private val notaService = RetrofitInicializador().notaService

    suspend fun buscaNotas(): List<Nota>? {
        return try {
            val notasResposta: List<NotaResposta> =
                notaService.buscaTodas()

            notasResposta.map { notaResposta ->
                notaResposta.nota
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }
}