package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.io.Serializable

@Configuration
class RedisConfig {
    @Bean
    fun redisTemplate(factory:RedisConnectionFactory) :RedisTemplate<String,Serializable>{
        val template=RedisTemplate<String,Serializable>()
        template.setConnectionFactory(factory)
        val strSerializable=StringRedisSerializer()
        template.stringSerializer= strSerializable
        template.keySerializer=strSerializable
        template.valueSerializer=GenericJackson2JsonRedisSerializer()
        return  template
    }
}