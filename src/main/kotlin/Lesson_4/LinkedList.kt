package Lesson_4

interface LinkedList<T> : Iterable<T> {

    fun addFirst(element: T)
    fun addLast(element: T)
    val first: T?
    val last: T?

    operator fun get(index: Int): T?
    fun delete(index: Int)
    fun add(element: T, index: Int)
}
