package Lesson_4

object CustomLinkedListDemo {
    @JvmStatic
    fun linkedList() {
        val list: LinkedList<Int> = LinkedListImpl()
        println("Empty: $list")
        list.addLast(1)
        list.addLast(2)
        list.addLast(3)
        list.addLast(4)
        println("Filled: $list")
    }
}
