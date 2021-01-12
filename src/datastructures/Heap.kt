package datastructures

import kotlin.properties.Delegates

class Heap(private var maxsize: Int) {
    private var size: Int = 0
    private var arr: IntArray = IntArray(maxsize)

    private fun parent(i: Int): Int = (i-1)/2
    private fun left(i: Int): Int = 2*i +1
    private fun right(i: Int): Int = 2*i + 2
    fun peek(): Int = arr[0]
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

    private fun extractMax(): Int {
        val value: Int = arr[0]
        arr[0] = arr[size--]
        maxHeapify(0)
        return value
    }

    private fun maxHeapify(pos: Int) {
        if(isLeaf(pos)) {
            return
        }
        if(arr[pos] < arr[left(pos)] || arr[pos] < arr[right(pos)]) {
            if(arr[left(pos)] > arr[right(pos)]) {
                swap(pos, left(pos))
                maxHeapify(left(pos))
            } else {
                swap(pos, right(pos))
                maxHeapify(right(pos))
            }

        }
    }

    fun delete(_i: Int) {
        var i = _i
        arr[i] = Int.MAX_VALUE
        while (i != 0 && arr[parent(i)] < arr[i]) {
            swap(i, parent(i))
            i = parent(i)
        }
        extractMax()
    }

    private fun isLeaf(pos: Int): Boolean {
        var bool by Delegates.notNull<Boolean>()
        bool = pos > maxsize/2 && pos <= maxsize
        return bool
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
    println()
    ll.delete(4)
    ll.printHeap()

    println(ll.peek())
    println(ll.getSize())
}