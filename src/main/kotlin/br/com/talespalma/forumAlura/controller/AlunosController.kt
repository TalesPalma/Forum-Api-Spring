package br.com.talespalma.forumAlura.controller

import br.com.talespalma.forumAlura.service.AlunosServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/alunos")
class AlunosController(private val alunosServices: AlunosServices){

    @GetMapping
    fun alunos() = alunosServices.getAll()

    @GetMapping("/{id}")
    fun buscaAlunos(@PathVariable id: Int) = alunosServices.getById(id)

}