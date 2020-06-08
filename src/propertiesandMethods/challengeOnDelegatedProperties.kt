package propertiesandMethods

import kotlin.properties.Delegates

// 2-06 Challenge - Delegated Properties - Starter

/*
Challenge 1:
 Rewrite the `IceCream` class below:
 1. Use a default value for the name property.
 2. Lazily initialize the `ingredients` list.
*/

/*class IceCream {
    val name: String
    val ingredients: ArrayList<String>
}*/

class IceCream {
    var name: String = "Vanilla"
    val ingredients: ArrayList<String> by lazy { arrayListOf<String>() }
}

/*
Challenge 2:
Below is a `SpaceCar` and `SpaceBattery` class.
Dive into the inner workings of the car and rewrite the `SpaceBattery` class
below with delegated property observer functionality:

1. Add a `lowCharge` property of Boolean type to the class.
2. Flip the `lowCharge` Boolean when the `level` drops below 10%.
3. Ensure that when the tank fills back up, the `lowCharge` warning will turn off.
4. Add a `SpaceBattery` property to `SpaceCar`, make one, and charge it up. Then fly around for awhile.
*/

class SpaceCar(
    val make: String,
    val color: String,
    val battery: SpaceBattery = SpaceBattery()
)
class SpaceBattery {

    var lowCharge = true
    var level: Double by Delegates.observable(0.0) { _, _, new ->
       lowCharge = new < 0.1
    }
}

fun main() {
    // ~~~Challenge 1~~~
    // Make a new instance of IceCream
    val iceCream1 = IceCream()
    // Give it a name other than the default
    iceCream1.name = "Chocolate"
    // Add some ingredients!
    iceCream1.ingredients.add("Milk cream")
    iceCream1.ingredients.add("Chocolate")
    println("My favorite IceCream is ${iceCream1.name} whose ingredients are ${iceCream1.ingredients}")

    // ~~~Challenge 2~~~
    // Make a SpaceCar!
    val spaceTrack = SpaceCar("Tesla", "Space Metal")

    // Charge the battery!
    spaceTrack.battery.level = 1.0
    println(spaceTrack.battery.lowCharge)
    // Fly around for awhile.
    spaceTrack.battery.level = 0.05
    println(spaceTrack.battery.lowCharge)


}