package com.example.demo.service

import com.example.demo.entity.ArticleEntity
import com.example.demo.repository.ArticleRepo
import org.springframework.stereotype.Service

@Service
class ArticleService(val articleRepo: ArticleRepo) {


    fun getArticleById(id : Long):ArticleEntity{
        return articleRepo.getOne(id)
    }

    fun createNewArticle(articleEntity: ArticleEntity):ArticleEntity{
        return articleRepo.saveAndFlush(articleEntity)
    }
}