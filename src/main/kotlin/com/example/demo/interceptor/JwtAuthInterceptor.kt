package com.example.demo.interceptor

import com.example.demo.utils.JwtUtil
import org.springframework.stereotype.Component

import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthInterceptor( val jwtUtil: JwtUtil) : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val authHeaderArray = request.getHeader("Authorization").split("Bearer ")
        if (authHeaderArray.size != 2) {
            response.sendError(401, "need auth token")
            return false
        }
        val id= jwtUtil.validateToken(authHeaderArray[1])
        request.setAttribute("userId",id)
        return true
    }
}