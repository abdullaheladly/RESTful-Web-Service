package com.abdullah996.rest.webservices.restfulwebservices.exception

import com.abdullah996.rest.webservices.restfulwebservices.users.UserNotFoundException
import com.abdullah996.rest.webservices.restfulwebservices.users.posts.PostNotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.method.MethodValidationException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime


@ControllerAdvice
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {


    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(
            LocalDateTime.now(),
            ex.message ?: "Internal Server Error",
            request.getDescription(false)
        )

        return ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR)
    }



    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(ex: Exception, request: WebRequest): ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(
            LocalDateTime.now(),
            ex.message?:"User Not Found", request.getDescription(false)
        )

        return ResponseEntity(errorDetails, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(PostNotFoundException::class)
    fun handlePostNotFoundException(ex: Exception, request: WebRequest): ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(
            LocalDateTime.now(),
            ex.message?:"Post Not Found", request.getDescription(false)
        )

        return ResponseEntity(errorDetails, HttpStatus.NOT_FOUND)
    }

    @Override
    override fun handleMethodValidationException(
        ex: MethodValidationException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any>? {
        val errorDetails = ErrorDetails(
            LocalDateTime.now(),
            ex.message?:"", request.getDescription(false)?:""
        )

        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }

}