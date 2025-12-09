package com.example.kotlinkoans.collections

// Build a map from the customer name to the customer
fun Shop.nameToCustomerMap(): Map<String, Customer> =
    customers.associateBy { it.name }

// Build a map from the customer to their city
fun Shop.customerToCityMap(): Map<Customer, City> =
     customers.associateWith { it.city }

// Build a map from the customer name to their city
fun Shop.customerNameToCityMap(): Map<String, City> =
    customers.associate { it.name to it.city }

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

    val nameToCustomerMap = shop.nameToCustomerMap()
    val customerToCityMap = shop.customerToCityMap()
    val customerNameToCity = shop.customerNameToCityMap()

    println(nameToCustomerMap)
    println(customerToCityMap)
    println(customerNameToCity)
}