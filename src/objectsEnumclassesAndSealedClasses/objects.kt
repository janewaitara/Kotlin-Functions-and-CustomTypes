package objectsEnumclassesAndSealedClasses

/**
 * Object keywords lets you define a type that has a single instance (named object)
 * Can have properties and member function
 * Can not have constructors
 * Can inherit from classes and implement interfaces
 * Properties of the object must be initialized before use,either at declaration or in an init block
 *
 * Why use them:
 *      Singleton pattern - restricts a class to have a single instance
 *
 * */

data class Student(var id: Int, val firstName: String, val lastName: String){
    var fullName = "$firstName $lastName"
}
object StudentRegistry{

    val allStudents = mutableListOf<Student>()

    fun addStudents(student: Student){
        allStudents.add(student)
    }
    fun removeStudents(student: Student){
        allStudents.remove(student)
    }
    fun printStudents(){
        allStudents.forEach { student ->
            println(student.fullName)
        }
    }


}
fun main() {

    val francisco = Student(1,"Francisco", "Goya")
    val sal = Student(1,"Salvado", "Dali")
    val frida = Student(1,"Frida", "Kanario")

    //using methods defined on an object

    StudentRegistry.addStudents(francisco)
    StudentRegistry.addStudents(sal)
    StudentRegistry.addStudents(frida)

    StudentRegistry.printStudents()
}