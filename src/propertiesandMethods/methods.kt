package propertiesandMethods
//function inside a class or object

/**
 * Properties hold values that can be get and set
 *      can have a custom setter
 * methods perform work used in expensive computations
 *
 */

val months = arrayOf(
    "January", "February","March ",
    "April ","May" ,"June ",
    "July", "August ","September",
    "October","November ","December")

class SimpleDate (var month: String) {

    fun monthsUntilJingleBells(): Int {
        return months.indexOf("December") - months.indexOf(month)
    }

}


fun main() {

    val date = SimpleDate("January")
    println(date.monthsUntilJingleBells())



}