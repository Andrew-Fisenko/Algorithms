package Lesson_3

import java.util.*

fun queue() {

    val array = createTestArray(100)
    println(array)

    val test1 = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16)
    val test2 = arrayListOf<Int>(1, 2, 4, 5, 6)
    val test3 = arrayListOf<Int>(2, 3, 4, 5, 6, 7, 8)
    val test4 = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
    val test5 = arrayListOf<Int>()

    println(findElement(array))
}

fun findElement(array: ArrayList<Int>): String {
    if (array.size <= 2) {
        return "Lost Number = 1"
    } else {
        for (i in array) {
            if (array.indexOf(i) == array.size - 1) {
                return "There are no lost numbers!" // Unexpected case
            } else if (array[array.indexOf(i) + 1] - i != 1) {
                return "Lost Number = ${i + 1}"
            }
        }
    }
    return "There are no lost numbers!"
}

fun createTestArray(size: Int): ArrayList<Int> {
    val array: ArrayList<Int> = ArrayList()
    var lostNum = 1
    if (size != 1) { // If size == 1 array has one element == 2 (lost element == 1)
        lostNum = Random().nextInt(size)
    }
    var n = 0
    while (n < size) {
        if (n != lostNum - 1) {
            array.add(n + 1)
            n++
        } else {
            n++
            array.add(n + 1)
            n++
        }
    }
    println("Lost Number = $lostNum")
    return array
}


