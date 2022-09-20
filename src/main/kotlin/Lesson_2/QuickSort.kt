package Lesson_2

import java.util.Comparator

fun startQuickSort(size: Int): List<Laptop> {
    val laptopList = createLaptopList(size)
    val start = System.currentTimeMillis()
    val result = quickSort(laptopList)
    val end = System.currentTimeMillis()
    println("[ Quick  Sort ] Time: " + (end - start) + " ms")
    return result
}

fun quickSort(laptops: List<Laptop>): List<Laptop> {
    val comparator : Comparator<Laptop> = LaptopComparator
    if (laptops.count() < 2) {
        return laptops
    }
    val base = laptops[laptops.count() / 2]

    val equal = laptops.filter { it == base }
    val less = laptops.filter { comparator.compare(it, base) == 1 && it != base }
    val greater = laptops.filter { comparator.compare(it, base) == 0 }

    return quickSort(less) + equal + quickSort(greater)
}

