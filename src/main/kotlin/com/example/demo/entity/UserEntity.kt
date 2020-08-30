package com.example.demo.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "user")
class UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = -1,
        @Column(nullable = false, length = 11,unique = true)
        val phone: String = "",

        @JsonIgnore
        @OneToMany(fetch = FetchType.LAZY)
        @JoinColumn(name = "author_id", referencedColumnName = "id")
        val opus: List<ArticleEntity> = listOf(),
        @JsonIgnore
        @OneToMany(fetch = FetchType.LAZY)
        @JoinColumn(name = "commentator_id",referencedColumnName = "id")
        val comments:List<ArticleCommentEntity> = listOf()
)
