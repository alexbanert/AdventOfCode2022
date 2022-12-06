package tasks

import util.getInput

fun main(args: Array<String>) {

    val line = getInput("6")[0]
    val chars = line.toCharArray().toList()

    var index = 4
    run breaking@{
        chars.windowed(4).forEach {
            if (it.toSet().size == 4) {
                println(index)
                return@breaking
            }
            index++
        }
    }

}
