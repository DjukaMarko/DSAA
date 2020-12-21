open class Stack {
    private var top: Int = -1
    private val list = mutableListOf<Any>()


    open fun isEmpty(): Boolean = top == -1

    open fun push(value: Any) {
        list.add(value)
        top++
    }

    open fun pop() = list.removeAt(top--)
}

fun main() {
    val stack = Stack()
    stack.push(5)
    stack.push(10)

}