package br.com.talespalma.forumAlura.model

import java.time.LocalDateTime

data class Resposta(
    val id: Long? = null,
    val titulo: String = "",
    val mensagem: String = "",
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val topico: Topico = Topico(),
    val autor: Usuario = Usuario()
)
