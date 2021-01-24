package datastructures

class HashMap<K: Any, V: Any>(size: Int) {
   private var arr: Array<LinkedList<V>?> = arrayOfNulls(size)

    init {
        for(i in 0 until size) {
            arr[i] = LinkedList()
        }
    }

    private fun hashFunction(key: K): Int {
        var toAscii = 0
        for(i in key.toString()) {
            toAscii += i.toInt()
        }
        return toAscii
    }

    fun add(key: K, value: V): Int {
        val ll: LinkedList<V>? = arr[hashFunction(key) % arr.size]
        ll?.addAtHead(key, value)
        return hashFunction(key) % arr.size
    }


    infix fun get(key: K): V? {
        val ll: LinkedList<V>? = arr[hashFunction(key) % arr.size]
        var value: V? = null
        if (ll != null) {
            value = getValue(key, ll)
        }
        return value
    }

    private fun getValue(key: K, ll: LinkedList<V>): V {
        var head: Node<V>? = ll.getHead()
        while(head?.key != key) {
            head = head?.next
        }
        return head.value
    }

    fun printTable() = arr.forEach { it?.traverseListPrint() }


    infix fun del(key: K) {
        val ll: LinkedList<V>? = arr[hashFunction(key) % arr.size]
        ll?.removeNode(getValue(key, ll))
    }

}

fun main() {
    val ll = HashMap<Int, String>(10) //string is value. Key is a String by default
    ll.add(5, "f")
    ll.add(6, "g")
    println(ll.get(5))
    ll.del(6)
    ll.printTable()
}

