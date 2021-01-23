package datastructures
/* Linked List by Marko. Feel free to contribute and help me to become a better coder. Happy coding. */

/* This class represents a node which has 3 properties. The value itself, a pointer to the next and to the previous node.
*  @params element which represents a value for our node */
class Node(element: Int) {
    var value: Int = element
    var next: Node? = null
    var previous: Node? = null
    var index: Int? = null
    var key: String? = null /* This property is used for HASHMAP and you do not need to declare values on it everytime you create new nodes */
}


class LinkedList {
    // Head datastructures.Node
    private var head: Node? = null
    var size: Int = 0

    // Size of the linked list
    @JvmName("getSize1")
    fun getSize(): Int = size

    // Find the last node in the list
    private fun findLast(): Node? {
        var node = head

        // If the head is not null traverse the list and find the last node otherwise return null
        return if (node != null) {
            while (node?.next != null) {
                node = node.next
            }
            node

        } else {
            null
        }
    }

    fun addAtHead(key: String, value: Int) {
        val node = Node(value)
        node.key = key
        node.next = head
        head?.previous = node
        head = node

    }

    fun getHead(): Node? = head


    /* Method for adding nodes to the linked list
    *  @params element; for values which are passed to the datastructures.Node class */
    fun addNode(element: Int) {
        val node = findLast()
        val newNode = Node(element)

        /* If the head is null add the datastructures.Node and point the head to it
        *  otherwise add it to the end of the list */
        if (head == null) {
            head = newNode
            head?.index = 0

        } else {
            node?.next = newNode
            newNode.previous = node
            newNode.index = node?.index?.plus(1)
        }
        size++
    }

    fun get(index: Int): Int {
        var node: Node? = head
        val retValue: Int
        if(index == 0) {
            retValue = head!!.value
        } else {
            while (node?.index != index && node?.next != null) {
                node = node.next
            }
            retValue = node!!.value
        }
        return retValue
    }

    fun traverseList(){
        var fNode = head
        var lNode = findLast()

        /* If there is only one node in the list print it
        *  otherwise traverse through every node and print its value.
        *  For reverse printing traverse through every node from the tail to the head and print its value */
        if (fNode?.next == null) {
            println(fNode?.value)
        } else {

            println("Forward traversal: ")
            while (fNode?.next != null) {
                print("${fNode?.value} -> ")
                fNode = fNode?.next
            }
            print(fNode?.value)
            println()

            println("Backwards traversal: ")
            while(lNode?.previous != null) {
                print("${lNode.value} -> ")
                lNode = lNode.previous
            }
            print(lNode?.value)
        }

    }
    fun iterateList(): MutableList<Int> {
        var node: Node? = head
        val arr: MutableList<Int> = mutableListOf()
        while(node?.value != null) {
            arr.add(node.value)
            node = node.next
        }
        return arr
    }

    fun traverseListPrint() {
        var fNode = head

        if (fNode?.next == null) {
            println(fNode?.value)
        } else {

            while (fNode?.next != null) {
                print("${fNode?.value} -> ")
                fNode = fNode?.next
            }
            print(fNode?.value)
            println()
        }
    }

    /* For the given value traverse through the list and find the node with that value */
    fun removeNode(value: Int?) {
        var headNode = head
        var prev = head
        var next = headNode

        // If that value is head then point the head value to its next node and make that node's previous node null
        if(head?.value == value) {
            head = head?.next
            head?.previous = null
        } else {

            /* If that value is not head then traverse through the list and find its previous and next node*/
            while (headNode?.next != null && headNode.value != value) {
                prev = headNode
                headNode = headNode.next
                next = headNode?.next
            }

            // Point the previous node to the next node and vice versa
            prev?.next = next
            next?.previous = prev

        }
        size--
    }
}

fun main() {
    val ll = LinkedList()

    for (i in 1..30) {
        ll.addNode(i)
    }

    ll.traverseList()
    println()
    println("Size: ${ll.getSize()}")
    println()

    ll.removeNode(17)
    ll.removeNode(8)
    ll.removeNode(1)

    ll.traverseList()
    println()
    println("Size: ${ll.getSize()}")

}