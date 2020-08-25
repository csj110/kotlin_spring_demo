package com.example.demo.controller

import com.example.demo.dto.ResObj
import com.example.demo.entity.ArticleEntity
import com.example.demo.service.ArticleService
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping("article")
class ArticleController(val articleService: ArticleService) {
    @GetMapping("/:id")
    fun getArticle(@PathParam("id") articleId :Long):ResObj{
        val article = articleService.getArticleById(articleId)
        return ResObj(data = article)
    }

    @PostMapping("")
    fun creteArticle(@RequestBody articleEntity: ArticleEntity):ResObj{
        val newArticle = articleService.createNewArticle(articleEntity)
        return ResObj(data = newArticle)
    }
}