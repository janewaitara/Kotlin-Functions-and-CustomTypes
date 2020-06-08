package objectsEnumclassesAndSealedClasses

// 4-05 Challenge Enum Classes - Starter

/*
Challenge - Transform SimpleDate into an Enum Class!
- Make it an Enum Class and call it `Month` instead of `SimpleDate`
- Turn that months array into the enum cases
- Get the monthsUntilJingleBells and monthsUntilHalloweenDecorations methods working again
- Write a new property named `season` with a custom getter that will return the season of the year
for each month. (Maybe model `Season` as another Enum Class?)
*/

class SimpleDate(var month: String) {
    companion object {
        val months = arrayOf(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        )
    }

    fun monthsUntilJingleBells(): Int {
        return months.indexOf("December") - months.indexOf(month)
    }

    fun monthsUntilHalloweenDecorations(): Int {
        val currentMonth = SimpleDate.months.indexOf(month)
        val halloweenStart = SimpleDate.months.indexOf("September")
        val halloweenEnd = SimpleDate.months.indexOf("October")

        return if (currentMonth in 0..halloweenStart) {
            halloweenStart - currentMonth
        } else if (currentMonth in halloweenStart..halloweenEnd) {
            0
        } else {
            halloweenStart + (12 - currentMonth)
        }
    }
}

enum class Season{
    Spring, Winter, Summer, Autumn;

}
enum class Month{
    January, February, March, April, May, June, July, August, September, October, November, December;

    val  season: Season
        get() = when(this){
            December,January ,February -> Season.Winter
            March, April, May -> Season.Spring
            June, July, August -> Season.Summer
            September, October, November -> Season.Autumn
        }

    fun monthsUntilJingleBells(): Int{
        return December.ordinal  - this.ordinal
    }

    fun monthsUntilHalloweenDecorations(): Int{
        val currentMonth = this.ordinal
        val halloweenStart = September
        val halloweenEnd = October

        return when (this) {
            in January..halloweenStart -> halloweenStart.ordinal - currentMonth
            in halloweenStart..halloweenEnd -> 0
            else -> halloweenStart.ordinal + (values().count() - currentMonth)
        }
    }
}



fun main() {

    val december = Month.December

   println("From ${december.name} there are ${december.monthsUntilJingleBells()}months till Christmas")
   println("From ${december.name} there are ${december.monthsUntilHalloweenDecorations()}months till Halloween")

    println(december.season)
    println(Month.September.season)

}