package br.com.talespalma.forumAlura.service

import br.com.talespalma.forumAlura.DTO.TopicoDTO
import br.com.talespalma.forumAlura.model.StatusTopicos
import br.com.talespalma.forumAlura.model.Topico
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class TopicoService(
    private var listTopicos: MutableList<Topico>,
    private val cursoServices: CursoService,
    private val usuarioService: UsuarioServices
) {



    init {
        listTopicos = MutableList<Topico>(10) {
            Topico(
                id = it.toLong(),
                titulo = "Kotlin $it",
                mensagem = "$it Kotlin é uma linguagem de programação",
                status = StatusTopicos.NAO_RESPONDIDO,
                dataCriacao = LocalDateTime.now()
            )
        }
        listTopicos.addLast(
            Topico(
                id = 1,
                titulo = "Kotlin 10",
                mensagem = "10 Kotlin é uma linguagem de programação",
                status = StatusTopicos.NAO_RESPONDIDO,
                dataCriacao = LocalDateTime.now()
            )
        )
    }


    fun retornarTopicos() = listTopicos

    fun returnById(id: Long) = listTopicos.filter { it.id == id }

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