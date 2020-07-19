package com.example.demo.repository

import com.example.demo.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepo : JpaRepository<UserEntity, Long> {
    fun findByPhone(phone:String):Optional<UserEntity>
}