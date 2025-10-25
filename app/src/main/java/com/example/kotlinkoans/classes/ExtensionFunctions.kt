package com.example.kotlinkoans.classes

fun Int.r(): RationalNumber = RationalNumber(this, 1)

fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)

data class RationalNumber(val numerator: Int, val denominator: Int)

fun main() {
    val a = 1
    val b = Pair(3, 4)
    println(a.r())
    println(b.r())
}