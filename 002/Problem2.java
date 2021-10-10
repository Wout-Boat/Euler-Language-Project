public class Problem2 {
    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        runProblem();
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    static void runProblem() {
        int a = 1, b = 2, sum = 2;
        int c = 0;

        while (c < 4_000_000) {
            c = a + b;
            if (c % 2 == 0) {
                sum += c;
            }
            a = b;
            b = c;
        }
        System.out.println(sum);
    }
}
