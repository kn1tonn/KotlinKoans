package com.example.kotlinkoans.conventions

import java.util.Calendar


fun MyDate.addTimeIntervals(timeInterval: TimeInterval, amount: Int): MyDate {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)
    when (timeInterval) {
        TimeInterval.YEAR -> c.add(Calendar.YEAR, amount)
        TimeInterval.WEEK -> c.add(Calendar.WEEK_OF_YEAR, amount)
        TimeInterval.DAY  -> c.add(Calendar.DAY_OF_YEAR, amount)
    }
    return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))
}
enum class TimeInterval { DAY, WEEK, YEAR }

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)

operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)

operator fun MyDate.plus(timeInterval: RepeatedTimeInterval) = addTimeIntervals(timeInterval.timeInterval, timeInterval.number)


fun main() {
    val today = MyDate(2024, 10, 30)  // 月は 0 始まり（10月なら9）に注意
    println(task1(today))
    println(task2(today))
}

fun task1(today: MyDate): MyDate {
    return today + TimeInterval.YEAR + TimeInterval.WEEK
}

fun task2(today: MyDate): MyDate {
    return today + TimeInterval.YEAR * 2 + TimeInterval.WEEK * 3 + TimeInterval.DAY * 5
}