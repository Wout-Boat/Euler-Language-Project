public class Problem4 {
    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            runProblem();
        }
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    public static int reverse_int(int n) {
        int new_int = 0;
        while (n != 0) {
            int remainder = n % 10;
            new_int *= 10;
            new_int += remainder;
            n /= 10;
        }
        return new_int;
    }

    static void runProblem() {
        int max = 0;
        int prod;
        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                prod = i * j;
                if (prod == reverse_int(prod) && prod > max)
                    max = prod;
            }
        }
        System.out.println(max);
    }
}
