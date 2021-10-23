class Problem1 {
    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            runProblem();
        }
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    static void runProblem() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}