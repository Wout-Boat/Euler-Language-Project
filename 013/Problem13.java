import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.math.BigInteger;
import java.util.Scanner; // Import the Scanner class to read text files

public class Problem13 {

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        runProblem();
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    public static void runProblem() {
        BigInteger num = new BigInteger("0");
        try {
            File gridTxt = new File("./013/numbers.txt");
            Scanner fileReader = new Scanner(gridTxt);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                num = num.add(new BigInteger(line));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
        String numString = num.toString();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            output.append(numString.charAt(i));
        }
        System.out.println(output);
    }
}
