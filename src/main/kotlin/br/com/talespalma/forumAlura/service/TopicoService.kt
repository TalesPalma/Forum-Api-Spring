package br.com.talespalma.forumAlura.service

import br.com.talespalma.forumAlura.DTO.AtualizarTopicos
import br.com.talespalma.forumAlura.DTO.TopicoDTO
import br.com.talespalma.forumAlura.DTO.TopicoView
import br.com.talespalma.forumAlura.exceptions.NotFoundException
import br.com.talespalma.forumAlura.mappers.TopicoViewMap
import br.com.talespalma.forumAlura.model.Topico
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class TopicoService(
    private var listTopicos: MutableList<Topico>,
    private val cursoServices: CursoService,
    private val usuarioService: UsuarioServices,
    private val topicoViewMap: TopicoViewMap,
) {

    fun retornarTopicos() = listTopicos.map {
        topicoViewMap.map(it)
    }.sortedBy { it.id }


    fun returnById(id: Long) = listTopicos.filter { it.id == id }.map {
        topicoViewMap.map(it)
    }

    fun cadrastarPergunta(topicoDTO: TopicoDTO): ResponseEntity<Topico> {
        val topicoView = topicoDTO.toTopico(
            cursoServices = cursoServices,
            id = listTopicos.size.plus(1).toLong(),
            usuarioService = usuarioService
        )
        listTopicos.addFirst(topicoView)
        return ResponseEntity.ok().body(topicoView)
    }

    fun atualizarTopico(topico: AtualizarTopicos): Topico {
        val topicoAnterior = listTopicos.filter { it.id == topico.id }.first()
        listTopicos.removeIf { it.id == topico.id }
        val newTopico =  Topico(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.menssage,
            autor = topicoAnterior.autor,
            curso = topicoAnterior.curso
        )
        listTopicos.addFirst(newTopico)
        return newTopico
    }

    fun removerTopico(id: Long) {
            listTopicos.removeIf { it.id == id}.let {
                if(!it) throw NotFoundException("Topico não encontrado")
            }
    }
}