public class Problem15 {

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        runProblem();
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    public static void runProblem() {
        final short gridSize = 20;
        long paths = 1;
        for (int i = 0; i < gridSize; i++) {
            paths *= (2 * gridSize) - i;
            paths /= i + 1;
        }
        System.out.println(paths);
    }
}
