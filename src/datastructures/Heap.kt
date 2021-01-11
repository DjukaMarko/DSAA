package datastructures
//complete
class Heap(private var maxsize: Int) {
    private var size: Int = 0
    private var arr: IntArray = IntArray(maxsize)

    private fun parent(i: Int): Int = (i-1)/2
    private fun left(i: Int): Int = 2*i +1
    private fun right(i: Int): Int = 2*i + 2
    fun getSize() = size

    fun insert(_key: Int) {
        var i = size

        if(size < maxsize) {
            arr[i] = _key
            size++

            while (i != 0 && arr[parent(i)] < arr[i]) {
                swap(i, parent(i))
                i = parent(i)
            }
        } else {
            println("Heap is full!")
        }

    }

    private fun swap(i: Int, parent: Int) {
        val temp = arr[i]
        arr[i] = arr[parent]
        arr[parent] = temp
    }

    fun printHeap() {
        for(i in arr) {
            println("($i , size: $size, maxsize: $maxsize)")
        }
    }


}

fun main() {
    val ll = Heap(7)
    ll.insert(5)
    ll.insert(2)
    ll.insert(1)
    ll.insert(9)
    ll.insert(8)
    ll.insert(6)
    ll.printHeap()
    println(ll.getSize())

}