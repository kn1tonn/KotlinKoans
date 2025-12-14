package com.example.kotlinkoans.properties

class PropertyExample() {
    var counter = 0
    var propertyWithCounter: Int? = null
        set(value) {
            field = value
            counter++
        }
}

fun main(){
    val ex = PropertyExample()
    println("初期値 ${ex.counter} ")
    ex.propertyWithCounter = 10
    println("counter: ${ex.counter}")
    println("propertyWithCounter: ${ex.propertyWithCounter}")

    ex.propertyWithCounter = 20
    println("counter: ${ex.counter}")
    println("propertyWithCounter: ${ex.propertyWithCounter}")

    ex.propertyWithCounter = 30
    println("counter: ${ex.counter}")
    println("propertyWithCounter: ${ex.propertyWithCounter}")
}