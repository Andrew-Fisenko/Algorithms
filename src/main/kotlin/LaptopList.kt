import java.util.*

fun createLaptopList(size: Int): MutableList<Laptop> {
    val laptops = mutableListOf<Laptop>()

    val brands: Array<Brands> = Brands.values()
    val prices = listOf(100, 200, 300, 400, 500, 600, 700)
    val ram = listOf(4, 8, 16, 20, 24)

    var n = 0
    while (n < size) {
        laptops.add(
            Laptop(
                brands[Random().nextInt(5)],
                ram[Random().nextInt(5)],
                prices[Random().nextInt(7)]
            )
        )
        n++
    }
    return laptops
}

fun printList(laptops: List<Laptop>) {
    var i = 0
    while (i < laptops.size) {
        println("[${laptops[i].name}, ${laptops[i].ram}, ${laptops[i].price}]")
        i++
    }
    println()
}