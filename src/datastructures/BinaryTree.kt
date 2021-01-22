import BinaryTree.Companion.inOrder
import BinaryTree.Companion.root

class BNode(value: Int) {
    var key: Int = value
    var left: BNode? = null
    var right: BNode? = null
}

class BinaryTree {

    companion object {
        var root: BNode? = null

        fun inOrder() {
            inOrderRec(root)
        }

        private fun inOrderRec(root: BNode?) {
            if(root != null) {
                inOrderRec(root.left)
                println(root.key)
                inOrderRec(root.right)
            }
        }
    }
}

fun main() {
    root = BNode(3)
    root?.left = BNode(4)
    root?.left?.left = BNode(5)
    inOrder()
}