package com.example.demo.service

import com.example.demo.dto.LoginDto
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class UserServiceTest {
    @Autowired
    lateinit var userService: UserService

    @Test
    fun login() {
        val token = userService.login(LoginDto("13486827301", code = "1252"))
        println(token)
    }
}