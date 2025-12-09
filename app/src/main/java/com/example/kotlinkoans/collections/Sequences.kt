package com.example.kotlinkoans.collections

// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBySequence(customer: Customer): Product? {
     return customer
         .orders
         .asSequence()
         .filter { it.isDelivered }
         .flatMap { it.products }
         .maxByOrNull{ it.price }
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
private fun Shop.getNumberOfTimesProductWasOrderedSequence(product: Product): Int {
    return customers
        .flatMap { it.getOrderedProductsSequence() }.count { it == product }
}

fun Customer.getOrderedProductsSequence(): Sequence<Product> =
    orders.asSequence().flatMap{ it.products }

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

    val findMostExpensiveProductBySequence = findMostExpensiveProductBySequence(customer1)
    val getNumberOfTimesProductWasOrderedSequence = shop.getNumberOfTimesProductWasOrderedSequence(milk)

    println(findMostExpensiveProductBySequence)
    println(getNumberOfTimesProductWasOrderedSequence)
}