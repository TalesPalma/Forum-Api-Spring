package br.com.talespalma.forumAlura.controller

import br.com.talespalma.forumAlura.DTO.AtualizarTopicos
import br.com.talespalma.forumAlura.DTO.TopicoDTO
import br.com.talespalma.forumAlura.DTO.TopicoView
import br.com.talespalma.forumAlura.model.Topico
import br.com.talespalma.forumAlura.service.TopicoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI


@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {


    @GetMapping()
    fun topico(): List<TopicoView> = topicoService.retornarTopicos()

    @GetMapping("/{id}")
    fun topicoById(@PathVariable id: Long) = topicoService.returnById(id)


    @PostMapping
    fun cadrastarPergunta(
        @RequestBody @Valid topicoDTO: TopicoDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ResponseEntity<Topico>> {
        val serviceCriado = topicoService.cadrastarPergunta(topicoDTO)
        val uri = uriBuilder.path("/topicos/${serviceCriado.body?.id}").build().toUri()
        return ResponseEntity.created(uri).body(serviceCriado)
    }


    @PutMapping
    fun atualizarTopico(@RequestBody @Valid topico: AtualizarTopicos):ResponseEntity<Topico> {
        val serviceCriado = topicoService.atualizarTopico(topico)
        return ResponseEntity.ok(serviceCriado)
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletarTopico(@PathVariable id: Long){
        topicoService.removerTopico(id)
    }


}