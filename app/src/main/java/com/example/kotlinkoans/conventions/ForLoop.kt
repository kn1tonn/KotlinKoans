package com.example.kotlinkoans.conventions

class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var current = start
            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                val result = current
                current = current.followingDate()
                return result
            }
            override fun hasNext(): Boolean = current <= end
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}

fun main() {
    val a = MyDate(2000, 9, 5)
    val b = MyDate(2000, 9, 10)
    iterateOverDateRange(a, b) { date ->
        println(date)
    }
}