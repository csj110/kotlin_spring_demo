package com.example.demo.service

import com.example.demo.annotation.AuthGuard
import com.example.demo.entity.ArticleEntity
import com.example.demo.repository.UserRepo
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ArticleServiceTest() {
    @Autowired
    lateinit var articleService: ArticleService

    @Autowired
    lateinit var userRepo: UserRepo

    @Test
    fun getArticleById() {
        val article = articleService.getArticleById(1)
        assert(article.isEmpty)
    }

    @Test
    fun createNewArticle() {
        val articleDto = ArticleEntity(title = "My Article")
        val creator = userRepo.findById(1).orElseThrow()
        articleDto.author = creator
        val article = articleService.createNewArticle(articleDto)
        assert(article.id != -1L)
    }
}