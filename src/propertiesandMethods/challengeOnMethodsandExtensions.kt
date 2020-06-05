package propertiesandMethods

import kotlin.math.PI
import kotlin.math.sqrt

// 2-09 Challenge - Methods & Extensions - Starter

/*
Challenge 1:
Given the `Circle` class below, write a method that can change
an instance’s area by a growth factor. For example if you call
`circle.grow(factor = 3)`, the area of the instance will triple.

**Hint**: Make `area` a `var` and add a setter to it.
Math Hint: The math you want to calculate the radius in `area`s setter is `sqrt(area / PI)`
*/

class Circle2(var radius: Double = 0.0) {

    var area: Double
        get() {
            return PI * radius * radius
        }
        set(setArea) {
            radius = sqrt(area / PI )
        }
    fun grow(factor: Double){
        area *= factor
    }
}


/*
Challenge 2:
Add the `isEven()` and `isOdd()` functions below as extension properties to `Int`
Hint: You *do* need to use the `this` keyword for this challenge!

While you're at it, extend `Double` with a `square` method. Call it `sqr` if you like!
Then, use the new `sqr` method in the Circle class instead of `radius * radius`
*/

object MyMath {
    fun isEven(number: Int) = number % 2 == 0
    fun isOdd(number: Int) = number % 2 == 1
}

// Add Extension Properties here
val Int.isEven: Boolean
    get() = this % 2 ==0 //this instance of an Int

val Int.isOdd: Boolean
    get() = this % 2 == 1

fun Double.sqr(): Double = this * this


fun main() {

    var firstCircle = Circle2(5.0)
    println(firstCircle.area)
    firstCircle.grow(3.0)
    println(firstCircle.area)

    println(2.isEven)
    println(2.isOdd)

    println(2.0.sqr())



}