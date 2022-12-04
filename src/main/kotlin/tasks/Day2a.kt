package tasks

import util.getInput
import java.io.File

fun main(args: Array<String>) {

    val lines = getInput("2")
    var score = 0
    lines.forEach {
        when (it) {
            "A X" -> score += (3 + 1)
            "A Y" -> score += (6 + 2)
            "A Z" -> score += (0 + 3)
            "B X" -> score += (0 + 1)
            "B Y" -> score += (3 + 2)
            "B Z" -> score += (6 + 3)
            "C X" -> score += (6 + 1)
            "C Y" -> score += (0 + 2)
            "C Z" -> score += (3 + 3)
        }
    }
    println(score)

}