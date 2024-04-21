package br.com.talespalma.forumAlura.controller

import br.com.talespalma.forumAlura.DTO.TopicoDTO
import br.com.talespalma.forumAlura.DTO.TopicoView
import br.com.talespalma.forumAlura.service.TopicoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {


    @GetMapping()
    fun topico(): List<TopicoView> = topicoService.retornarTopicos()

    @GetMapping("/{id}")
    fun topicoById(@PathVariable id: Long) = topicoService.returnById(id)

    @PostMapping
    fun cadastrar(@RequestBody @Valid topico: TopicoDTO) = topicoService.cadrastarPergunta(topico)

}