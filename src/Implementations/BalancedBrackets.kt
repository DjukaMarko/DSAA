package Implementations

import Stack
import kotlin.properties.Delegates

class BalancedBrackets: Stack<Any>() {
    private val dict: Map<Char, Char> = mapOf('(' to ')', '{' to '}', '[' to ']')
    private var stack = Stack<Char>()

    fun isBalanced(value: String): Boolean {
        var check by Delegates.notNull<Boolean>()
        for (i in value.indices) {

            if(value[i] in "{[(") {
                stack.push(value[i])
            }

            if (value[i] in "}])") {
                var checkChar = if (!stack.isEmpty()) stack.pop() else ""
                var rValue = value[i]
                check = rValue == dict[checkChar]

                if(!check) {
                    break
                }
            }

            check = stack.isEmpty()

        }
        return check

    }

}

fun main() {
    var ss = BalancedBrackets()
    println(ss.isBalanced("{}[[(())]]{}"))
}