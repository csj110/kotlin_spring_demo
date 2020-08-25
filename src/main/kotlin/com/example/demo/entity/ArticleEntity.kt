package com.example.demo.entity


import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity(name = "article")
class ArticleEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,
        @Column(nullable = false)
        val title: String = "",

        @CreationTimestamp
        val created: Date = Date(),
        @UpdateTimestamp
        val updated: Date = Date(),

        @ManyToOne
        @JoinColumn(name = "author_id", referencedColumnName = "id")
        val author: UserEntity = UserEntity(),
        @OneToMany
        @JoinColumn(name = "commentFor_id", referencedColumnName = "id")
        val comments: List<ArticleCommentEntity> = listOf()
)