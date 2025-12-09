package com.example.kotlinkoans.collections

// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> =
     orders.flatMap { it.products }

// Return all products that were ordered by at least one customer
fun Shop.getOrderedProducts(): Set<Product> =
    customers.flatMap { it.getOrderedProducts() }.toSet()

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

    val orderedInShop = shop.getOrderedProducts()

    println(orderedInShop)
}