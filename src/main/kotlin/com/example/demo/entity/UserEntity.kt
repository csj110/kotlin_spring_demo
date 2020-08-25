package com.example.demo.entity

import com.fasterxml.jackson.annotation.JsonView
import javax.persistence.*

@Entity(name = "user")
class UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,
        @Column(nullable = false, length = 11,unique = true)
        val phone: String = "",

        @OneToMany()
        @JoinColumn(name = "author_id", referencedColumnName = "id")
        val opus: List<ArticleEntity> = listOf(),
        @OneToMany
        @JoinColumn(name = "commentator_id",referencedColumnName = "id")
        val comments:List<ArticleCommentEntity> = listOf()
)

