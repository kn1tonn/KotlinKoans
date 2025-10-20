package com.example.kotlinkoans.introduction

fun containsEven(collection: Collection<Int>): Boolean =
    collection.any { it % 2 == 0 }

fun main() {
    val a = listOf<Int>(1, 2, 3)
    println(containsEven(a))
}