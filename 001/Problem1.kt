import kotlin.system.measureNanoTime

fun main(args: Array<String>) {
    val loops = 1000;
    val timeInNanos = measureNanoTime {
        for (i in 0..loops) {
            problem();
        }
    }
    println("Function Took $timeInNanos Nano seconds for $loops loops");
}

fun problem() {
    var sum = 0;
    for (i in 1..999) {
        if (i % 3 == 0 || i % 5 == 0) {
            sum += i;
        }
    }
    println(sum)
}