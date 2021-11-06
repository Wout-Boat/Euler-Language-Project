import kotlin.system.measureNanoTime

fun main() {
    val loops = 10000
    val timeInNanos = measureNanoTime {
        for (i in 1..loops) {
            problem()
        }
    }
    println("Function Took $timeInNanos Nano seconds for $loops loops")
}

fun sumOfSquares(num: Int): Int {
    var sum = 0
    for (n in 1..num) {
        sum += n * n
    }
    return sum
}

fun squareOfSum(num: Int): Int {
    var sum = 0
    for (n in 1..num) {
        sum += n
    }
    return sum * sum
}

fun problem() {
    val naturalNum = 100
    println(squareOfSum(naturalNum) - sumOfSquares(naturalNum))
}