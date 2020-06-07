package classInheritanceandInterfaces

import propertiesandMethods.sqr
import kotlin.math.PI

// 3-08 Challenge - Interfaces - Starter

/*
Challenge 1:
  - Create an interface `Shape` that defines a property `area` of type Double.
  - Implement `Shape` with classes representing Square, Triangle, and Circle.
  - Add a circle, a square, and a triangle to an array.
  - Convert the array of shapes to an array of areas using map.

 **HINTS**
 - The area of a square = one of its sides squared
 - The area of a triangle = 0.5 multiplied by its base multiplied by its height
 - The area of a circle = pi multiplied by its radius squared
*/
interface Shape{
    val area: Double
}
class Square(val side: Double): Shape{
    override val area: Double
        get() = side * side

}
class Triangle(val base: Double, val height: Double): Shape{
    override val area: Double
        get() = 0.5 * base * height

}

class Circle(val radius: Double): Shape{
    override val area: Double
        get() = PI * radius.sqr()

}
fun main() {

    val square = Square(5.0)
    val triangle = Triangle(2.0,5.0)
    val circle = Circle(14.0)

    val shapesArray = arrayOf(square,triangle,circle)
    val areas = shapesArray.map {  it.area }

    println(areas)



}