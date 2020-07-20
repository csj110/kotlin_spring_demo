package com.example.demo.entity

import javax.persistence.*

@Entity
class UserEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id:Long=-1,
        @Column(nullable = false,length = 11)
        val phone:String=""
)

