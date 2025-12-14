package com.example.kotlinkoans.properties

class LazyProperty(val initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}