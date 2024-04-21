package br.com.talespalma.forumAlura.DTO

import br.com.talespalma.forumAlura.model.Curso
import br.com.talespalma.forumAlura.model.Topico
import br.com.talespalma.forumAlura.service.CursoService
import br.com.talespalma.forumAlura.service.UsuarioServices
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicoDTO(
    @field:NotEmpty @field:Size(max = 50, min = 5) val titulo: String,
    @field:NotEmpty val menssage: String,
    @field:NotNull val idCurso: Long,
    @field:NotNull val idAuthor: Long
) {
    fun toTopico(cursoServices: CursoService,id:Long,usuarioService: UsuarioServices) =
        Topico(
            id = id,
            titulo = titulo,
            mensagem = menssage,
            autor = usuarioService.buscarPorId(idCurso),
            curso = cursoServices.buscarPorId(idCurso)
        )
}

