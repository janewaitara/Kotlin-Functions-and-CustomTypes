package lambdasAndHigherOrderFunctions

/**
 * For each dont return anything
 * map returns a collection , each iteration return an element that is added to the final returned collection
 * */
fun main() {


    val prices = arrayOf(1.50, 10.00, 4.99, 2.30, 8.19)

    //for loop
    for (price in prices) {
        print("$price \t")
    }

    println()

    //forEach
    prices.forEach { it
        print("$it \t")
    }
    println()

    prices.forEach(::println)

    val salePrices = mutableListOf<Double>()
    for (price in prices){
        salePrices.add(price * 0.9)
    }
    println(salePrices)

    //map
    val salePricesUsingmap = prices.map { price -> price * 0.9 }
    println(salePricesUsingmap)


    val userInput = listOf("meow!", "15", "37.5", "seven", "42")
    //map can be used to change the type
    val numbers = userInput.map {  it.toIntOrNull()}
    println(numbers)

    //filters the non null values
    val validInput = userInput.mapNotNull { it.toIntOrNull() }
    println(validInput)

}