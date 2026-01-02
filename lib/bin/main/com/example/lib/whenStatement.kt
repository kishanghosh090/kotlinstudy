package com.example.lib

fun main() {
    val value = readln().toIntOrNull() ?: 0
    val name = when(value){
        1 -> "A+"
        2 -> "A"
        3 -> "B+"
        in 10..20 -> "kk"
        4 -> "B"
        5 -> "C+"
        else -> "null"
    }
    print(name)

    try {
        throw Exception("error")
    }catch (e: Exception){
        print(e.stackTrace)
    }finally {
        print("hello from kishan")
    }

}        
        