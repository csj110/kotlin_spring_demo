package com.example.demo.entity

import javax.persistence.*

@Entity(name = "user")
class UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,
        @Column(nullable = false, length = 11)
        val phone: String = "",

        @OneToMany()
        @JoinColumn(name = "author_id", referencedColumnName = "id")
        val opus: List<ArticleEntity> = listOf()
)

