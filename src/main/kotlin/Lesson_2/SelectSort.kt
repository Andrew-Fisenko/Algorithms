package Lesson_2

import java.util.Comparator

fun startSelectSort(size: Int): List<Laptop> {
    val laptopList = createLaptopList(size)
    val comparator : Comparator<Laptop> = LaptopComparator
    val start = System.currentTimeMillis()
    val result = selectSort(laptopList, comparator)
    val end = System.currentTimeMillis()
    println("[ Select Sort ] Time: " + (end - start) + " ms")
    return result
}

fun selectSort(laptops: MutableList<Laptop>, comparator: Comparator<Laptop>): MutableList<Laptop> {
    val n = laptops.size
    for (i in 0 until n) {
        var min = i
        for (j in n - 1 downTo i) {
            if (comparator.compare(laptops[j], laptops[min]) > 0)
                min = j
        }
        if (i != min) {
            val temp = laptops[i]
            laptops[i] = laptops[min]
            laptops[min] = temp
        }
    }
    return laptops
}
