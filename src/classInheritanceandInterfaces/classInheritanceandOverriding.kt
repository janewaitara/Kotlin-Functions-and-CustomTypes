package classInheritanceandInterfaces

// 3-02 Inheritance - Starter
/**
 * Single Inheritance -> Can only inherit from one class
 * Can only inherit on an open class
 * No depth in subclassing and being inherited from
 * */
/**
 * For methods to be overridden, they need to be open
 * */

data class Grade(val courseName: String, val letter: Char, val credits: Double)

//open says you can inherit from me
open class Person(var firstName: String, var lastName: String) {
    fun fullName() = "$firstName $lastName"
}

open class Student( firstName: String,  lastName: String,
              var grades: MutableList<Grade> = mutableListOf<Grade>())
    : Person(firstName,lastName) {

    open var isEligible: Boolean = true

    open fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}
class BandMember(firstName: String,lastName: String): Student(firstName, lastName){
    var minimumPracticeTime: Int = 2
    override var isEligible: Boolean = true
        get() = grades.none{ it.letter  == 'F'} //none return true if none of the grades match the condition

    override fun recordGrade(grade: Grade) {
        super.recordGrade(grade)

        if (!isEligible) println("${fullName()} can't perform any more.Study! Study! Study! Study!")
    }

}

class StudentAthlete(firstName: String, lastName: String): Student(firstName, lastName){
    override fun recordGrade(grade: Grade) {
        super.recordGrade(grade)
        isEligible = grades.filter { it.letter == 'F'}.size < 3
        if (!isEligible) println("${fullName()} can't play the big game! Time to study")
    }
}

fun main() {

    val john = Person("John","Mwangi")
    val jane = Student("Jane","Waitara")
    val victor = BandMember("Victor","Weru")
    val marty = StudentAthlete("Hammo","Weru")

    val robotics = Grade("Robotics",'A',4.5)
    val failure = Grade("Arts",'F',1.5)



    println(john.fullName())
    println(jane.fullName())
    println()

    jane.recordGrade(robotics)
    println(jane.grades)
    println()


    println("${victor.fullName()} practices for ${victor.minimumPracticeTime}" )
    println("Can ${marty.fullName()} participate in the match : ${marty.isEligible}")

    //overriding
    marty.recordGrade(failure)
    marty.recordGrade(failure)
    marty.recordGrade(failure)

    victor.recordGrade(failure)
}