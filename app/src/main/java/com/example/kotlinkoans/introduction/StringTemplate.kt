package com.example.kotlinkoans.introduction

val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String = """\d{2}\.$month\.\d{4}"""

fun main() {
    val regex = Regex(getPattern())
    val myDate = "13.JUN.1992"
    println(myDate.matches(regex))
}