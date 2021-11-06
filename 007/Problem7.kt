import kotlin.system.measureNanoTime

fun main() {
    val loops = 10
    val timeInNanos = measureNanoTime {
        for (i in 1..loops) {
            problem()
        }
    }
    println("Function Took $timeInNanos Nano seconds for $loops loops")
}

fun isPrime(num: Int): Boolean {
    for (i in 2 until num) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}

fun problem() {
    var count = 2
    var i = 4
    while (true) {
        i++
        if (isPrime(i)) {
            count++
            if (count == 10_001) {
                break
            }
        }
    }
    println(i)
}