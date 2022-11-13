package io.nicode.a1_first_app

fun main() {
// Arrays
    val numbers: IntArray = intArrayOf(0, 1, 2, 3, 4, 5)
    val numbersTwo = intArrayOf(0, 1, 2, 3, 4, 5) // Type inference
    val numbersThree = arrayOf(0, 1, 2, 3, 4, 5) // It's just an array now

    // Utilities
    // print(numbers.contentToString()) - print all elements
    // for (element in numbers) print(element) - loop trough array's elements
    // numbers[6] = 8 -> Error cause arrays have fixed size

    // Data class array
    val fruits = arrayOf(Fruit("Apple", 2.5), Fruit("Grape", 3.5))
    println("Array content: ${fruits.contentToString()}")
    for (index in fruits.indices) println("Element @ index in array: ${fruits[index].name} is in index $index")
    for (fruit in fruits) print("\n$fruit")

    // Arrays of mixed values
    val mix = arrayOf("Sun", "Mon", 1, 2, Fruit("Banana", 1.5))
    println("Mixed values array: ${mix.contentToString()}")

// Lists
    // Immutable
    val monthList = listOf("January", "February", "March")
    val anyTypesList = listOf<Any>(1, 2, 3, true, false, "String")

    println("Size: ${anyTypesList.size}")
    println("Print one element of list: ${monthList[1]}")

    // Mutable
    // Convert to mutable list a immutable element
    // also works with other type of immutable collections
    val addMonthList = monthList.toMutableList()
    val newMonths = arrayOf("April", "May", "June")
    // Add multiple values
    addMonthList.addAll(newMonths)
    // Add single value
    addMonthList.add("July")
    println("Mutable list: $addMonthList")

    val mutableList = mutableListOf("Mon", "Tue", "Wed")
    // Remove target index
    mutableList.removeAt(1)
    // Replace value
    mutableList[1] = "Fri"
    println("Mutable list days: $mutableList")
    mutableList.remove("Tue")
    // Remove all elements
    mutableList.removeAll(mutableList)
    println("Mutable list days: $mutableList")

// Sets (eliminate duplicate data)
    val fruitsSet = setOf("Orange", "Apple", "Grape", "Apple")
    println("Fruits set size: ${fruitsSet.size}") // 3
    // Sort values
    println("Fruits set size: ${fruitsSet.toSortedSet()}")

// Maps (hashMap/Dictionary in other languages
    val daysMap = mapOf(1 to "Monday", 2 to "Tuesday", 3 to "Wednesday", 4 to "Tuesday")
    // Access map item
    println(daysMap[2])
    // Loop through map
    for (key in daysMap.keys) println("$key is ${daysMap[key]}")
    // Map class
    val fruitClassMap = mapOf("Favorite" to Fruit("Apple", 2.5), "Yummy" to Fruit("Grape", 3.5))
    for (key in fruitClassMap.keys) println("$key is ${fruitClassMap[key]}")
    // Mutable map
    val daysMutableMap = daysMap.toMutableMap()
    daysMutableMap[2] = "Friday"
    // Loop
    for (key in daysMutableMap.keys) println("$key is ${daysMutableMap[key]}")
    // Sort
    println(daysMutableMap.toSortedMap())

// ArraysLists - Dynamic arrays
    val theArrayList = ArrayList<String>()
    // Add elements
    theArrayList.add("One")
    theArrayList.add("Two")
    println(theArrayList)

    // Get element
    println(theArrayList[0])

    // Loop
    for (i in theArrayList) println(i)

    val sizedArrayList: ArrayList<String> = ArrayList<String>(5)
    val mutableToAdd: MutableList<String> = mutableListOf()
    mutableToAdd.add("One")
    mutableToAdd.add("Two")
    mutableToAdd.add("Three")
    mutableToAdd.add("Four")
    mutableToAdd.add("Five")
    mutableToAdd.add("Six")

    // Merge mutable into ArrayList
    sizedArrayList.addAll(mutableToAdd)
    println(sizedArrayList)

    // Iterator
    val itr = sizedArrayList.iterator()
    // Loop with iterator
    while (itr.hasNext()) {
        println(itr.next())
    }
    println("Size of sizedArrayList: ${sizedArrayList.size}")

    // Calculate average value of an Int ArrayList
    val exoArray = ArrayList<Int>()
    val items = mutableListOf(1, 2, 3, 4)
    exoArray.addAll(items)
    var avg: Int
    var total: Int = 0
    for (i in exoArray) {
        total += i
    }
    avg = total / exoArray.size
    println("Avg value of exoArray is: $avg")

// Lambda expression
    val sum = { a: Int, b: Int -> println(a + b) }
    sum(2, 3)

    // Exception handler
    fun getNumber(str: String): Int {
        return try {
            Integer.parseInt(str)
        } catch (e: java.lang.ArithmeticException) {
            0
        } catch (e: java.lang.NumberFormatException) {
            0
        }
    }
    println(getNumber("10"))
    println(getNumber("Hi")) // -> 0 and not error raise
}

data class Fruit(val name: String, val price: Double)