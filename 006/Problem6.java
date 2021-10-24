public class Problem6 {
    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            runProblem();
        }
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    public static int SumOfSquares(int num) {
        int sum = 0;
        for (int i = 0; i < num + 1; i++) {
            sum += i * i;
        }
        return sum;
    }

    public static int SquareOfSum(int num) {
        int sum = 0;
        for (int i = 0; i < num + 1; i++) {
            sum += i;
        }
        return sum * sum;
    }

    static void runProblem() {
        System.out.println(SquareOfSum(100) - SumOfSquares(100));
    }
}
