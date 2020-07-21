package com.example.demo.repository

import com.example.demo.entity.ArticleCommentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleCommentRepo:JpaRepository<ArticleCommentEntity,Long> {
}