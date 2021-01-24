package datastructures

import Stack

class Graph(size: Int) {
    private var arr: Array<LinkedList<Int>?> = arrayOfNulls(size)
    init {
        for(i in 0 until size) {
            arr[i] = LinkedList()
        }
    }

    fun addEdge(index: Int, vertex: Int) {
        arr[index]?.addNode(vertex)
    }

    fun printGraph() {
        for (i in arr.indices) {
            println("Vertex $i:")
            for(j in 0 until arr[i]!!.size) {
                println(arr[i]?.get(j))
            }
        }
    }

    private fun getAdjacent(value: Int): MutableList<Int> {
        val rarr: MutableList<Int> = mutableListOf()
        for(i in arr[value]!!.iterateList()) {
            rarr.add(i)
        }

        return rarr
    }

    fun depthFirst(value: Int) {
        val l: MutableList<Int> = mutableListOf()
        val stack: Stack<Int> = Stack()
        stack.push(value)
        while(!stack.isEmpty()) {
            val check = stack.pop()
            if(!l.contains(check)) {
                l.add(check)
                println(check)
            }
            for(i in getAdjacent(check)) {
                if(!l.contains(i)) {
                    stack.push(i)
                }
            }
        }
    }
}

fun main() {
    val graph = Graph(10)
    graph.addEdge(1, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 1)
    graph.addEdge(2, 4)
    graph.addEdge(3, 1)
    graph.addEdge(3, 4)
    graph.addEdge(4, 2)
    graph.addEdge(4, 3)
    graph.printGraph()
    graph.depthFirst(4)
}