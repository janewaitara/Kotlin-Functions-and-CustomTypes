package propertiesandMethods
import kotlin.math.atan
import kotlin.properties.Delegates

/*
* May want to observe when a property changes - use delegated property which has by key word
* can not have custom accessors
* */


class Level2(val id: Int,
             val boss: String){

    companion object{
        var highestLevel = 0 //can not be accessed on the level instance
    }

    var unlocked: Boolean by Delegates.observable(false){
            _, old, new -> //lambda takes three arguments and is invoked after the value is changed
        if (new && id > highestLevel) { //if new value is true
            highestLevel = id
        }
    }
}

//can be used to limit the value of a variable

class LightBulb {
    companion object{
        const val maxCurrent = 40
    }
    var current: Int by Delegates.vetoable(0){
        _, _, new ->  //this lambda returns a boolean
        if (new > maxCurrent){
            println("Current too high, falling back to previous setting")
           false
        }else{
            true
        }
    }
}

//lazy properties are useful while downloading a users profile picture or performing a calculation like calculating pie
class Circle(var radius: Double = 0.0){
    val pi: Double by lazy { ((4.0 * atan(1.0/5.0)) - atan(1.0/239.0)) * 4.0 } // its calculated only when circumference is needed
    val circumference: Double
        get() = pi * radius * 2

}

//lateinit var is used to denote that a property will not have a value when class instance is created
class Lamp{
    lateinit var bulb : LightBulb
}


fun main() {

    val level1 = Level2(id = 1, boss = "Outside Cat")
    val level2 = Level2(id = 2, boss = "Laser Pointer")
    val level3 = Level2(id = 3, boss = "Mysterious Sound")
    val level4 = Level2(id = 4, boss = "Vacuum Cleaner")

    level1.unlocked = true
    println("The highest level is ${Level2.highestLevel}")

    level4.unlocked = true
    println("The highest level is ${Level2.highestLevel}")

    val lightBulb1 = LightBulb()
    lightBulb1.current = 9000
    println("The maximum current is ${lightBulb1.current}")
    lightBulb1.current = 20
    println("The maximum current is ${lightBulb1.current}")

    val circle = Circle(5.0)
    println(circle.circumference)


    val fancyLamp = Lamp()
    fancyLamp.bulb = lightBulb1
    println(fancyLamp.bulb.current)

}