package br.com.alura.ceep.webclient.services

import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.RetrofitInicializador
import br.com.alura.ceep.webclient.model.NotaResposta

class NotaWebClient {

    suspend fun buscaNotas(): List<Nota> {
        val notasResposta: List<NotaResposta> =
            RetrofitInicializador().notaService.buscaTodas()

        return notasResposta.map { notaResposta ->
            notaResposta.nota
        }
    }
}