package br.com.talespalma.forumAlura.model

import ch.qos.logback.core.status.Status
import java.awt.Cursor
import java.time.LocalDateTime

data class Topico(
    val id:Long? = null,
    val titulo: String = "",
    val mensagem: String = "",
    val dataCriacao:LocalDateTime = LocalDateTime.now(),
    val curso:Curso = Curso(),
    val autor:Usuario = Usuario(),
    val status: StatusTopicos = StatusTopicos.NAO_RESPONDIDO,
    val respostas:List<Resposta> = emptyList()
)
