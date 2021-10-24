public class Problem10 {

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            runProblem();
        }
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    static boolean[] Sieve(int n) {
        boolean[] nums = new boolean[n + 1];
        for (int i = 2; i < n + 1; i++) {
            nums[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (nums[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    nums[i] = false;
                }
            }
        }
        return nums;
    }

    public static void runProblem() {
        int n = 2_000_000;
        boolean[] arr = Sieve(n);

        long sum = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i]) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
