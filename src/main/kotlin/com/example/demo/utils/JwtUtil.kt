package com.example.demo.utils

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component
class RedisUtil(redisTemplate: RedisTemplate<String,String>) {

}