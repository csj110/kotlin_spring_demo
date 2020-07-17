package com.example.demo.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.demo.entity.UserEntity
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtil() {
    @Value("\${jwt.secret}")
    lateinit var jwtSecret:String

    @Value("\${jwt.expireTime}")
    lateinit var expireTime:String

   fun generateJwtToken(user: UserEntity):String{
      val timestamp=System.currentTimeMillis()
       val creteTime = Date(timestamp)
       val expiredTime =Date(timestamp + expireTime.toLong())
      return JWT.create()
               .withClaim("id",user.id)
               .withIssuedAt(creteTime)
               .withExpiresAt(expiredTime)
               .sign(Algorithm.HMAC256(jwtSecret))
   }
}