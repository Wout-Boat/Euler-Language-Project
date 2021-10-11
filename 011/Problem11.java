import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files

public class Problem11 {

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        runProblem();
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    public static int vertMaxProduct(int[][] grid, int l) {
        int max = 0;
        int m = 20;
        int product = 1;
        for (int i = 0; i < l + 1; i++) {
            for (int j = 0; j < m; j++) {
                product = 1;
                for (int k = 1; k < l; k++) {
                    product *= grid[i + k][j];
                }
                if (product > max) {
                    max = product;
                }
            }
        }
        return max;
    }

    public static int horzMaxProduct(int[][] grid, int l) {
        int max = 0;
        int m = 20;
        int product = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m - l + 1; j++) {
                product = 1;
                int[] subset = Arrays.copyOfRange(grid[i], j, j + 1);
                for (int k = 1; k < subset.length; k++) {
                    product *= subset[k];
                }
                if (product > max) {
                    max = product;
                }
            }
        }
        return max;
    }

    public static int diagAProduct(int[][] grid, int l) {
        int answer = 0;
        int n = 20;
        int m = 20;
        int product = 1;
        for (int i = 0; i < n - l + 1; i++) {
            for (int j = 0; j < m - l + 1; j++) {
                product = 1;
                for (int k = 0; k < l; k++) {
                    product *= grid[i + k][j + k];
                }
                if (product > answer) {
                    answer = product;
                }
            }
        }
        return answer;
    }

    public static int diagBProduct(int[][] grid, int l) {
        int answer = 0;
        int n = 20;
        int m = 20;
        int product = 1;
        for (int i = l - 1; i < n; i++) {
            for (int j = 0; j < m - l + 1; j++) {
                product = 1;
                for (int k = 0; k < l; k++) {
                    product *= grid[i - k][j + k];
                }
                if (product > answer) {
                    answer = product;
                }
            }
        }
        return answer;
    }

    public static void runProblem() {
        int[][] grid = new int[20][20];
        try {
            File gridTxt = new File("./011/grid.txt");
            Scanner fileReader = new Scanner(gridTxt);
            int index = 0;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] lineSplt = line.split(" ");
                for (int i = 0; i < lineSplt.length; i++) {
                    grid[index][i] = Integer.parseInt(lineSplt[i]);
                }
                index++;
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
        int max = vertMaxProduct(grid, 4);
        int tmp = horzMaxProduct(grid, 4);
        if (tmp > max) {
            max = tmp;
        }
        tmp = diagAProduct(grid, 4);
        if (tmp > max) {
            max = tmp;
        }
        tmp = diagBProduct(grid, 4);
        if (tmp > max) {
            max = tmp;
        }
        System.out.println(max);
    }
}
