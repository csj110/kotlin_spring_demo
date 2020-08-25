package com.example.demo.exception

class NotAuthorized(override val message:String) : RuntimeException(message)