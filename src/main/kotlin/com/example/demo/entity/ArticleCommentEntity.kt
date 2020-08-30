package com.example.demo.entity

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity(name = "article_comment")
class ArticleCommentEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = -1,
        @Column(nullable = false)
        val comment: String = "",

        @CreationTimestamp
        val created: Date = Date(),

//        @ManyToOne(fetch = FetchType.LAZY)
//        @JoinColumn(name = "commentFor_id", referencedColumnName = "id")
//        val commentFor: ArticleEntity = ArticleEntity(),
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "commentator_id", referencedColumnName = "id")
        val commentator: UserEntity = UserEntity()
)
