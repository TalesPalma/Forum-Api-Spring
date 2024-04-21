package br.com.talespalma.forumAlura.model

import java.time.LocalDateTime

data class Alunos(val id:Int = 0, val nome:String="", val idade:Int = 0, val dataNascimento: LocalDateTime)
