package com.example.demo.service

import lombok.extern.slf4j.Slf4j
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class CaptchaService(val redisTemplate: RedisTemplate<String, String>) {

    fun genAuthCode(phone: String, type: String = "au") {
        val code = (10000..19999).random().toString().substring(1)
        redisTemplate.opsForValue().set("${phone}:${type}", code, Duration.ofMinutes(10))
    }

    fun validateCode(phone: String, code: String, type: String = "au"): Boolean {
        val value = redisTemplate.opsForValue().get("${phone}:${type}")
        return value == code
    }

}