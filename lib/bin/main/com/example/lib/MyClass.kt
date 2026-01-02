package com.example.lib

fun main(){
    print("hello form kishan")
    val num = readln().toFloatOrNull()
    val isActive = false
    val input = readln()
    val input2 = readln().toIntOrNull() ?: 0

    val isEven = input2?.rem(2) == 0
    2.inc()

    var x = 34
    val y = 2323
    x++
    print(x)

    if(num != null && !isActive){
        print(num+2)
    }

}
interface  a {
    fun add(a: Int, b: Int): Int
}
class A : a {
    override fun add(a: Int, b: Int): Int {
        return a+b
    }
}