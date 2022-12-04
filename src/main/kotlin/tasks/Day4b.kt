package tasks

import util.getInput

fun main(args: Array<String>) {

    val lines = getInput("4")

    var score = 0
    lines.forEach {
        val split = it.split(",", "-")
        val numbers = split.map { it.toInt() }
        if ((numbers[0] <= numbers[3] && numbers[1] >= numbers[2])) {
            score++
        }
    }
    println(score)

}
