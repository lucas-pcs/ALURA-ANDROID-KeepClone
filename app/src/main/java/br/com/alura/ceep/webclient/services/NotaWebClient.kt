package br.com.alura.ceep.webclient.services

import android.util.Log
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.RetrofitInicializador
import br.com.alura.ceep.webclient.model.NotaRequisicao
import br.com.alura.ceep.webclient.model.NotaResposta

class NotaWebClient {
    private val notaService = RetrofitInicializador().notaService
    private val TAG: String = "NotaWebClient"

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

    suspend fun salva(nota: Nota) {
        try {
            val resposta = notaService.salva(
                id = nota.id,
                nota = NotaRequisicao(
                    titulo = nota.titulo,
                    descricao = nota.descricao,
                    imagem = nota.imagem
                ))
            if(resposta.isSuccessful){
                Log.i(TAG, "salva: nota salva com sucesso")
            } else {
                Log.i(TAG, "salva: falha ao salvar a nota")
            }
        } catch (e: Exception) {
            Log.e(TAG, "salva: erro ao salvar a nota", e)
        }
    }

}