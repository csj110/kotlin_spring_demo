package com.example.demo.repository

import com.example.demo.entity.ArticleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepo:JpaRepository<ArticleEntity,Long> {

}