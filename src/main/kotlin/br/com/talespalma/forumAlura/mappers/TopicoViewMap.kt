package br.com.talespalma.forumAlura.mappers

import br.com.talespalma.forumAlura.DTO.TopicoView
import br.com.talespalma.forumAlura.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMap: Mapper<Topico, TopicoView> {
    override fun map(t: Topico): TopicoView {
        return TopicoView(t.id, t.titulo, t.mensagem, t.status, t.dataCriacao)
    }
}