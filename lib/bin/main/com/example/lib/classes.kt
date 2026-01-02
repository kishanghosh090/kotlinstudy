package com.example.lib

import kotlin.math.PI

fun main(){
    val r1 = Rectangle(2,4)
    println(r1.height)
    println(r1.width)
    println(myData("kishan",20))
    println(Country.FRANCE)

}

object DateUtil {
    fun formDate(){}
}
enum class Country {
    GERMANY,FRANCE,USA
}
class Rectangle(val width: Int, val height: Int){
    fun getArea(): Int{
        return this.width * this.height
    }

    private val str: List<Int> = mutableListOf()
}

//abstract class Shape {
//    abstract val area: Float
//    abstract  val circum: Float
//}

// sealed is only be used in current module
sealed  interface Shape{
    val area: Float
    val circum: Float
}
fun sumAreas(vararg shapes: Shape): Double {
    return shapes.sumOf {
        it.area.toDouble()
    }
}

data class myData(
    val name: String,
    val age: Int
)
data class Circle(
    val radius: Int,
): Shape{
    override val area: Float = PI.toFloat() * (radius*radius)
    override val circum: Float = 2 * (radius.toFloat() * PI).toFloat()
    val getVal: Float = 2f
}














