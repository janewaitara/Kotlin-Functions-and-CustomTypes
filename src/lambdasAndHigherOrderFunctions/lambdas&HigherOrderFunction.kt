package lambdasAndHigherOrderFunctions

import sun.rmi.runtime.Log

fun main() {

    //have the ability to close over the variables and constants defined in their own scope
    //will access counter in the lambdasAndHigherOrderFunctions.propertiesandMethods.main scope

    var counter = 0

    val incrementCounter = { counter += 1}

    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()

    println(counter)

    //higher order function(Takes other functions as parameters or returns functions)
    fun countingLambda(): () -> Int {
        var counter = 0
        val incrementCounter = {
            counter += 1
            counter
        }
        return incrementCounter
    }

    //these two counters are mutually exclusive and count independently
    val lambdaCounter1 = countingLambda()
    val lambdaCounter2 = countingLambda()

    println(lambdaCounter1())
    println(lambdaCounter1()) //prints different values

    println(lambdaCounter2())
    println(lambdaCounter2())
    println(lambdaCounter2())


}