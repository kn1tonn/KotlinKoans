package com.example.kotlinkoans.collections

import kotlin.collections.flatMap

fun doSomethingWithCollection(collection: Collection<String>): Collection<String>? {

    val groupsByLength = collection.groupBy { s -> s.length }

    val maximumSizeOfGroup = groupsByLength.values.map { group -> group.size }.maxOrNull()

    return groupsByLength.values.firstOrNull { group -> group.size == maximumSizeOfGroup }
}

fun main() {
    val collection = listOf("a", "bb", "ccc")

    println(doSomethingWithCollection(collection))
}