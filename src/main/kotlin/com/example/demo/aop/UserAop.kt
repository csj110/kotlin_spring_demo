package com.example.demo.aop

import com.example.demo.annotation.AuthGuard
import com.example.demo.dto.AuthCodeDto
import com.example.demo.repository.UserRepo
import com.example.demo.utils.JwtUtil
import lombok.extern.log4j.Log4j
import org.aopalliance.intercept.Joinpoint
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service


//@Aspect
//@Service
//class UserAop(val userRepo: UserRepo, val jwtUtil: JwtUtil) {
//
//    @Pointcut("@annotation(com.example.demo.annotation.AuthGuard)")
//    fun userCheck() {
//    }
//
//    @Before("userCheck() && @annotation(guard)")
//    fun beforeUserCheck(joinPoint: JoinPoint,guard: AuthGuard) {
////        val request = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request
////        val authHeaderArray =request.getHeader("Authentication").split(" ")
////        if (authHeaderArray.size != 2) {
////            throw Exception("not auth")
////        }
////        val id= jwtUtil.validateToken(authHeaderArray[1])
////        request.setAttribute("userId",id)
//    }
//}