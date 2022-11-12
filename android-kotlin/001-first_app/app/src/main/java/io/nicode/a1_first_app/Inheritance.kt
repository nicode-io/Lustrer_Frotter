package io.nicode.a1_first_app

interface Drivable {
    val maxSpeed: Double
    fun drive(): String
    fun brake() {
        println("The drivable is braking")
    }
}

/**
 * Super, Parent or Base class (term of our choice)
 * Here abstracted, can't be instantiated directly
 */
abstract class Vehicle() : Drivable {
    abstract var name: String
    abstract var brand: String
    abstract override var maxSpeed: Double
    abstract val wheels: Int
    abstract fun defineUse(): String
}

/**
 * Sub, Child, Derived class of Vehicle
 * Super, Parent or Base class of ElectricCar
 */
open class Car(
    override var name: String, override var brand: String,
    override var maxSpeed: Double = 210.0, override val wheels: Int = 4
) : Vehicle() {
    open var range: Double = 0.0

    // Define implementation for abstracted upper level requirements
    override fun drive(): String = "Drive Car"
    override fun defineUse(): String = "Daily and long trip"

    open fun drive(distance: Double) {
        println("Drove for $distance km")
    }
}

/**
 * Sub, Child, Derived class of vehicle
 */
class ElectricCar(name: String, brand: String, batteryLife: Double, maxSpeed: Double = 190.0) :
    Car(name, brand, maxSpeed) {

    override var range = batteryLife * 6
    var chargerType: String = "slow"

    // We override here the interface Drivable (Short syntax)
    override fun drive(): String = "Drive Electric Car"

    // We override the parent class implementation of drive
    // != interface Drivable drive() method
    override fun drive(distance: Double) {
        println("Drove for $distance km on electricity")
    }

    override fun brake() {
        super.brake()
        println("Update brake implementation in ElectricCar")
    }
}

fun main() {
    var mini = Car("Hatch", "Mini")
    var tesla = ElectricCar("Model E", "Tesla", 85.0)

    // Polymorphism
    mini.drive(200.0)
    tesla.drive(200.0)

    tesla.drive() // Not the same method as above
    tesla.chargerType = "fast"

    println(tesla.wheels)

    tesla.brake()
}