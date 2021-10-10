import java.util.ArrayList;

public class Problem3 {
    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        runProblem();
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    public static long primeFactors(long n) {
        ArrayList<Long> primeNumbers = new ArrayList<Long>();
        // Print the number of 2s that divide n
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        // n must be odd at this point. So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                primeNumbers.add(n);
                n /= i;
            }
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
            primeNumbers.add(n);

        return primeNumbers.get(primeNumbers.size() - 1);
    }

    static void runProblem() {
        System.out.println(primeFactors(Long.parseLong("600851475143")));
    }
}
