package com.example.demo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
class User (
        @javax.persistence.Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id:Long=-1,
        val name:String=""
)

