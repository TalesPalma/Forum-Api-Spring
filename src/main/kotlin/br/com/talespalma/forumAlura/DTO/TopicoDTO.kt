package br.com.talespalma.forumAlura.DTO

import br.com.talespalma.forumAlura.model.Curso
import br.com.talespalma.forumAlura.model.Topico
import br.com.talespalma.forumAlura.service.CursoService
import br.com.talespalma.forumAlura.service.UsuarioServices

data class TopicoDTO(
    val titulo: String,
    val menssage: String,
    val idCurso: Long,
    val idAuthor: Long
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

