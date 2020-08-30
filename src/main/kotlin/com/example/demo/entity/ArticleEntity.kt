package com.example.demo.entity


import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity(name = "article")
data class ArticleEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = -1,
        @Column(nullable = false)
        val title: String = "",

        @JsonIgnore
        @CreationTimestamp
        val created: Date = Date(),
        @JsonIgnore
        @UpdateTimestamp
        val updated: Date = Date(),

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "author_id", referencedColumnName = "id")
        var author: UserEntity = UserEntity(),
        @OneToMany(fetch = FetchType.LAZY)
        @JoinColumn(name = "commentFor_id", referencedColumnName = "id")
        val comments: List<ArticleCommentEntity> = listOf()
)