package com.example.demo.controller

import com.example.demo.dto.AuthCodeDto
import com.example.demo.dto.LoginDto
import com.example.demo.dto.ResObj
import com.example.demo.service.CaptchaService
import com.example.demo.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("auth")
class Auth(val userService: UserService, val captchaService: CaptchaService) {

    @PostMapping("login")
    fun login(@RequestBody loginDto: LoginDto): ResObj {
        if (!captchaService.validateCode(loginDto.phone, loginDto.code)) throw  Exception("code 无效")
        val token = userService.login(loginDto)
        return ResObj(data = mapOf("token" to token))
    }

    @PostMapping("captcha/login")
    fun genAuthCode(@RequestBody authCodeDto: AuthCodeDto): ResObj {
        captchaService.genAuthCode(authCodeDto.phone)
        return ResObj(data = "success")
    }
}