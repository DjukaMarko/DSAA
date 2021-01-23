package datastructures
class HashNode<T, J>(element: T) : Node<T>(element) {


}
class HashLinkedList<T, J>: LinkedList<T>() {

    fun addAtHead(key: String, value: T) {
        val node = Node(value)
        node.key = key
        node.next = head
        head?.previous = node
        head = node
    }

}

class HashMap<T, J>(size: Int) {
   private var arr: Array<HashLinkedList<T, J>?> = arrayOfNulls(size)

    init {
        for(i in 0 until size) {
            arr[i] = HashLinkedList()
        }
    }

    private fun hashFunction(key: T): Int {
        var toAscii = 0
        for(i in key) {
            toAscii += i.toInt()
        }
        return toAscii
    }

    fun add(key: T, value: J): Int {
        val ll: HashLinkedList<T, J>? = arr[hashFunction(key) % arr.size]
        ll?.addAtHead(key, value)
        return hashFunction(key) % arr.size
    }


    infix fun get(key: String): Int? {
        val ll: LinkedList<T>? = arr[hashFunction(key) % arr.size]
        var value: Int? = null
        if (ll != null) {
            value = getValue(key, ll)
        }
        return value
    }

    private fun getValue(key: T, ll: HashLinkedList<T, J>): T {
        var head: Node<T>? = ll.getHead()
        while(head?.key != key) {
            head = head?.next
        }
        return head.value
    }

    fun printTable() = arr.forEach { it?.traverseListPrint() }


    infix fun del(key: T) {
        val ll: HashLinkedList<T, J>? = arr[hashFunction(key) % arr.size]
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

