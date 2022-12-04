package tasks

import util.getInput

fun main(args: Array<String>) {

    val lines = getInput("3")
    var score = 0

    lines.chunked(3).forEach {

        val result = it[0].toCharArray().toSet().intersect(it[1].toCharArray().toSet().intersect(it[2].toCharArray().toSet())).first()
        score += if (result.isUpperCase()) {
            result.toInt() - 38
        } else {
            result.toInt() - 96
        }
    }

    println(score)

}
