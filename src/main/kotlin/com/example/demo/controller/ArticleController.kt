package com.example.demo.controller

import com.example.demo.annotation.CurrentUser
import com.example.demo.dto.ResObj
import com.example.demo.entity.ArticleEntity
import com.example.demo.entity.UserEntity
import com.example.demo.service.ArticleService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("article")
class ArticleController(val articleService: ArticleService) {

    @GetMapping("/{id}")
    fun getArticle(@PathVariable("id") articleId :Long):ResObj{
        val article = articleService.getArticleById(articleId)
        return ResObj(data = article)
    }


    @PostMapping("")
    fun creteArticle(@RequestBody article: ArticleEntity,@CurrentUser user:UserEntity):ResObj{
        val newArticle = articleService.createNewArticle(article.copy(author = user))
        return ResObj(data = newArticle)
    }
}