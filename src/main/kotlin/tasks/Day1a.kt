package tasks

import util.getInput
import java.io.File

fun main(args: Array<String>) {

    val lines = getInput("1")

    var max = 0
    var current = 0
    lines.forEach {
        if (it != ""){
            current +=  it.toInt()
        }
        else {
            if (current > max) {
                max = current
                println(max)
            }
            current = 0
        }
    }
    println(max)

}