package classInheritanceandInterfaces


/**
 * Define a common set of properties and behaviours but dont need an implementation
 * for every vehicle, it accelerate
 *
 * How to use it:
 *     Implementing it
 *     Conform to interface - satisfying all its requirements
 * */
interface Vehicle{

    fun accelerate()
    fun stop()
}

class Unicycle: Vehicle{
    var peddling = false
    override fun accelerate() {
        peddling = true
        println("Weeee")
    }

    override fun stop() {
        peddling = true
        println("Nooo")
    }
}

enum class Direction{
    LEFT, RIGHT
}

interface TurningVehicle: Vehicle{
    fun turn(direction: Direction = Direction.RIGHT ) //interfaces can as well have default parameters
    fun description(): String
    }

interface Spacey{
    val tribbleCount: Int
}

interface SpaceVehicle: Vehicle,Spacey{


    val name: String
        get() = "SpaceVehicle"

    override fun accelerate() { println("Procced to Hyperspace") }
    override fun stop() { println("Whoaaa, slow down") }
}

class LightFreighter: SpaceVehicle{
    override val tribbleCount: Int = 0

    var hyperDriveBusted: Boolean = false

    override fun stop() {
        hyperDriveBusted = true
        println("HyperDrive failure ...again")

    }
}
class StarShip: SpaceVehicle{
    override val tribbleCount: Int
        get() = Int.MAX_VALUE

    override val name: String
        get() = "StarShip"

    override fun accelerate() {
        println("Warp factor 9, please")
    }

    override fun stop() {
        super.stop()
        println("That kind of hurt...")
    }
}

fun main() {
    val unicycle = Unicycle()
    unicycle.accelerate()
    unicycle.stop()

    val falcon =LightFreighter()
    falcon.accelerate()
    falcon.stop()

    val startShip = StarShip()
    startShip.stop()
    startShip.accelerate()


}