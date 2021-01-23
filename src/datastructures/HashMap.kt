package datastructures

class HashMap(size: Int) {
   private var arr: Array<LinkedList?> = arrayOfNulls(size)

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

    fun add(key: String, value: Int): Int {
        val ll: LinkedList? = arr[hashFunction(key) % arr.size]
        ll?.addAtHead(key, value)
        return hashFunction(key) % arr.size
    }


    infix fun get(key: String): Int? {
        val ll: LinkedList? = arr[hashFunction(key) % arr.size]
        var value: Int? = null
        if (ll != null) {
            value = getValue(key, ll)
        }
        return value
    }

    private fun getValue(key: String, ll: LinkedList): Int {
        var head: Node? = ll.getHead()
        while(head?.key != key) {
            head = head?.next
        }
        return head.value
    }

    fun printTable() = arr.forEach { it?.traverseListPrint() }


    infix fun del(key: String) {
        val ll: LinkedList? = arr[hashFunction(key) % arr.size]
        ll?.removeNode(getValue(key, ll))
    }

}

fun main() {
    val ll = HashMap(10)
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

