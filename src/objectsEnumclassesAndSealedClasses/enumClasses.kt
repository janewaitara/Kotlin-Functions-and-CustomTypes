package objectsEnumclassesAndSealedClasses

/**
 * Need to deal with clear cases of something where the value can only be one of the very limited number of potential values
 *each case is a single instance of the class
 *
 * enum classes have a values companion function which gives you a list of all declared cases in the class
 *          ordinal property for each case which returns the index of each cases from the list of declared cases
 *          name which takes the name of the case in coding and gives back the string of that name
 *
 *
 *can have methods also: companion or regular
 * */


enum class DayOfWeek(val isWeekend: Boolean = false){
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday(true), Sunday(true);
    fun daysUntil(other: DayOfWeek): Int{
        return if (this.ordinal < other.ordinal){
            other.ordinal - this.ordinal
        } else {
            other.ordinal - this.ordinal + values().count()
        }
    }
}



fun main() {

    for(day in DayOfWeek.values()){
        println("Day ${day.ordinal}: ${day.name} is weekend: ${day.isWeekend}")
    }

    println()

    val friday = DayOfWeek.Friday
    println("There are ${DayOfWeek.Sunday.daysUntil(friday)} days until ${friday.name}")

    println()

    //enum with when statements
    fun singAboutToday(today: DayOfWeek) {
        when (today) {
            DayOfWeek.Tuesday -> println("$today is gray ")
            DayOfWeek.Wednesday -> println("$today is purple ")
            DayOfWeek.Thursday -> println("$today I don't care you ")
            DayOfWeek.Friday -> println("$today I am in love")
            DayOfWeek.Saturday -> println("$today, wait...")
            DayOfWeek.Sunday -> println("$today always come too late ")
            else -> println("I don't feel like singing")
        }

    }

    for (day in DayOfWeek.values()) singAboutToday(day)



}
