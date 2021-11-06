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
    var a = 1;
    var b = 2;
    var sum = 2;
    var c = a + b;

    while (c < 4_000_000) {
        c = a + b;
        if (c % 2 == 0) {
            sum += c;
        }

        a = b;
        b = c;
    }
    println(sum)
}