package Lesson_2


import java.util.Comparator

fun startInsertSort(size: Int): List<Laptop> {
    val laptopList = createLaptopList(size)
    val comparator : Comparator<Laptop> = LaptopComparator
    val start = System.currentTimeMillis()
    val result = insertSort(laptopList, comparator)
    val end = System.currentTimeMillis()
    println("[ Insert Sort ] Time: " + (end - start) + " ms")
    return result
}

fun insertSort(laptops: MutableList<Laptop>, comparator: Comparator<Laptop>): MutableList<Laptop> {
    if (laptops.isEmpty() || laptops.size < 2) {
        return laptops
    }
    for (count in 1 until laptops.count()) {
        val item = laptops[count]
        var i = count
        while (i > 0 && comparator.compare(item, laptops[i - 1]) > 0) {
            laptops[i] = laptops[i - 1]
            i -= 1
        }
        laptops[i] = item
    }
    return laptops
}