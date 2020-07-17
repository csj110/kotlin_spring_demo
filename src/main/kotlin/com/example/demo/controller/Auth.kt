package com.example.demo.controller

import com.example.demo.dto.JwtRes
import com.example.demo.dto.LoginDto
import com.example.demo.dto.PhoneDto
import com.example.demo.dto.ResObj
import com.example.demo.service.CaptchaService
import com.example.demo.service.UserService
import com.example.demo.utils.JwtUtil
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("auth")
class Auth(val userService: UserService,val captchaService: CaptchaService,val jwtUtil: JwtUtil) {

    @PostMapping("login")
    fun login(@RequestBody loginDto: LoginDto):ResObj{
       val user= userService.findByPhone(loginDto.phone).orElseThrow()
       if( captchaService.validateCode(loginDto.phone,loginDto.captcha)){

       }
        return ResObj()
    }

    @PostMapping("captcha/login")
    fun genCode(@RequestBody() phoneDto: PhoneDto):ResObj{
        captchaService.genLoginCode(phoneDto.phone)
        return ResObj(message = "发送成功")
    }
}