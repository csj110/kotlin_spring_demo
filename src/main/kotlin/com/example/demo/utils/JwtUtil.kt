package com.example.demo.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.example.demo.entity.UserEntity
import com.example.demo.exception.NotAuthorized
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtUtil(@Value("\${jwt.secret}") val secret: String) {

    val jwtVerifier: JWTVerifier = JWT.require(Algorithm.HMAC256(secret)).build()

    fun genToken(user: UserEntity): String {
        val timeStamp = System.currentTimeMillis()
        val createTime = Date(timeStamp)
        val expireTime = Date(timeStamp + 2 * 60 * 60 * 1000)
        return JWT.create().withClaim("id", user.id).withIssuedAt(createTime).withExpiresAt(expireTime).sign(Algorithm.HMAC256(secret))
    }

    fun validateToken(token: String): Long =jwtVerifier.verify(token).getClaim("id").asLong().or(0)

    fun extractIdFromRequest(request: HttpServletRequest) :Long{
        val authHeaderArray = request.getHeader("Authorization").orEmpty().split("Bearer ")
        if (authHeaderArray.size != 2) {
            throw NotAuthorized("need Bearer Authentication")
        }
        return validateToken(authHeaderArray[1])
    }

}