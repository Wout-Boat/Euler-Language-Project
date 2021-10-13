public class Problem14 {

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        runProblem();
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    static int collatzCount(long n) {
        int count = 0;
        while (n > 1) {
            count++;
            if (n % 2 != 0) {
                n = 3 * n + 1;
            } else {
                n = n / 2;
            }
        }
        count++;
        return count;
    }

    public static void collatz(int n) {
        System.out.print(n + " ");
        if (n == 1)
            return;
        else if (n % 2 == 0)
            collatz(n / 2);
        else
            collatz(3 * n + 1);
    }

    public static void runProblem() {
        int num = 0;
        int max = 0;
        int tmp;
        for (int i = 830000; i < 1_000_000; i++) {
            tmp = collatzCount(i);
            if (tmp > max) {
                max = tmp;
                num = i;
            }
        }
        System.out.println(num);
    }
}
