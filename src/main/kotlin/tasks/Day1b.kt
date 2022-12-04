package tasks

import util.getInput

fun main(args: Array<String>) {

    val lines = getInput("1")
    val elves = ArrayList<Int>()


    var current = 0
    lines.forEach {
        if (it != "") {
            current += it.toInt()
        } else {
            elves.add(current)
            current = 0
        }
    }

    elves.sortDescending()

    println(elves.slice(0..2).sum())

}