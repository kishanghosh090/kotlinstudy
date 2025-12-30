package com.example.lib

fun main(){
    var i = 0
    while (i <= 10){
        print(i)
        print(" ")
        i++
    }
    val numbs = mutableListOf<Int>()
    numbs += 1
    numbs += 2
    numbs += 3
    numbs += 4
    numbs += 5
    numbs += 6
    numbs += 7

    print(numbs)
    print("hello from kishan".lengthMy())
    print("hello from kishan".rev())
}

fun String.rev(): String{
   return buildString {
        for (i in this@rev.length - 1 downTo 0){
            append(this@rev[i])
        }
    }
}

fun String.lengthMy(): Int {
    return this.length
}