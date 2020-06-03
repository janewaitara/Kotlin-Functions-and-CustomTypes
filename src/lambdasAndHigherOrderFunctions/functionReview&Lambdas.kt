package lambdasAndHigherOrderFunctions

fun main() {

    fun printRange(){
        for(number in 0..10) print("$number \t")
        println()
    }


    printRange()
    //function parameters
    fun printRange(range: IntRange){
        for(number in range) {
            print("$number \t")
        }
        println()
    }
    printRange(0..10)

    //function parameters with a return type
    fun createRange(start: Int, end: Int, isHalfOpen: Boolean): IntRange{

        return if(isHalfOpen){
            start until end
        }else {
            start..end
        }
    }

    //function assigned to a variable
    val halfOpenedRange = createRange(11,15,true)
    printRange(halfOpenedRange)

    //named arguments
    val namedArguments = createRange( isHalfOpen = true, start = 100, end = 115)
    printRange(namedArguments)

    printRange(createRange(100, end = 104, isHalfOpen = true))
    printRange(createRange(start = 200,end = 202,isHalfOpen = false))

    //overLoad of createRange
    fun createRange(start: Char, end: Char,isHalfOpen: Boolean = false) =
        if (isHalfOpen) start until end else start..end

    fun printRange(range: CharRange){
        for( char in range) {
            print("$char \t")
        }
        println()
    }


    val closedRange = createRange('A', 'G')
    printRange(closedRange)


}