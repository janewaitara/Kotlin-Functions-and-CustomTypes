

fun main() {

    //have the ability to close over the variables and constants defined in their own scope
    //will access counter in the main scope

    var counter = 0

    val increamentCounter = { counter += 1}

    increamentCounter()
    increamentCounter()
    increamentCounter()
    increamentCounter()
    increamentCounter()

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
    println(lambdaCounter1())

    println(lambdaCounter2())
    println(lambdaCounter2())
    println(lambdaCounter2())

}