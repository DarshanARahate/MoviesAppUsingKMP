package com.movies.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform