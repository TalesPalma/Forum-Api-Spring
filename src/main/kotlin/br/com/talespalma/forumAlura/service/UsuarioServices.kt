package br.com.talespalma.forumAlura.service

import br.com.talespalma.forumAlura.model.Usuario
import org.springframework.stereotype.Service


@Service
class UsuarioServices(private var usuarios:List<Usuario>){

    init {
        usuarios = List(10){
            Usuario(
                id = it.toLong(),
                nome = "Kotlin $it",
                email = "email $it"
            )
        }
    }


    fun buscarPorId(idCurso: Long): Usuario  = usuarios.first{ it.id == idCurso}

}
