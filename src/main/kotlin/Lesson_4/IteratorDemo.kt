package Lesson_4

object IteratorDemo {
    @JvmStatic
    fun iteratorTest() {

        val customLinkedList = LinkedListImpl<Any>()
        customLinkedList.addLast(1)
        customLinkedList.addLast(2)
        customLinkedList.addLast(3)
        customLinkedList.addLast(4)
        customLinkedList.addLast(5)
        customLinkedList.addLast(10)

        for (x in customLinkedList) {
            println(x)
        }
        customLinkedList.iterator().hasNext()
    }
}
