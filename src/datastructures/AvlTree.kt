package datastructures

import java.lang.Integer.max
import kotlin.math.abs

class NodeB(element: Int) {
    var key: Int = element
    var left: NodeB? = null
    var right: NodeB? = null
    var height: Int = 0

}

class AvlTree {

    private var root: NodeB? = null

    private fun height(root: NodeB?): Int {
        return root?.height ?: return 0
    }

    private fun getBalance(root: NodeB?): Int {
        return if(root == null) return 0 else (height(root.left) - height(root.right))
    }

    fun insert(key: Int) {
        root = insertNode(root, key)
    }


    fun isBalanced(): Boolean {
        return isBalancedRec(root)
    }

    private fun isBalancedRec(root: NodeB?): Boolean {
        val balance: Int = getBalance(root)
        return if(root == null) {
            true
        } else {
            abs(balance) <= 1 && isBalancedRec(root.left) && isBalancedRec(root.right)
        }
    }

    private fun insertNode(_root: NodeB?, key: Int): NodeB {
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

        root.height = 1 + max(height(root.left), height(root.right))
        val balance: Int = getBalance(root)

        when {
            balance > 1 && key < root.left!!.key -> {
                return rotateRight(root)
            }
            balance < -1 && key > root.right!!.key -> {
                return rotateLeft(root)
            }
            balance > 1 && key > root.left!!.key -> {
                root.left = rotateLeft(root.left!!)
                return rotateRight(root)

            }
            balance < -1 && key < root.right!!.key -> {
                root.right = rotateRight(root.right!!)
                return rotateLeft(root)
            }
        }
        return root

    }

    private fun rotateLeft(root: NodeB): NodeB {
        val newParent: NodeB = root.right!!
        root.right = newParent.left
        newParent.left = root

        root.height = 1 + max(height(root.left), height(root.right))
        newParent.height = 1 + max(height(newParent.left), height(newParent.right))

        return newParent

    }

    private fun rotateRight(root: NodeB): NodeB {
        val newParent: NodeB = root.left!!
        root.left = newParent.right
        newParent.right = root

        root.height = 1 + max(height(root.left), height(root.right))
        newParent.height = 1 + max(height(newParent.left), height(newParent.right))

        return newParent
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
                        val temp: NodeB = findMin(root.right!!)
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
    val b = AvlTree()
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
    println(b.isBalanced())
}