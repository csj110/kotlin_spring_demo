package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfig {
    @Bean
    fun redisTemplate(factory:RedisConnectionFactory) :RedisTemplate<String,String>{
        val template=RedisTemplate<String,String>()
        template.setConnectionFactory(factory)
        val serializer=StringRedisSerializer()
        template.keySerializer=serializer
        template.valueSerializer=serializer
        template.stringSerializer= serializer
        return  template
    }
}