package br.com.talespalma.forumAlura.DTO

import br.com.talespalma.forumAlura.model.StatusTopicos
import java.time.LocalDateTime

data class TopicoView(
    val id : Long? = null,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopicos,
    val dataCriacao: LocalDateTime
)