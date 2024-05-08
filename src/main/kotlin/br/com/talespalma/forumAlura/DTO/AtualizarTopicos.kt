package br.com.talespalma.forumAlura.DTO

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull

data class AtualizarTopicos(
    @field:NotNull val id:Long,
    @field:NotEmpty @field:Size (min = 5, max = 100) val titulo: String,
    @field:NotEmpty val menssage: String
)