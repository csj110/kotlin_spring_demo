package com.example.demo.controller

import com.example.demo.annotation.AuthGuard
import com.example.demo.annotation.CurrentUser
import com.example.demo.dto.ResObj
import com.example.demo.entity.UserEntity
import com.example.demo.repository.UserRepo
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user")
class User(val userRepo: UserRepo) {

    @GetMapping("info")
    fun getPhoneNumber(@CurrentUser user: UserEntity): ResObj {
        return ResObj(data = user)
    }

    @GetMapping("all")
    fun getAllUser(): ResObj {
        val users=userRepo.findAllByPhoneStartsWith(phone = "1",pageable = PageRequest.of(1,3, Sort.by(listOf(Sort.Order.asc("id")))))
        return ResObj(data=users)
    }
    @AuthGuard
    @PostMapping("new")
    fun createUser(@RequestBody() user:UserEntity):ResObj{
        val user =userRepo.save(user)
        return ResObj(data = user)
    }
}

