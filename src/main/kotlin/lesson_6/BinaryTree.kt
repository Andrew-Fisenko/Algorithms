package lesson_6

class BinaryTree {

    private var root: Node? = null

    fun add(value: Int) {
        fun addRec(current: Node?, value: Int) : Node {
            if (current == null) {
                return Node(value)
            }
            if (value < current.value()) {
                current.changeLeft(addRec(current.leftNode(), value))
            } else if (value > current.value()) {
                current.changeRight(addRec(current.rightNode(), value))
            }
            return current
        }
        root = addRec(root, value)
    }

    fun isEmpty() = root == null

    fun remove(value: Int) {
        fun smallestValue(root: Node) : Int {
            return if (root.leftNode() == null) root.value() else smallestValue(root.leftNode()!!)
        }
        fun removeRec(current: Node?, value: Int) : Node? {
            if (current == null) {
                return null
            }
            if (value == current.value()) {
                if (current.leftNode() == null && current.rightNode() == null) {
                    return null
                }
                if (current.leftNode() == null) {
                    return current.rightNode()
                }
                if (current.rightNode() == null) {
                    return current.leftNode()
                }
                val smallestValue = smallestValue(current.rightNode()!!)
                current.changeValue(smallestValue)
                current.changeRight(removeRec(current.rightNode(), smallestValue))
                return current
            }
            if (value < current.value()) {
                current.changeLeft(removeRec(current.leftNode(), value))
            } else {
                current.changeRight(removeRec(current.rightNode(), value))
            }
            return current
        }
        root = removeRec(root, value)
    }

    fun contains(value: Int) : Boolean {
        fun containsRec(current: Node?, value: Int) : Boolean {
            if (current == null) {
                return false
            }
            if (value == current.value()) {
                return true
            }
            return if (value < current.value()) {
                containsRec(current.leftNode(), value)
            } else {
                containsRec(current.rightNode(), value)
            }
        }
        return containsRec(root, value)
    }

    // traversal of the binary tree in depth
    fun dfs() : List<Int> {
        fun traversePreOrderRec(node: Node?, nodes: MutableList<Int>) {
            if (node != null) {
                nodes.add(node.value())
                traversePreOrderRec(node.leftNode(), nodes)
                traversePreOrderRec(node.rightNode(), nodes)
            }
        }
        return mutableListOf<Int>().apply {
            traversePreOrderRec(root, this)
        }
    }

    // traversal of the binary tree in breadth
    fun bfs() : List<Int> {
        val root = this.root ?: return listOf()
        val queue = java.util.LinkedList<Node>()
        queue.add(root)
        val items = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            val node = queue.remove()
            items.add(node.value())
            node.leftNode()?.let(queue::add)
            node.rightNode()?.let(queue::add)
        }
        return items
    }

    fun isBalanced(): Boolean {
        return isBalanced(root, 0).first
    }

    private fun isBalanced(node: Node?, currDepth: Int): Pair<Boolean, Int> {
        if (node == null) return Pair(true, currDepth)

        val (leftBalanced, leftDepth) = isBalanced(node.leftNode(), currDepth + 1)
        val (rightBalanced, rightDepth) = isBalanced(node.rightNode(), currDepth + 1)
        val isBalanced = rightBalanced && leftBalanced && (leftDepth - rightDepth in -1..1)
        val maxDepth = maxOf(leftDepth, rightDepth)

        return Pair(isBalanced, maxDepth)
    }
}
