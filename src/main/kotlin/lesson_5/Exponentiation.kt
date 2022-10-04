package lesson_5

fun exponentiation(number: Int, degree : Int): Int{
    return if (degree == 1) {
        number
    } else {
        number * exponentiation(number, degree - 1)
    }
}