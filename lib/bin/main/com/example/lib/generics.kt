package com.example.lib

fun main(){
    val favoriteNumber = intArrayOf(1,23,45)
    val helloWorld = "kishan"

    val evenNumbers = favoriteNumber.filter { it % 2 == 0 }

}

fun <T> List<T>.myFilter(prediacte: (T) -> Boolean): List<T>{
    val result = mutableListOf<T>()
    for (el in this){
        if(prediacte(el)){
            result.add(el)
        }
    }
    return result
}

sealed class Result<D,E>{
    data class Success<D>(val data:D): Result<D, Nothing>()
    data class Failure<E>(val error:E): Result<Nothing, E>()


}