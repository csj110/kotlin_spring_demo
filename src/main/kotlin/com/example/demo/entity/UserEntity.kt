package com.example.demo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id:Long=-1,
        val name:String="",
        val phone:String=""
)
