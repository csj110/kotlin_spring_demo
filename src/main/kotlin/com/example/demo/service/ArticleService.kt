package com.example.demo.service

import com.example.demo.entity.ArticleEntity
import com.example.demo.repository.ArticleRepo
import org.springframework.stereotype.Service
import java.util.*

@Service
class ArticleService(val articleRepo: ArticleRepo) {


    fun getArticleById(id : Long):Optional<ArticleEntity>{
        return articleRepo.findById(id)
    }

    fun getArticleByAuthorId(id:Long):List<ArticleEntity>{
        return articleRepo.findByAuthor_Id(id)
    }

    fun createNewArticle(articleEntity: ArticleEntity):ArticleEntity{
        return articleRepo.save(articleEntity)
    }

}