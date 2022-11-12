package io.nicode.a1_first_app

/**
 * BASIC CLASS WITH MULTIPLE CONSTRUCTORS
 */
class BasicClass(firstName: String, lastName: String = "com") {
    // Member variables - Properties
    private val firstName: String
    private val lastName: String
    private var age: Int? = null
    var stream: String = "Netflix"

    // Initializer block
    init {
        this.firstName = firstName
        this.lastName = lastName
        println("Secondary Constructor with args: $firstName $lastName")
    }


    // Member secondary constructor
    constructor(firstName: String, lastName: String, age: Int) : this(firstName, lastName) {
        this.age = age
        println("Main Constructor with args: $firstName $lastName $age")
    }


    // Member functions - Methods
    fun stateStream() {
        println("Stream $stream $firstName $lastName ${this.age}\n")
    }

}

/**
 * GETTER / SETTER
 */
class CarBase() {
    lateinit var owner: String

    // Basic setter and getter are created automatically
    // Just create manually if we need to do customisation
    var myBrand: String = "BMW"
        get() {
            return field.lowercase()
        }
        private set(newBrand) {
            field = newBrand.lowercase()
        }

    var maxSpeed: Int = 190
        set(newMaxSpeed) {
            field =
                if (newMaxSpeed > 0) newMaxSpeed else (throw java.lang.IllegalArgumentException("Speed must be positive value"))
        }


    init {

    }

    fun changeBrand(newBrand: String) {
        this.owner = "Nicode"
        myBrand = newBrand
    }
}

/**
 * DATA CLASS
 */
data class UserData(val id: Long, var name: String)

fun main() {
    val nicode = BasicClass("Nicode", "io")
    nicode.stream = "HBO Max"
    nicode.stateStream()

    val nicodeSec = BasicClass("SecNicode", "io", 39)
    nicodeSec.stateStream()

    val myCarBase = CarBase()
    println("Brand is ${myCarBase.myBrand}")

    // Use setter directly
    // myCar.maxSpeed = -2 -> Throw error
    myCarBase.maxSpeed = 250
    println(myCarBase.maxSpeed)

    // Use function because setter is private
    myCarBase.changeBrand("Toyota")
    println(myCarBase.myBrand)

    // Data class
    val userOne = UserData(1, "Nicode")
    userOne.name = "Renamed"
    val userTwo = UserData(1, "Renamed")
    // Use comparison
    println(userOne == userTwo)
    // Print data
    println("User details: $userOne")
    // Copy data
    val newUserCopy = userOne.copy(name = "Copycat")
    println("User details: $newUserCopy")
    // Get component of data
    println(newUserCopy.component1())
    println(newUserCopy.component2())
    // Destructuring
    val (id, name) = newUserCopy
    println(id)
    println(name)
}

