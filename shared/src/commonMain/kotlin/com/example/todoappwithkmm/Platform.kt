package com.example.todoappwithkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform