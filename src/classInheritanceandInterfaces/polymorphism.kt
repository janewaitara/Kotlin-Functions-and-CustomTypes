package classInheritanceandInterfaces

/**
 * A subclass can be treated as it own type, or as any of its super classes
 * */
fun main() {

    val john = Person("John","Mwangi")
    val jane = Student("Jane","Waitara")
    val victor = BandMember("Victor","Weru")
    val marty = StudentAthlete("Hammo","Weru")

    val persons = arrayOf(john,jane,victor,marty)
    val students = arrayOf(jane,victor,marty)

    persons.forEach { person ->
        println("${person.fullName()} is a person")
        if (person is Student) println(person.grades)
    }

    //upCasting and is considered unsafe cast
    val student = victor as Student

    //downCasting is safe cast - taking a super class and turning it into a subclass
    val bassist = student as? BandMember

    fun afterClassActivity(student: Student): String {
        return " Goes home"
    }
    fun afterClassActivity(student: BandMember): String{
        return "Practics for ${student.minimumPracticeTime} hours"
    }

    println(afterClassActivity(victor))
    println(afterClassActivity(victor as Student)) //instances of when to use as on its own

}