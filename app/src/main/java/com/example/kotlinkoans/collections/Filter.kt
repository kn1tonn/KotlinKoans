package com.example.kotlinkoans.collections

// Find all the different cities the customers are from
fun Shop.getCustomerCities(): Set<City> =
    customers.map { it.city }.toSet()

// Find the customers living in a given city
fun Shop.getCustomersFrom(city: City): List<Customer> =
    customers.filter { city == it.city }

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

    val customerCity = shop.getCustomerCities()
    val customersFrom = shop.getCustomersFrom(tokyo)

    println(customerCity)
    println(customersFrom)
}