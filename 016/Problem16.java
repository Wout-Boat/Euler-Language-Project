import java.math.BigInteger;

public class Problem16 {

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        runProblem();
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    public static void runProblem() {
        BigInteger big = BigInteger.valueOf(2).pow(1000);
        String digits = big.toString();
        int sum = 0;

        for (int i = 0; i < digits.length(); i++) {
            int digit = (int) (digits.charAt(i) - '0');
            sum = sum + digit;
        }

        System.out.println(sum);
    }
}
