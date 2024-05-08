package br.com.talespalma.forumAlura.DTO

import java.time.LocalDateTime

data class ErrorView(
    val timeTamp: LocalDateTime =  LocalDateTime.now(),
    val status:Int,
    val error:String,
    val message:String?,
    val path:String
)
