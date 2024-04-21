package br.com.talespalma.forumAlura.service

import br.com.talespalma.forumAlura.DTO.TopicoDTO
import br.com.talespalma.forumAlura.mappers.TopicoViewMap
import br.com.talespalma.forumAlura.model.Topico
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

    fun cadrastarPergunta(topicoDTO: TopicoDTO) {
        listTopicos.addFirst(
            topicoDTO.toTopico(
                cursoServices = cursoServices,
                id = listTopicos.size.plus(1).toLong(),
                usuarioService = usuarioService
            )
        )
    }


}