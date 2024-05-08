package br.com.talespalma.forumAlura.exceptions

import br.com.talespalma.forumAlura.DTO.ErrorView
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(exception: NotFoundException,request: HttpServletRequest): ErrorView {
        return ErrorView(
            message = exception.message,
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            path = request.servletPath
        )
    }
}