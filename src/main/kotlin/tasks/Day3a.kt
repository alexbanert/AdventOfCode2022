package tasks

import util.getInput

fun main(args: Array<String>) {

    val lines = getInput("3")
    var score = 0

    lines.forEach {
        val middle = it.length / 2
        val first = it.substring(0, middle).toCharArray().toSet()
        val second = it.substring(middle).toCharArray().toSet()

        val result = first.intersect(second).first()

        if(result.isUpperCase()){
            score += result.toInt() - 38
        }
        else{
            score += result.toInt() - 96
        }
    }

    println(score)

}
