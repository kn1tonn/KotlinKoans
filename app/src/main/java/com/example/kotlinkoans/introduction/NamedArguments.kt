package com.example.kotlinkoans.introduction

fun joinOptions(options: Collection<String>) =
    options.joinToString(
        prefix = "[",
        postfix = "]",
    )

fun main() {
    val a = listOf<String>("a", "b", "c")
    println(joinOptions(a))
}
