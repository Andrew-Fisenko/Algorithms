package lesson_6

class Node(
    private var value: Int, // node value
    private var left: Node? = null, // left child node
    private var right: Node? = null // right child node
) {
    fun value() = value
    fun changeValue(value: Int) {
        this.value = value
    }

    fun changeLeft(left: Node?) {
        this.left = left
    }
    fun changeRight(right: Node?) {
        this.right = right
    }

    fun leftNode() = left
    fun rightNode() = right
}