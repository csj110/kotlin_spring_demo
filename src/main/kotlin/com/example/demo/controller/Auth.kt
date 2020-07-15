package com.example.demo.controller

import com.example.demo.dto.LoginDto
import com.example.demo.dto.ResObj
import com.example.demo.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@Controller("auth")
class Auth(val userService: UserService) {

    @PostMapping("login")
    fun login(@RequestBody loginDto: LoginDto){

    }

}