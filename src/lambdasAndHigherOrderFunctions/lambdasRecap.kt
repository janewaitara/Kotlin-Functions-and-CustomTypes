package lambdasAndHigherOrderFunctions
// anonymous functions
fun main() {

    fun operateOnNumbers(a: Int, b: Int, operation: (Int,Int) -> Int): Int{
        return  operation(a,b)
    }

    val addLambda = {a:Int, b: Int ->
       a + b
    }

    operateOnNumbers(4,2,operation = addLambda)
    //ca be defined in line

    operateOnNumbers(2,5){a,b -> a+b}

    fun addFunction(a: Int , b: Int) = a + b
    operateOnNumbers(4,2,::addFunction)
    //using function reference for the plus operator
    operateOnNumbers(5,8,Int::plus) //since a plus takes in two numbers and returns one number


}