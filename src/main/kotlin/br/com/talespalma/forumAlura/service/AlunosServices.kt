package br.com.talespalma.forumAlura.service

import br.com.talespalma.forumAlura.model.Alunos
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class AlunosServices(private var alunos:List<Alunos>){

    init {
        alunos = listOf(
            Alunos(
                id = alunos.size.plus(1),
                nome = "Tales",
                idade = 23,
                dataNascimento = LocalDateTime.now()
            ),
            Alunos(
                id = alunos.size.plus(2),
                nome = "Tales",
                idade = 23,
                dataNascimento = LocalDateTime.now()
            ),
            Alunos(
                id = alunos.size.plus(3),
                nome = "Tales",
                idade = 23,
                dataNascimento = LocalDateTime.now()
            )
        )
    }

    fun getAll(): List<Alunos>  = alunos



    fun getById(id: Int): List<Alunos>  = alunos.filter { it.id == id }

}
