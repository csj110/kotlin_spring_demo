package com.example.demo.dto

data class LoginDto(val phone:String,val captcha:String)
data class PhoneDto(val phone:String)
data class ResObj(val code: Int = 200, val message: String = "", val data: Any = "")
data class JwtRes(val token:String)