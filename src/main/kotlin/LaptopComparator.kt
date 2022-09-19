import java.util.Comparator

class LaptopComparator {

    companion object : Comparator<Laptop> {

        override fun compare(a: Laptop, b: Laptop): Int {
            if (a.price > b.price) {
                return 0;
            } else if (a.price == b.price) {
                if (a.ram > b.ram) {
                    return 0;
                } else if (a.ram == b.ram) {
                    if (a.name.rate > b.name.rate) {
                        return 0;
                    }
                }
            }
            return 1
        }
    }
}
