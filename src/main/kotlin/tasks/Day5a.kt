package tasks

import util.getInput

fun main(args: Array<String>) {

    val lines = getInput("5")

    val length = (lines[0].length - 3) / 4 + 1

    val stacks = List(length) { ArrayDeque<Char>() }

    run breaking@{
        lines.forEach {
            if (it == "") {
                return@breaking
            }
            for (i in 1..it.length step 4) {
                if (it[i].isLetter()) {
                    stacks[i / 4].addLast(it[i])
                }
            }
        }
    }

    lines.forEach {
        if (it.startsWith("move")) {
            val split = it.split(" ")
            for (i in 1..split[1].toInt()) {
                stacks[split[5].toInt() - 1].addFirst(stacks[split[3].toInt() - 1].removeFirst())
            }
        }
    }

    var result = ""
    stacks.forEach {
        result += it.first()
    }

    println(result)
}
