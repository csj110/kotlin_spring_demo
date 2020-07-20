package com.example.demo.controller

import com.example.demo.annotation.CurrentUser
import com.example.demo.entity.UserEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class User {
    @GetMapping("info")
    fun getPhoneNumber(@CurrentUser user:UserEntity){
        println("faffaf")
        println(user.phone)
    }

}