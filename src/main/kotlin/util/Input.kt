package util

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun getInput(day: String): List<String> {
    val token = System.getenv("AOC_TOKEN")

    val url = URL("https://adventofcode.com/2022/day/$day/input")

    val connection = url.openConnection() as HttpURLConnection

    connection.requestMethod = "GET"
    val session = "session=$token"
    connection.setRequestProperty("Cookie", session)

    val lines = ArrayList<String>()

    BufferedReader(InputStreamReader(connection.inputStream)).use { br ->
        var line: String?
        while (br.readLine().also { line = it } != null) {
            line?.let { lines.add(it) }
        }
    }
    return lines
}
