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

fun problem() {
    var a = 1
    var b = a
    var c = 0
    val s = 1000
    var found = false
    while (a < s / 3) {

        b = a
        while (b < s / 2) {
            c = s - a - b

            if (a * a + b * b == c * c) {
                found = true
                break
            }

            b++
        }

        if (found) {
            break
        }
        a++
    }
    println(a * b * c)
}