package com.example.demo.service

import com.example.demo.dto.LoginDto
import com.example.demo.entity.UserEntity
import com.example.demo.repository.UserRepo
import com.example.demo.utils.JwtUtil
import org.springframework.stereotype.Service

@Service
class UserService(val userRepo: UserRepo,val jwtUtil: JwtUtil) {
    fun login(loginDto: LoginDto):String{
       val user= userRepo.findByPhone(loginDto.phone).orElseGet{
           userRepo.save<UserEntity>(UserEntity(phone = loginDto.phone))
        }
        return jwtUtil.genToken(user)
    }
}
