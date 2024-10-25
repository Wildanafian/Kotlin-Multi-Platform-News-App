package com.wildan.newsappkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform