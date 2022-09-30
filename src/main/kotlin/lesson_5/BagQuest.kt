package lesson_5

import kotlin.random.Random

class Thing(
    val weight: Int,
    val price: Int
)

class Bag(
    val size: Int
)

fun bagQuest() {

    val bag = Bag(20)
    val things = mutableListOf<Thing>()
    val numbers = 5

    repeat(numbers) {
        things.add(Thing((Random.nextInt(1, 10)), Random.nextInt(1, 10)))
    }

    printThings(things)
    println(fillTheBag(things, numbers-1, bag.size))
    println()
}

fun fillTheBag(things: MutableList<Thing>, numbers : Int, bag: Int): Int {
     if (bag < 0) {
        return Int.MIN_VALUE
    }
    if (numbers < 0 || bag  == 0) {
        return 0
    }
    val include = things[numbers].price + fillTheBag(things, numbers - 1, bag - things[numbers].weight)
    val exclude = fillTheBag(things, numbers - 1, bag)

    return Integer.max(include, exclude)
}

fun printThings(things: MutableList<Thing>) {
    for (i in things) {
        println("[Weight ${i.weight}, Price ${i.price}]")
    }
    println()
}