package com.example.demo.service

import com.example.demo.dto.PhoneDto
import com.example.demo.entity.UserEntity
import com.example.demo.repository.UserRepo
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(val userRepo: UserRepo) {
    fun findByPhone(phone:String):Optional<UserEntity>{
      return userRepo.findByPhone(phone)
    }

}
