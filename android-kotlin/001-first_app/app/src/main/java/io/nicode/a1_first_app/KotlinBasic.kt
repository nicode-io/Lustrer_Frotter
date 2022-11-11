@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

package io.nicode.a1_first_app

fun main() {
// DATA TYPES
    // Immutable
    val myName = "Nicode"
    // Mutable
    var mutable = "One"
    mutable = "Two"

    // Integers
    val anyInteger = 34
    val byte: Byte = 13
    val short: Short = 125
    val int: Int = 1231231232
    val long: Long = 12_039_812_487_120_394

    // Floating
    val anyFloat = 42.548
    val float: Float = 13.37F
    val double: Double = 3.14159265

    // Boolean
    val anyBoolean = true
    val boolean: Boolean = false

    // Character
    val anyChar = 'A'
    val char: Char = 'B'

    // String
    val anyString = "Hello World"
    val string: String = "Another string"
    val lastCharOfString: Char = string[string.length - 1]

    // String interpolation
    print("Hello World $myName $mutable")

// Operators
    // Arithmetic operators
    var result = 5 + 3
    result /= 2
    result *= 2
    result += 1
    result -= 1
    var modulo = 15 % 2

    // Forbidden
    // result = 5.0 - 3 (INT cannot became a DOUBLE)
    var resultDouble: Double = 5.0 - result // Better

    // Comparison operators
    val isEqual = 5 == 3
    val isNotEqual = 5 != 3
    val isGreater = 5 > 3
    val isLower = 5 < 3
    val isLowerOrEqual = 5 <= 3

    // Assignement operators
    var myNum = 5
    myNum += 3
    myNum++
    myNum--
    ++myNum // Before of after assignment

// If Statements (can be used as en expression)
    val ifStatement = if (myNum > result) {
        // Do something
        "one"
    } else if (result == myNum) {
        // Do another thing
        "two"
    } else {
        // Do another other thing
        "three"
    }

// When statement (switch)
    var season = 3

    when(season) {
        1 -> println("Spring")
        2 -> println("Summer")
        3 -> {
            println("Fall")
            // More things
        }
        4 -> println("Winter")
        else -> println("No Season")
    }

    var month = 3
    when(month){
        in 3..5 -> println("Spring")
        in 6..8 -> println("Summer")
        in 9..11 -> println("Fall")
        12, 1, 2 -> println("Winter")
        in 20 downTo 13 -> println("Weird")
        !in 40..50 -> println("Not in scope 40-50")
        is Int -> println("$month is an integer")
        else -> println("No Season")
    }


    // While loop
    var x = 1
    while(x <= 10) {
        println("$x")
        x++
    }

    // Do While loop
    do {
        x++
    } while (x <= 10)

    // For loop variations
    for (num in 1..10) {
        println("$num")
    }

    for (num in 1 until 10) {
        println("$num")
    }

    for (num in 10 downTo 1) {
        println("$num")
    }

    for (num in 10 downTo 1 step 2) {
        println("$num")
    }

// Functions
    fun addUp(a: Int, b: Int): Int {
        return a + b;
    }

// Nullables
    var stringOnlyName = "Nicode"
    stringOnlyName = "Denis"
    // aName = null -> Error
    var nullableName: String? = "Nicode"
    nullableName = null // -> work as we use ? in type definition

    var len1 = stringOnlyName.length // -> OK
    // var len2 = nullableName.length -> will throw an error
    var len2 = nullableName?.length // -> OK, will store "null" as value

    // Safe call operator
    nullableName?.let { println(nullableName.length)} // execute only if value is not null

    // Elvis operator
    val name = nullableName ?: "Guest" // Will get nullableName value if not null else Guest

    // nullableName!!.toLowerCase() -> Force to make the pointer not null, will result here in an error cause value is null

    // val myAge: String? = nullableName?.husband?.age ?: 0 chain multiple condition, if not met will result in 0

}



class KotlinBasics {

}