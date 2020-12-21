class Queue {
    private val list: MutableList<Int> = mutableListOf()

    fun enqueue(value: Int) = list.add(value)

    fun dequeue() {
        if(!isEmpty()) {
            list.removeAt(0)
        }
    }

    fun peek(): Any {
        if(!isEmpty()) {
            return list[0]
        }
        return "Queue is empty"
    }

    fun getQueue() = list

    fun size() = list.size
    fun isEmpty(): Boolean = list.isEmpty()

}

fun main() {
    var q = Queue()
    for (i in 1..10) {
        q.enqueue(i)
    }
    q.dequeue()
    q.dequeue()
    q.dequeue()
    q.dequeue()
    println(q.size())
    println(q.peek())
    println(q.getQueue())

}