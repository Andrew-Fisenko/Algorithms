import java.util.*

fun sortFun() {

    val from = 0
    val to = 101
    val data = IntArray(10) { Random().nextInt(to - from) + from }

    println("Original list: ${data.toList()}")

//    println("Ordered  list: ${sortBubble(data).contentToString()}")
//    println("Ordered  list: ${sortSelect(data).contentToString()}")
//    println("Ordered  list: ${sortInsertion(data).contentToString()}")
 }

fun sortBubble(data: IntArray): IntArray {
    var sorted = false
    while (!sorted) {
        sorted = true
        for (i in 0 until data.size - 1) {
            if (data[i] > data[i + 1]) {
                val temp = data[i]
                data[i] = data[i + 1]
                data[i + 1] = temp
                sorted = false
            }
        }
    }
    return data
}

fun sortSelect(data: IntArray): IntArray {
    val n = data.size
    for (i in 0..n - 1) {
        var min = i
        for (j in n - 1 downTo i) {
            if (data[j] < data[min])
                min = j
        }
        if (i != min) {
            val temp = data[i]
            data[i] = data[min]
            data[min] = temp
        }
    }
    return data
}

fun sortInsertion(data: IntArray): IntArray {
    if (data.isEmpty() || data.size < 2) {
        return data
    }
    for (count in 1 until data.count()) {
        val item = data[count]
        var i = count
        while (i > 0 && item < data[i - 1]) {
            data[i] = data[i - 1]
            i -= 1
        }
        data[i] = item
    }
    return data
}

fun sortQuick(items: List<Int>): List<Int> {
    if (items.count() < 2) {
        return items
    }
    val base = items[items.count() / 2]

    val equal = items.filter { it == base }
    val less = items.filter { it < base }
    val greater = items.filter { it > base }

    return sortQuick(less) + equal + sortQuick(greater)
}

fun fac(n: Int): Int =
    when (n) {
        0 -> 1
        else -> n * fac(n - 1)
    }

fun fibonacci(n: Int, a: Int = 0, b: Int = 1): Int =
    when (n) {
        0 -> a
        1 -> b
        else -> fibonacci(n - 1, b, a + b)
    }
