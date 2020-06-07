package classInheritanceandInterfaces

open class Student2( var firstName: String, var lastName: String,
                    var grades: MutableList<Grade> = mutableListOf<Grade>()){

    open fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}
class BandMember2(firstName: String,lastName: String): Student2(firstName, lastName){
    var minimumPracticeTime: Int = 2
    val isEligible
        get() = grades.none{ it.letter  == 'F'} //none return true if none of the grades match the condition


    constructor(firstName: String,lastName: String,minimumPracticeTime: Int): this(firstName, lastName){
        this.minimumPracticeTime = minimumPracticeTime
    }

    constructor(transfer: BandMember2): this(transfer.firstName , transfer.lastName, transfer.minimumPracticeTime){
        grades = transfer.grades
        if(!isEligible) minimumPracticeTime  += 1
        println("(transfer) Practice for $minimumPracticeTime hrs")
    }

    init {
        if(!isEligible) minimumPracticeTime  += 1
        println("(Init) Practice for $minimumPracticeTime hrs")
    }
    init {
        if(!isEligible) minimumPracticeTime  += 1
        println("(Init2) Practice for $minimumPracticeTime hrs")
    }

}

fun main() {

    val bill = BandMember2("Bill","Preston")
    val ted = BandMember2("Ted","Precious",7)
    val honor = BandMember2("Honor","John")

    bill.recordGrade(Grade(courseName = "Ted",letter ='A',credits = 2.5))
    bill.recordGrade(Grade(courseName = "Maths",letter ='A',credits = 2.5))

    val transferBill = BandMember2(bill)
    println(transferBill.grades)



}