package com.example.demo.repository

import com.example.demo.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepo : JpaRepository<User, Long> {
    override fun findById(id: Long): Optional<User>
}