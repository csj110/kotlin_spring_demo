package com.example.demo.repository

import com.example.demo.entity.UserEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface UserRepo : JpaRepository<UserEntity, Long> {

    fun findByPhone(phone:String):Optional<UserEntity>

    @Query(name="findByIdPure",nativeQuery = true,value ="select id,phone from user where id = :id")
    fun findByIdPure(@Param("id") id:Long):Optional<UserEntity>

    fun findAllByPhoneStartsWith(phone: String,pageable: Pageable):List<UserEntity>

}