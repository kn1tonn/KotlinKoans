package com.example.kotlinkoans.classes

fun sealedEval(expr: sealedExpr): Int =
    when (expr) {
        is sealedNum -> expr.value
        is sealedSum -> sealedEval(expr.left) + sealedEval(expr.right)
    }

sealed interface sealedExpr
class sealedNum(val value: Int) : sealedExpr
class sealedSum(val left: sealedExpr, val right: sealedExpr) : sealedExpr