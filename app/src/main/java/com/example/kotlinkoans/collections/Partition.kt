package com.example.kotlinkoans.collections

// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
    customers.filter { val (delivered, undelivered) =
        it.orders.partition { it.isDelivered }
        undelivered.size > delivered.size
    }.toSet()

fun main() {
    val tokyo = City("Tokyo")
    val osaka = City("Osaka")
    val nagoya = City("Nagoya")

    val milk = Product("Milk", 1.5)
    val bread = Product("Bread", 2.0)
    val coffee = Product("Coffee", 3.5)

    val order1 = Order(listOf(milk, bread), isDelivered = true)
    val order2 = Order(listOf(coffee), isDelivered = false)

    val customer1 = Customer("Alice", tokyo, listOf(order1))
    val customer2 = Customer("Bob", osaka, listOf(order2))
    val customer3 = Customer("Jim", nagoya, listOf(order1))

    val shop = Shop("Kotlin Store", listOf(customer1, customer2, customer3))

    val getCustomersWithMoreUndeliveredOrders = shop.getCustomersWithMoreUndeliveredOrders()

    println(getCustomersWithMoreUndeliveredOrders)
}