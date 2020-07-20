package com.example.demo.resolver

import com.example.demo.annotation.CurrentUser
import com.example.demo.entity.UserEntity
import com.example.demo.repository.UserRepo
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Service
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import javax.servlet.http.HttpServletRequest

@Service
class UserResolver(val userRepo: UserRepo) : HandlerMethodArgumentResolver {
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.hasParameterAnnotation(CurrentUser::class.java) && parameter.parameterType.isAssignableFrom(UserEntity::class.java)
    }

    override fun resolveArgument(parameter: MethodParameter, mavContainer: ModelAndViewContainer?, webRequest: NativeWebRequest, binderFactory: WebDataBinderFactory?): UserEntity {
        val id = webRequest.getNativeRequest(HttpServletRequest::class.java)?.getAttribute("id").toString().toLong()
        val a = userRepo.findById(id).orElse(UserEntity()).phone
        print(a)
        return userRepo.findById(id).orElseThrow { Exception("user does not exist") }
    }
}