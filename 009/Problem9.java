public class Problem9 {

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        runProblem();
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    public static void runProblem() {
        int a, b = 0, c = 0;
        int s = 1000;
        boolean found = false;
        for (a = 1; a < s / 3; a++) {
            for (b = a; b < s / 2; b++) {
                c = s - a - b;
                if (a * a + b * b == c * c) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        System.out.println(a * b * c);
    }
}
