package propertiesandMethods

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

/**
 * Used to argument a type with new properties and methods in your code without changing the class definition
 *
 *
 */

//------CAN NOT BE EDITED---------
class Circles(var radius: Double = 0.0){
    val circumference: Double
        get() = PI * radius * 2
}
//---------------------------------

//Add circles Extension property
val Circles.diameter: Double
    get() = radius * 2.0


//--CAN NOT BE EDITED--------------

class Simpledate (var month: String) {
    fun monthsUntilJingleBells(): Int {
        return monthsYear.indexOf("December") - monthsYear.indexOf(month)
    }
    companion object{
        val monthsYear = arrayOf(
            "January", "February","March",
            "April","May" ,"June",
            "July", "August","September",
            "October","November","December")
    }
}
//-----------------------------------

//Add Extension methods
fun Simpledate.monthsUntilHalloween(): Int{
    val currentMonthIndex = Simpledate.monthsYear.indexOf(month)
    val halloweenStart = Simpledate.monthsYear.indexOf("September")
    val halloweenEnd = Simpledate.monthsYear.indexOf("October")

    return if (currentMonthIndex in 0..halloweenStart) {
        halloweenStart - currentMonthIndex
    } else if (currentMonthIndex in halloweenStart..halloweenEnd) {
        0
    } else {
        halloweenStart + (12 - currentMonthIndex)
    }
}

//------------CAN NOT BE EDITED---------
class TvMath2{
    companion object{
        //companion methods
        fun getDiagonal(width: Double,height: Double): Int{
            val result = sqrt(width.pow(2) + height*height)
            return result.roundToInt()
        }
        fun getWidthAndHeight(diagonal: Int, ratioWidth: Double, ratioHeight: Double): Pair<Double,Double>{
            val ratioDiagonal = sqrt(ratioWidth.pow(2) + ratioHeight.pow(2))

            val height = diagonal.toDouble() * ratioHeight/ratioDiagonal
            val width = height* ratioWidth/ratioHeight
            return Pair(width,height)
        }
    }
}
//--------------------------------------

//add TvMath2 companion Object Extension methods

fun TvMath2.Companion.idealViewingDistance(diagonal:Int,is4k:Boolean): Double{
    return if (is4k) diagonal * 1.25 else diagonal *2.0
}

fun main() {

    //accessing extension properties is like other properties
    val unitCircle = Circles(5.0)
    println(unitCircle.diameter)

    //accessing extension methods
    val date = Simpledate("August")
    println("${date.monthsUntilHalloween()} months(s) until halloween decorations")

    val distance = TvMath2.idealViewingDistance(65,true)
    println("It's $distance distance away")

}