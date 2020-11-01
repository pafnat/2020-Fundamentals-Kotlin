package day_1_kotlin.langeng.assignments

// Workshop #5 - inheritance, abstract, interface

// Don't touch! Given:
// Declare a contract for a transport ability.
interface Driveable {
    fun drive()
}

// Declare a transport class which describes passenger transport of all types.
// Give this transport an ability to drive.
abstract class Transport(protected var passengersCount: Int): Driveable

// Create a Bicycle transport which can carry a single person.
class Bicycle: Transport(1) {
    override fun drive() {
        println("Ride a bicycle.")
    }
}



/* Exercise area */

// TODO 1: Create a new interface that will be appropriate for new classes below.
// ? By convention, names of Classes and Interfaces start with an upper case letter and use the camel case.
// Example: "SomeLongClassName".
interface Storable {
    fun isFull(): Boolean
    fun takePlace()
}

// TODO 2: Write your own class Bus and some Car.
//  Instead of writing it from scratch, extend it from the Transport class and your new interface.
// ? Class can extends only one other class, but implements many interfaces, i.e.:
//class Kitty(): Cat, Cuteable, Sleepable, Furryable {}

class Bus(passengersCount: Int): Transport(passengersCount), Storable {

    private var hasNoSeats: Boolean = false

    override fun drive() {
        if (isFull()) {
            println("Driving Bus without free seats")
        } else {
            println("There are free seats in the bus")
        }
    }

    override fun isFull(): Boolean  = hasNoSeats

    override fun takePlace() {
        hasNoSeats = true
        println("Take all free seats with passengers...")
    }

}

class Car(passengersCount: Int): Transport(passengersCount), Storable {

    private var hasNoSeats: Boolean = false

    override fun drive() {
        if (isFull()) {
            println("Driving Car without free seats")
        } else {
            println("There are free seats in the car")
        }
    }

    override fun isFull(): Boolean  = hasNoSeats

    override fun takePlace() {
        hasNoSeats = true
        println("Take all free seats with passengers...")
    }

}

// TODO 3: Test your transport in appropriate sections
object VehiclesTest {

    // You can run the main function to test the code
    @JvmStatic
    fun main(args: Array<String>) {
        testBus()
        testCar()
        testBicycle()
        testBusParts()
    }

    private fun testBus() {
        println("Testing how bus drives...")
        val bus = Bus(10)
        bus.drive()
        bus.takePlace()
        bus.drive()
    }

    private fun testCar() {
        println("Testing how car drives...")
        val car = Car(4)
        car.drive()
        car.takePlace()
        car.drive()
    }

    private fun testBicycle() {
        println("Testing how bicycle drives...")
        val bicycle = Bicycle()
        bicycle.drive()
            }



    /* Exercise bonus area */

    // TODO 4: Test bus abilities as separate features.
    private fun testBusParts() {

        val bus = Bus(0)
        val engine: Driveable = bus
        println("Testing bus engine:")
        println(engine.drive())

        val space: Storable = bus
        println("Testing bus free space:")
        println("has no space: ${space.isFull()}")
        println(space.takePlace())
        println("has no space: ${space.isFull()}")

    }
}