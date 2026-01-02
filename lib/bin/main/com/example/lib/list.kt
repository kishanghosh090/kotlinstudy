package com.example.lib

fun main() {
    var multiVal = intArrayOf(1,2,3,4,5,66) + 5 // +5 create a new array object
    multiVal[2] = 3434
    // add new array
    multiVal += 43
    print(multiVal[3])
    val input = intArrayOf(1,23,455)
    val inputAvg = input[0]
    print(inputAvg)
}