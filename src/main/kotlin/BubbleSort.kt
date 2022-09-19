import java.util.Comparator

fun startBubbleSort(size: Int): List<Laptop> {
    val laptopList = createLaptopList(size)
    val comparator : Comparator<Laptop> = LaptopComparator
    val start = System.currentTimeMillis()
    val result = bubbleSort(laptopList, comparator)
    val end = System.currentTimeMillis()
    println("[ Bubble Sort ] Time: " + (end - start) + "ms")
    return result
}

fun bubbleSort(laptops: MutableList<Laptop>, comparator: Comparator<Laptop>): MutableList<Laptop> {
    var sorted = false
    while (!sorted) {
        sorted = true
        for (i in 0 until laptops.size - 1) {
            if (comparator.compare(laptops[i], laptops[i + 1]) == 0) {
                val temp = laptops[i]
                laptops[i] = laptops[i + 1]
                laptops[i + 1] = temp
                sorted = false
            }
        }
    }
    return laptops
}
