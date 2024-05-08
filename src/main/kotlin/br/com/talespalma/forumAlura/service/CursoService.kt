package br.com.talespalma.forumAlura.service

import br.com.talespalma.forumAlura.model.Curso
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class CursoService(private var cursos: List<Curso>) {
    init {
        cursos = List<Curso>(10) {
            Curso(
                id = it.toLong(),
                nome = "Kotlin $it",
                categoria = "Programação"
            )
        }
    }

    fun buscarPorId(id: Long): ResponseEntity<Curso> {
        val cursosFilter = cursos.find { it.id == id } ?: Curso()
        return ResponseEntity.status(HttpStatus.OK).body(cursosFilter)
    }

    fun retornarCursos(): ResponseEntity<List<Curso>> {
        return ResponseEntity.status(HttpStatus.OK).body(cursos)
    }

    fun returnById(id: Long): ResponseEntity<List<Curso>> {
        return ResponseEntity.status(HttpStatus.OK).body(cursos.filter { it.id == id })
    }


}
