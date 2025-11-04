package com.example.kotlinkoans.conventions

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}
fun main() {
    val a = MyDate(2000, 9, 5)
    val b = MyDate(2000, 9, 10)
    test(a, b)
}