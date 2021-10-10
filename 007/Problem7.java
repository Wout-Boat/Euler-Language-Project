public class Problem7 {
    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        runProblem();
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public static void runProblem() {
        int count = 2;
        int i = 4;
        boolean loop = true;
        while (loop) {
            i++;
            if (isPrime(i)) {
                count++;
                if (count == 10_001) {
                    loop = false;
                }
            }
        }
        System.out.println(i);
    }
}
