package br.com.alura.ceep.repository

import br.com.alura.ceep.database.dao.NotaDao
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.services.NotaWebClient
import kotlinx.coroutines.flow.Flow

class NotaRepository(
    private val notaDao: NotaDao,
    private val webClient: NotaWebClient
) {

    fun buscaTodas(): Flow<List<Nota>> {
        return notaDao.buscaTodas()
    }

    suspend fun atualizaTodas() {
        webClient.buscaNotas()?.let {notas ->
            notaDao.salva(notas)
        }
    }

    fun buscaPorId(id: String): Flow<Nota> {
        return notaDao.buscaPorId(id)
    }

    suspend fun remove(id: String) {
        notaDao.remove(id)
    }

    suspend fun salva(nota: Nota) {
        webClient.salva(nota)
        notaDao.salva(nota)
    }

}