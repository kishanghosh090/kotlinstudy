package com.example.lib

fun main(){
    val input = readln()

    val latterOnly = input.filter { it.isLetter() }
    print(latterOnly)

    val lambda: (Char) -> Boolean = {
        it.isLetter()
    }
    val numbers = input.filter { lambda(it) }
    print(numbers)

}
// create a lambda fun
val add: (Int, Int) -> Int = {a,b -> a+b}
//fun String.myfilter(predicate: (Char) -> Boolean) : String {
//    return  buildString {
//        for(char in this@myfilter) {
//            if (predicate(char)) {
//                append(char)
//            }
//        }
//    }
//}
fun String.myfilter(predicate: Char.() -> Boolean) : String {
    return  buildString {
        for(char in this@myfilter) {
            if (char.predicate()) {
                append(char)
            }
        }
    }
}