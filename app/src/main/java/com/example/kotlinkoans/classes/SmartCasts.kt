package com.example.kotlinkoans.classes

fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value
        is Sum -> eval(expr.left) + eval(expr.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun main() {
    val a = Num(1)
    val b = Num(3)
    val c = Sum(a, b)
    println(eval(a))
    println(eval(c))
}