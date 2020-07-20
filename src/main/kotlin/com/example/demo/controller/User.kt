package com.example.demo.controller

import com.example.demo.annotation.CurrentUser
import com.example.demo.dto.ResObj
import com.example.demo.entity.UserEntity
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class User {
    @GetMapping("info")
    fun getPhoneNumber(@CurrentUser user:UserEntity):ResObj{

        return ResObj(data = user.phone)
    }

}