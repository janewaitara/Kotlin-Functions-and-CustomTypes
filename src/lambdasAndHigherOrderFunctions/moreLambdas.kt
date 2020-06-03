package lambdasAndHigherOrderFunctions

fun main() {
    /*
    * See dwarves below, I want them organized like this:
    *   Grouped by which names and before or after M in the alphabet.
    *   Sorted by name length
    *   No dwarves with names less than four letters long.
    *   Turn dwarves before M into a map, grouped by the first letters in their names
    * */

    //multidimensional list of dwarves
    val lotsOfDwarves = listOf(
        listOf("sleepy","Grumpy","Doc","Bashful","Sneezy"),
        listOf("Thorin","Nori","Bomber")
    )
    println(lotsOfDwarves)

        //flattening two lists into one list
    val(beforeM,afterM) = lotsOfDwarves.flatMap { dwarves ->
        dwarves.filter { it.length > 3 } //returns element that meets that condition
    }.sortedBy { -it.length }.partition { it < "M" }  // sorted from longest to shortest //names before letter m and after m

    //put the dwarves before m grouped by their first letters in their names in a Map
    val groupedBeforeM = beforeM.groupBy { it.first() }

    println(groupedBeforeM)
    println(afterM)


}