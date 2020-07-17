package com.example.demo.service

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class CaptchaService(val redisTemplate: RedisTemplate<String, String>) {
    fun genLoginCode(phone: String) {
        val key = "${phone}:lo"
        val code = (10000..19999).random().toString().substring(1)
        redisTemplate.opsForValue().set(key, code, Duration.ofMinutes(10))
    }

    fun validateCode(phone: String, code: String, type: String = "lo"):Boolean {
        val key = "${phone}:${type}"
        val codeCached = redisTemplate.opsForValue().get(key).orEmpty()
        return codeCached==code
    }

}