package com.example.demo.dto

data class LoginDto(val phone: String, val code: String="****")

data class AuthCodeDto(val phone: String)

data class ResObj(val code: Int = 200, val message: String = "", val data: Any = "")