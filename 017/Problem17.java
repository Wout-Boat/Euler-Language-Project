public class Problem17 {

    final static String[] ones = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    final static String[] teens = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen" };
    final static String[] tens = { "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        runProblem();
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    static String numToString(int num) {
        if (num == 1000) {
            return "OneThousand";
        }

        if (num < 10) {
            return ones[num - 1];
        }

        StringBuilder output = new StringBuilder();

        if (num >= 100) {
            int hundredsSpot = num / 100;
            int remainder = num % 100;
            output.append(ones[hundredsSpot - 1]);
            output.append("Hundred");
            if (remainder == 0) {
                return output.toString();
            }
            output.append("And");
            num = remainder;
        } // End Hundreds

        if (num >= 10) {
            if (num < 20) {
                output.append(teens[num - 10]);
                return output.toString();
            }
            int tensSpot = num / 10;
            int remainder = num % 10;
            output.append(tens[tensSpot - 1]);
            if (remainder == 0) {
                return output.toString();
            }
            num = remainder;
        }

        output.append(ones[num - 1]);
        return output.toString();
    }

    static int numLength(int num) {
        return numToString(num).length();
    }

    public static void runProblem() {
        int sum = 0;
        for (int i = 1; i < 1001; i++) {
            sum += numLength(i);
        }
        System.out.println(sum);
    }
}
