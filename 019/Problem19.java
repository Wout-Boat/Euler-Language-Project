import java.util.Calendar;
import java.util.Date;

public class Problem19 {

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        runProblem();
        final long endTime = System.nanoTime();
        System.out.println("Function took " + (endTime - startTime));
    }

    // This function counts the number of Sundays that fell on the first of the
    // month between two dates
    public static int countSundays(int startYear, int endYear) {
        int sundays = 0;
        for (int year = startYear; year <= endYear; year++) {
            for (int month = 1; month <= 12; month++) {
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                // if (cal.getTime().getDayOfWeek() == 7) {
                // sundays++;
                // }
            }
        }
        return sundays;
    }

    public static void runProblem() {
    }
}
