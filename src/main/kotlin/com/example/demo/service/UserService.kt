package com.example.demo.service

import com.example.demo.repository.UserRepo
import org.springframework.stereotype.Service

@Service
class UserService(val userRepo: UserRepo) {

}
