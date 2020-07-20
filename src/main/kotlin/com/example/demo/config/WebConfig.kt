package com.example.demo.config

import com.example.demo.interceptor.JwtAuthInterceptor
import com.example.demo.repository.UserRepo
import com.example.demo.resolver.UserResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig(val jwtAuthInterceptor: JwtAuthInterceptor,val userResolver: UserResolver) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(jwtAuthInterceptor)
                .addPathPatterns(listOf("/user/*"))
                .excludePathPatterns(listOf("/auth/*"))
        super.addInterceptors(registry)
    }

    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        resolvers.add(userResolver)
        super.addArgumentResolvers(resolvers)
    }
}