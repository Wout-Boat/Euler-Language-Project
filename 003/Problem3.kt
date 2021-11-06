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

fun largestFactor(num: Long): Long {
    var n = num
    val primeFactors: MutableList<Long> = ArrayList()
    while(n % 2 == 0.toLong()) {
        primeFactors.add(2)
        n /= 2
    }

    var i = 3
    while (i * i <= n){
        while (n % i == 0.toLong()) {
            primeFactors.add(i.toLong())
            n /= i
        }
        i += 2
    }

    if (n > 2) {
        primeFactors.add(n)
    }

    return primeFactors.last()
}

fun problem() {
    println(largestFactor(600851475143))
}