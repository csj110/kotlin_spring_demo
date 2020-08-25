package com.example.demo.exceptionAdvice

import com.example.demo.dto.ResFailObj
import com.example.demo.exception.NotAuthorized
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
@ResponseBody
class ExceptionAdvice {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(NotAuthorized::class)
    fun noAuthorization(e:NotAuthorized):ResFailObj{
        println(e.message)
        println(e.localizedMessage)
        return ResFailObj(message = e.message)
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception::class)
    fun defaultError(e:Exception):ResFailObj{
        return ResFailObj(message = e.message.orEmpty())
    }
}