package objectsEnumclassesAndSealedClasses

/**
 * Sealed classes are between final classes and open classes
 *
 * They have limited number of direct subclasses all defined in the same files as the sealed class
 * They are abstract.You can instantiate an instance of the sealed class directly
 * They can have abstract members which must be implemented in all subclasses
 * Can have multiple instances of a subclass of a sealed class
 * Constructors of sealed classes are always private which allows you to take advantage of some of the flexibility of
 *      subclassing without tempting you to create massive inheritance trace
 *
 *
 * can have non abstract properties with custom getters and can make use of when
 *
 * non-abstract properties need to have an initial value
 * */

sealed class AcceptedCurrencies{

    abstract val valueInDollars: Float
    var amount: Float = 0.0F

    class Dollar: AcceptedCurrencies(){

        override val valueInDollars = 1.0F
    }
    class Euro: AcceptedCurrencies(){
        override val valueInDollars = 1.25F
    }
    class Crypto: AcceptedCurrencies(){
        override val valueInDollars = 2534.92F
    }

    val name: String
    get() = when(this){
        is Dollar -> "Dollars"
        is Euro -> "Euro"
        is Crypto -> "MeowCoin"
    }

    fun totalValueInDollars(): Float{
        return amount * valueInDollars
    }
}

fun main() {

    val euro = AcceptedCurrencies.Euro()

    println("You have some ${euro.name}")

    euro.amount = .27541f
    println("${euro.amount} of ${euro.name} is equivalents to ${euro.totalValueInDollars()} Dollars")

}