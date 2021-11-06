import java.io.File
import kotlin.system.measureNanoTime

fun main() {
    val loops = 1000
    val timeInNanos = measureNanoTime {
        for (i in 1..loops) {
            problem()
        }
    }
    println("Function Took $timeInNanos Nano seconds for $loops loops")
}

fun readLines(path: String): List<String> {
    return File(path).useLines { it.toList() }
}

fun getNumsFromLine(line: String): Array<Int> {
    val strArr = line.split(" ").toTypedArray()
    val intLine = Array(20) { 0 }
    strArr.forEachIndexed { index, c ->
        intLine[index] = c.toInt()
    }
    return intLine
}

fun vertMaxProduct(grid: Array<Array<Int>>, L: Int): Int {
    var max = 0
    val m = 20
    var product: Int
    for (i in 0 until L + 1) {
        for (j in 0 until m) {
            product = 1
            for (k in 1 until L) {
                product *= grid[i + k][j]
            }
            if (product > max) {
                max = product
            }
        }
    }
    return max
}

fun horzMaxProduct(grid: Array<Array<Int>>, L: Int): Int {
    var max = 0
    val n = 20
    val m = 20
    var product: Int
    for (i in 0 until n) {
        for (j in 0 until m - L + 1) {
            product = 1
            val subset = grid[i].copyOfRange(
                fromIndex = j,
                toIndex = j + L
            )
            for (k in 1 until subset.size) {
                product *= subset[k]
            }
            if (product > max) {
                max = product
            }
        }
    }
    return max
}

fun diagAProduct(grid: Array<Array<Int>>, L: Int): Int {
    var answer = 0
    val m = 20
    val n = 20
    var product: Int
    for (i in 0 until n - L + 1) {
        for (j in 0 until m - L + 1) {
            product = 1
            for (k in 0 until L) {
                product *= grid[i + k][j + k]
            }
            if (product > answer) {
                answer = product
            }
        }
    }
    return answer
}

fun diagBProduct(grid: Array<Array<Int>>, L: Int): Int {
    var answer = 0
    val n = 20
    val m = 20
    var product: Int
    for (i in L - 1 until n) {
        for (j in 0 until m - L + 1) {
            product = 1
            for (k in 0 until L) {
                product *= grid[i - k][j + k]
            }
            if (product > answer) {
                answer = product
            }
        }
    }
    return answer
}

fun problem() {
    val grid = Array(20) { Array(20) { 0 } }
    val lines = readLines("grid.txt")
    lines.forEachIndexed { index, s ->
        grid[index] = getNumsFromLine(s)
    }
    var answer = vertMaxProduct(grid, 4)
    var tmp = horzMaxProduct(grid, 4)
    if (tmp > answer) {
        answer = tmp
    }
    tmp = diagAProduct(grid, 4)
    if (tmp > answer) {
        answer = tmp
    }
    tmp = diagBProduct(grid, 4)
    if (tmp > answer) {
        answer = tmp
    }
    println(answer)
}