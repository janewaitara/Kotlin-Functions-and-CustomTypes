package ClassInheritanceandInterfaces

// 3-02 Inheritance - Starter

data class Grade(val courseName: String, val letter: Char, val credits: Double)

//open says you can inherit from me
open class Person(var firstName: String, var lastName: String) {
    fun fullName() = "$firstName $lastName"
}

open class Student( firstName: String,  lastName: String,
              var grades: MutableList<Grade> = mutableListOf<Grade>()) : Person(firstName,lastName) {


    fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}
class BandMember(firstName: String,lastName: String): Student(firstName, lastName){
    var minimumPracticeTime: Int = 2

}

class studentAthlete(firstName: String,lastName: String): Student(firstName, lastName){
    var isElibible: Boolean = true
}



fun main() {

    val john = Person("John","Mwangi")
    val jane = Student("Jane","Waitara")
    val victor = BandMember("Victor","Weru")
    val marty = studentAthlete("Hammo","Weru")

    println(john.fullName())
    println(jane.fullName())
    println("${victor.fullName()} practices for ${victor.minimumPracticeTime}" )
    println("Can ${marty.fullName()} participate in the match : ${marty.isElibible}")
    println()

    val robotics = Grade("Robotics",'A',4.5)

    jane.recordGrade(robotics)
    println(jane.grades)
}