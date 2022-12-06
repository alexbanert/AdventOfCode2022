package tasks

import util.getInput

fun main(args: Array<String>) {

    val line = getInput("6")[0]
    val chars = line.toCharArray().toList()

    val windowSize = 14
    var index = windowSize
    run breaking@{
        chars.windowed(windowSize).forEach {
            if (it.toSet().size == windowSize) {
                println(index)
                return@breaking
            }
            index++
        }
    }

}
