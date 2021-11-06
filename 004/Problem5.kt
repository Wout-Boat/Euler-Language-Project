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

fun reverseInt(n: Int): Int {
    var num = n
    var newInt = 0
    var remainder: Int
    while (num != 0) {
        remainder = num % 10
        newInt *= 10
        newInt += remainder
        num /= 10
    }
    return newInt
}

fun problem() {
    var max = 0
    var prod: Int
    for (i in 100 until 1000) {
        for (j in 100 until 1000) {
            prod = i * j
            if (prod == reverseInt(prod) && prod > max) {
                max = prod
            }
        }
    }
    println(max)
}