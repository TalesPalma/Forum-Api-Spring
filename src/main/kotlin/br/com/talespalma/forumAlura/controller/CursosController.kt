package br.com.talespalma.forumAlura.controller

import br.com.talespalma.forumAlura.DTO.TopicoDTO
import br.com.talespalma.forumAlura.service.CursoService
import br.com.talespalma.forumAlura.service.TopicoService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/cursos")
class CursosController(private val cursoService: CursoService) {


    @GetMapping()
    fun topico() = cursoService.retornarCursos()

    @GetMapping("/{id}")
    fun topicoById(@PathVariable id: Long) = cursoService.returnById(id)

}
