package com.example.demo.repository

import com.example.demo.entity.ArticleEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ArticleRepo:JpaRepository<ArticleEntity,Long> {
    fun findByAuthor_Id(authorId:Long): List<ArticleEntity>
}