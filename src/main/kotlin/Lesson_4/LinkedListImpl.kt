package Lesson_4

open class LinkedListImpl<T> : LinkedList<T> {
    inner class Node<T> {
        var value: T
        var next: Node<T>? = null

        constructor(value: T) {
            this.value = value
        }

        constructor(value: T, next: Node<T>?) {
            this.value = value
            this.next = next
        }
    }

    var head: Node<T>? = null
    private val lastNode: Node<T>?
        get() {
            if (head == null) {
                return null
            }
            var last: Node<T> = head as Node<T>
            while (last.next != null) {
                last = last.next!!
            }
            return last
        }

    override fun addLast(element: T) {
        val newLastNode: Node<T> = Node(element)
        if (head == null) {
            head = newLastNode
            return
        }
        val last: Node<T>? = lastNode
        last!!.next = newLastNode
    }

    override fun addFirst(element: T) {
        val newHead: Node<T> = Node(element)
        if (head == null) {
            head = newHead
            return
        }
        newHead.next = head
        head = newHead
    }

    override val first: T?
        get() = extractNodeValue(head)
    override val last: T?
        get() = extractNodeValue(lastNode)

    private fun extractNodeValue(node: Node<T>?): T? {
        return node?.value
    }

    private fun getNode(index: Int): Node<T> {
        requireNotNull(head) { "Index $index out of bounds" }
        var counter = 0
        var currentNode: Node<T> = head as Node<T>
        while (counter != index && currentNode.next != null) {
            currentNode = currentNode.next!!
            counter++
        }
        require(counter == index) { "Index $index out of bounds" }
        return currentNode
    }

    override fun add(element: T, index: Int) {
        if (index == 0) {
            addFirst(element)
        }
        val node: Node<T> = getNode(index - 1)
        val newNextNode: Node<T>? = node.next
        val newNode: Node<T> = Node<T>(element, newNextNode)
        node.next = newNode
    }

    override fun get(index: Int): T? {
        return extractNodeValue(getNode(index))
    }

    override fun delete(index: Int) {
        if (index == 0) {
            requireNotNull(head) { "Index $index out of bounds" }
            head = head!!.next
            return
        }
        val node: Node<T> = getNode(index - 1)
        val nodeForRemove: Node<T> = node.next
            ?: throw IllegalArgumentException("Index $index out of bounds")
        val newNextNode: Node<T>? = nodeForRemove.next
        node.next = newNextNode
    }

    override fun iterator(): Iterator<T> {
        return LinkedListIterator()
    }

    private inner class LinkedListIterator : Iterator<T> {
        private var current: Node<T>? = head
        override fun hasNext(): Boolean {
            return current != null
        }

        override fun next(): T {
            val value: T = current!!.value
            current = current!!.next
            return value
        }
    }

    override fun toString(): String {
        val output = StringBuilder()
        var iterator: Node<T>? = head
        while (iterator != null) {
            output.append(iterator.value).append(" -> ")
            iterator = iterator.next
        }
        if (output.length > 4) {
            output.deleteCharAt(output.length - 1)
            output.deleteCharAt(output.length - 1)
            output.deleteCharAt(output.length - 1)
            output.deleteCharAt(output.length - 1)
        }
        return "[$output]"
    }
}
