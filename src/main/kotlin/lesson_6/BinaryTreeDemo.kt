package lesson_6

fun binaryTreeDemo() {
    val tree: BinaryTree = BinaryTree()

    tree.add(8)
    tree.add(3)
    tree.add(1)
    tree.add(6)
    tree.add(4)
    tree.add(7)
    tree.add(10)
    tree.add(14)
    tree.add(13)

    println(tree.dfs()) // [8, 3, 1, 6, 4, 7, 10, 14, 13]

    println(tree.contains(6)) // true
    println(tree.contains(5)) // false

    tree.remove(4)
    println(tree.dfs()) // [8, 3, 1, 6, 7, 10, 14, 13]

    println(tree.isBalanced()) // false

    tree.add(9)
    println(tree.isBalanced()) // true

    tree.add(12)
    println(tree.isBalanced()) // false

    println(tree.dfs()) // [8, 3, 1, 6, 4, 7, 10, 9, 14, 13, 12]
}
