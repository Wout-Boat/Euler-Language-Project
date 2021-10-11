public class Problem12 {

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        runProblem();
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // If divisors are equal,
                // count only one
                if (n / i == i)
                    count++;

                else // Otherwise count both
                    count = count + 2;
            }
        }
        return count;
    }

    public static void runProblem() {
        final int numDivisors = 500;
        int i = 3;
        while (true) {
            int key = i;
            int sum = 0;
            while (i > 0) {
                sum += i;
                i--;
            }
            if (countDivisors(sum) > numDivisors) {
                System.out.println(sum);
                break;
            }
            i = key + 1;
        }
    }
}
