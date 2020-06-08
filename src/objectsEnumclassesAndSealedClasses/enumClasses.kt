package objectsEnumclassesAndSealedClasses

/**
 * Need to deal with clear cases of something where the value can only be one of the very limited number of potential values
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

    val friday = DayOfWeek.Friday
    println(DayOfWeek.Sunday.daysUntil(friday))

}
