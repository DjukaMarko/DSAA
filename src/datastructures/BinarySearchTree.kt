class NodeB(element: Int) {
    var key: Int = element
    var left: NodeB? = null
    var right: NodeB? = null

}

class BinarySearchTree {

    var root: NodeB? = null

    fun insert(key: Int) {
        root = insertNode(root, key)
    }


    private fun insertNode(_root: NodeB?, key: Int): NodeB? {
        var root: NodeB? = _root
        if (root == null) {
            root = NodeB(key)
            return root
        }

        if (key > root.key) {
            root.right = insertNode(root.right, key)
        } else if (key < root.key) {
            root.left = insertNode(root.left, key)
        }
        return root

    }

    fun inOrder() {
        inOrderRec(root)
    }

    private fun inOrderRec(root: NodeB?) {
        if (root != null) {
            inOrderRec(root.left)
            println(root.key)
            inOrderRec(root.right)
        }
    }

    fun delete(key: Int) {
        deleteRec(root, key)
    }

    private fun deleteRec(_root: NodeB?, key: Int): NodeB? {
        var root: NodeB? = _root ?: return null
        when {
            root?.key!! < key -> {
                root.right = deleteRec(root.right, key)
            }
            root.key > key -> {
                root.left = deleteRec(root.left, key)
            }
            else -> {
                when {
                    root.left == null -> {
                        root = root.right
                    }
                    root.right == null -> {
                        root = root.left
                    }
                    else -> {
                        var temp: NodeB = findMin(root.right!!)
                        root.key = temp.key
                        root.right = deleteRec(root.right, root.key)

                    }
                }
            }
        }
        return root

    }

    private fun findMin(_root: NodeB): NodeB {
        var root: NodeB = _root
        while(root.left != null) {
            root = root.left!!
        }
        return root
    }
}

fun main() {
    var b = BinarySearchTree()
    b.insert(5)
    b.insert(4)
    b.insert(3)
    b.insert(6)
    b.insert(7)
    b.inOrder()
    b.delete(5)
    b.delete(6)
    println()
    b.inOrder()
}