package com.example.demo.entity

import javax.persistence.*

@Entity
class UserEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id:Long=-1,
        @Column
        val phone:String=""
)

