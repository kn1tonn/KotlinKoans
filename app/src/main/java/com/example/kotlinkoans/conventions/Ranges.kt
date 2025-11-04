package com.example.kotlinkoans.conventions

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in first..last
}

fun main() {
    val a = MyDate(2000, 9, 7)
    val b = MyDate(2000, 9, 5)
    val c = MyDate(2000, 9, 10)
    println(checkInRange(a, b, c))
}