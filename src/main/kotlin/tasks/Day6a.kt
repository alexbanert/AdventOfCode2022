package tasks

import util.getInput

fun main(args: Array<String>) {

    val line = getInput("6")[0]
    val chars = line.toCharArray().toList()

    var index = 14
    run breaking@{
        chars.windowed(14).forEach {
            if (it.toSet().size == 14) {
                println(index)
                return@breaking
            }
            index++
        }
    }

}
