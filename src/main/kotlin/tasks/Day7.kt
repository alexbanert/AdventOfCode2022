package tasks

import util.getInput

abstract class Node(val name: String, var size: Int)

class File(name: String, size: Int) : Node(name, size)

class Directory(name: String, size: Int, var children: MutableList<Node>) : Node(name, size)


fun main(args: Array<String>) {

    val lines = getInput("7")

    val root: Node = Directory("/", 0, mutableListOf())

    var currentDirectory: Directory = root as Directory

    val linesIterator = lines.drop(1).iterator()

    processLine(currentDirectory, linesIterator)

    updateDirectorySize(root)

    println(sumDirectories(root))

    // Part 2

    val spaceNeeded = (40000000 - root.size)
    println(findSmallest(root, -spaceNeeded))
}

fun processLine(currentNode: Directory, iterator: Iterator<String>) {
    while (iterator.hasNext()) {
        val line = iterator.next()
        val split = line.split(" ")
        if (line == "\$ cd ..") {
            return
        } else if (split[0].all { char -> char.isDigit() }) {
            currentNode.children.add(File(split[1], split[0].toInt()))
        } else if (split[0] == "dir") {
            currentNode.children.add(Directory(split[1], 0, mutableListOf()))
        } else if (split[1] == "cd") {
            processLine(currentNode.children.firstOrNull {
                it.name == split[2]
            } as Directory, iterator)
        }
    }

}

fun updateDirectorySize(currentNode: Directory): Int {
    currentNode.children.forEach {
        if (it is File) {
            currentNode.size += it.size
        } else if (it is Directory) {
            currentNode.size += updateDirectorySize(it)
        }
    }
    return currentNode.size
}

fun sumDirectories(currentNode: Directory): Int {
    var sum = 0
    if (currentNode.size <= 100000) {
        sum += currentNode.size
    }

    currentNode.children.forEach {
        if (it is Directory) {
            sum += sumDirectories(it)
        }
    }

    return sum
}

fun findSmallest(currentNode: Directory, spaceNeeded: Int): Int {
    var currentSmallest = currentNode.size
    currentNode.children.forEach {
        if (it is Directory && it.size > spaceNeeded) {
            val childrenSmallest = findSmallest(it, spaceNeeded)
            if (childrenSmallest < currentSmallest) {
                currentSmallest = childrenSmallest
            }
        }
    }
    return currentSmallest
}