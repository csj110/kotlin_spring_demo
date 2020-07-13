package com.example.demo.dto

data class LoginDto(val username:String,val password:String)

data class ResObj(val code: Int = 200, val message: String = "", val data: Any = "")