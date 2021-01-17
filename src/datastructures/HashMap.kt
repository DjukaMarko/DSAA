package datastructures

import LinkedList
import Node


class HashMap(var size: Int) {
   var arr: Array<LinkedList?> = arrayOfNulls(size)

    init {
        for(i in 0 until size) {
            arr[i] = LinkedList()
        }
    }

    private fun hashFunction(key: String): Int {
        var toAscii = 0
        for(i in key) {
            toAscii += i.toInt()
        }
        return toAscii
    }

    fun add(key: String, value: Int?): Int {
        val index: Int = hashFunction(key) % arr.size
        var ll: LinkedList? = arr[index]
        ll?.addAtHead(key, value)
        return index
    }

    infix fun get(key: String): Int? {
        val index: Int = hashFunction(key) % arr.size
        var ll: LinkedList? = arr[index]
        var head: Node? = ll?.getHead()
        while(head?.key != key) {
            head = head?.next
        }
        return head.value
    }

    fun printTable() = arr.forEach { it?.traverseListPrint() }


    infix fun del(key: String) {
        val index: Int = hashFunction(key) % arr.size
        var ll: LinkedList? = arr[index]
        var head: Node? = ll?.getHead()
        while(head?.key != key) {
            head = head?.next
        }
        ll?.removeNode(head.value)

    }

}

fun main() {
    var ll = HashMap(10)
    ll.add("marko", 6)
    ll.add("petar", 82)
    ll.add("maria", 143)
    ll.add("orkam", 23)
    ll.add("ilija", 4)
    ll.add("marko", 6)
    ll.add("ilija", 4)
    ll.add("marko", 6)
    ll.add("ilija", 4)
    println(ll get "orkam")
    ll del "marko"
    ll.printTable()
}

