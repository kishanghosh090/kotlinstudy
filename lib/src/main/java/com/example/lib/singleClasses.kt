package com.example.lib
fun main(){

}
object  singleClasses: Shape {
    private val age: Float = 12f
    override val area: Float
        get() = age
    override val circum: Float
        get() = age * age
}