package br.com.alura.ceep.webclient.model

import br.com.alura.ceep.model.Nota

class NotaResposta(
    val id: String?,
    val titulo: String?,
    val descricao: String?,
    val imagem: String?
) {
    val nota: Nota
        get() {
            return Nota(
                id = 0L,
                titulo = titulo ?: "",
                descricao = descricao ?: "",
                imagem = imagem ?: ""
            )
        }
}