package br.com.talespalma.forumAlura.service

import br.com.talespalma.forumAlura.model.Curso
import org.springframework.stereotype.Service


@Service
class CursoService(private var cursos:List<Curso>){
    init {
        cursos = List<Curso>(10){
            Curso(
                id = it.toLong(),
                nome = "Kotlin $it",
                categoria = "Programação"
            )
        }
    }

    fun buscarPorId(id:Long):Curso = cursos.find { it.id == id } ?: Curso()
    fun retornarCursos(): List<Curso>  = cursos
    fun returnById(id: Long) = cursos.filter { it.id == id }


}
