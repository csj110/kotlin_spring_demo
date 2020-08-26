package com.example.demo.aop

import com.example.demo.annotation.AuthGuard
import com.example.demo.exception.NotAuthorized
import com.example.demo.utils.JwtUtil
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes


@Aspect
@Order(10)
@Service
class UserAop(val jwtUtil: JwtUtil) {

    @Pointcut("@annotation(com.example.demo.annotation.AuthGuard)")
    fun userCheck() {
    }

    @Before("userCheck() && @annotation(guard)")
    fun beforeUserCheck(joinPoint: JoinPoint, guard: AuthGuard) {
        print("start aop")
        val request = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request
        val id = jwtUtil.validateRequest(request)
        if (guard.value != "" && id != guard.value.toLong()){
            throw NotAuthorized("user has no access")
        }
        request.setAttribute("userId", id)
    }
}