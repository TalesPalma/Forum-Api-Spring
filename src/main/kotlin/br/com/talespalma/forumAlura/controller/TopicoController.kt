package br.com.talespalma.forumAlura.controller

import br.com.talespalma.forumAlura.DTO.TopicoDTO
import br.com.talespalma.forumAlura.model.Topico
import br.com.talespalma.forumAlura.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {


    @GetMapping()
    fun topico() = topicoService.retornarTopicos()

    @GetMapping("/{id}")
    fun topicoById(@PathVariable id:Long) = topicoService.returnById(id)

    @PostMapping
    fun cadastrar(@RequestBody topico:TopicoDTO) = topicoService.cadrastarPergunta(topico)

}