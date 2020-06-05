package propertiesandMethods

import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

/*
* properties on one instance of a class are separate from properties on any other instance of the same class
* We can have properties common on all instances and are put in companion objects*
* the companion object project will be available from anywhere in the app
* it works for methods as well
*/

class Level(val id: Int,val boss: String, val unlocked: Boolean ){

    companion object{
        var highestLevel = 1 //can not be accessed on the level instance
    }
}
class TvMath{
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

class Tv2(var width: Double, var height: Double){
    var diagonal: Int
        get(){
            return TvMath.getDiagonal(width,height)
        }

        set(value){
            val size = TvMath.getWidthAndHeight(value, 16.0, 9.0)
            height = size.second
            width = size.first
        }
}

fun main() {


    val level1 = Level(1,"Outside Cat",true)
    val level2 = Level(2,"Laser Pointer",false)
    val level3 = Level(3,"Mysterious Sound",false)
    val level4 = Level(4,"Vacuum Cleaner",false)

    println("Highest Level is ${Level.highestLevel} ")


    val grace = Person("Grace", "Hopper")
    println(grace.fullName)

    val tv = Tv2(width = 95.87,height = 53.93)
    println(tv.diagonal)

    tv.width = tv.height
    println(tv.diagonal)

    tv.diagonal = 65
    println("That'll be ${tv.width} inches wide, Janie!")

}