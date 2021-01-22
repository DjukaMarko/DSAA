open class Stack<T> {
    private var top: Int = -1
    private val list = mutableListOf<T>()


    open fun isEmpty(): Boolean = top == -1

    open fun push(value: T) {
        list.add(value)
        top++
    }

    open fun pop() = list.removeAt(top--)
}

fun main() {
    val stack = Stack<Int>()
    stack.push(5)
    stack.push(10)

}