package com.example.demo.dto


data class LoginDto(val phone: String, val code: String="****")

data class AuthCodeDto(val phone: String)

data class ResObj(
        val code: Int = 200,
        val success:Boolean=true,
        val message: String = "",
        val data: Any = ""
)

data class ResFailObj(val code:Int=500,
                      val success:Boolean=false,
                      val message: Any="失败"
)