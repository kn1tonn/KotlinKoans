package com.example.kotlinkoans.introduction

fun foo(name: String = "a", number: Int = 1, toUpperCase: Boolean = false) =
    (if (toUpperCase) name.uppercase() else name) + number

fun useFoo() = listOf(
    foo("a"),
    foo("b", number = 1),
    foo("c", toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)

fun main() {
    println(useFoo())
}