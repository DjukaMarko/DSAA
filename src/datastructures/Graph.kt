package datastructures

import LinkedList
import Stack

class Graph(var size: Int) {
    private var arr: Array<LinkedList?> = arrayOfNulls(size)
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
        var rarr: MutableList<Int> = mutableListOf()
        for(i in arr[value]!!.iterateList()) {
            rarr.add(i)
        }

        return rarr
    }

    fun depthFirst() {
        var l: MutableList<Int> = mutableListOf()
        var stack: Stack<Int> = Stack()
        stack.push(arr[0]!!.get(0))
        while(!stack.isEmpty()) {
            var check = stack.pop()
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
    var graph = Graph(5)
    graph.addEdge(0, 3)
    graph.addEdge(0, 5)
    graph.addEdge(2, 7)
    graph.printGraph()
    graph.depthFirst()
}