package propertiesandMethods

import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

//
class Person(val firstName: String, val lastName: String){
    val fullName = "$firstName $lastName"

}

class Tv(var width: Double, var height: Double){
    var diagonal: Int
        get(){
            val result = sqrt(width.pow(2) + height*height)
            return result.roundToInt()
        }

        set(value){
            var ratioWidth = 16.0
            val ratioHeight = 9.0
            val ratioDiagonal = sqrt(ratioWidth.pow(2) + ratioHeight.pow(2))

            height = value.toDouble() * ratioHeight/ratioDiagonal
            width = height* ratioWidth/ratioHeight
        }
}

fun main() {

    val grace = Person("Grace", "Hopper")
    println(grace.fullName)

    val tv = Tv(width = 95.87,height = 53.93)
    println(tv.diagonal)

    tv.width = tv.height
    println(tv.diagonal)

    tv.diagonal = 65
    println("That'll be ${tv.width} inches wide, Janie!")


}