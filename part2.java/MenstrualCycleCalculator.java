
import java.util.Calendar;
import java.util.Scanner;


public class MenstrualCycleCalculator {
    public static  Calendar calender = Calendar.getInstance();
    static String [] periodMonths = {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
    public String[] getLastPeriodDate(String date) {
        String[] dates = new String[3];
        String year = "";
        String month = "";
        String day = "";
        for (int index = 0; index < date.length(); index++) {
            if (index <= 3) {
                year += date.charAt(index);
            } else if (index > 4 && index <= 6) {
                month += date.charAt(index);
            } else if (index > 7) {
                day += date.charAt(index);
            }


        }

        dates[0] = year;
        dates[1] = month;
        dates[2] = day;

        return dates;
    }

    public String getNextCycle(String[] dates, int periodDayLength) {
        int month1 = 0;
        int periodYear = Integer.parseInt(dates[0]);
        int periodMonth = Integer.parseInt(dates[1]);
        int periodDay = Integer.parseInt(dates[2]);
        if (isValidCycle(periodYear, periodMonth, periodDay)) {
            calender.set(Calendar.YEAR, periodYear);
            calender.set(Calendar.MONTH, periodMonth);
            calender.set(Calendar.DATE, periodDay );
            calender.add(calender.DATE,periodDayLength);

            month1 = Integer.parseInt(String.valueOf(calender.get(Calendar.MONTH)));
           if (month1 == 0){
               month1+=1;
           }
        }
        return calender.get(Calendar.YEAR) + " - " + periodMonths[month1 - 1] +
                " - " + calender.get(Calendar.DATE);

    }


    public boolean isValidCycle(int year, int month, int day) {

        if (month <= 0 || month >= 13 || day <= 0 || day > 31 || month == 2 && day > 29) {
            throw new IllegalArgumentException("Date or / and month is out of range");
        }
        return true;
    }


    public String ovulationMinimumRange(String[] dates) {
        int month1 = 0;
        int periodYear = Integer.parseInt(dates[0]);
        int periodMonth = Integer.parseInt(dates[1]);
        int periodDay = Integer.parseInt(dates[2]);
        if (isValidCycle(periodYear, periodMonth, periodDay)) {
            calender.set(Calendar.YEAR, periodYear);
            calender.set(Calendar.MONTH, periodMonth);
            calender.set(Calendar.DATE, periodDay);
            calender.add(calender.DATE,9);
            month1 = Integer.parseInt(String.valueOf(calender.get(Calendar.MONTH)));
            if (month1 == 0){
                month1+=1;
            }
        }
        return calender.get(Calendar.YEAR) + " - " + periodMonths[month1-1] +
                " - " + calender.get(Calendar.DATE);


    }

    public String ovulationMaximumRange(String[] dates) {

        int  month1 = 0;
        int periodYear = Integer.parseInt(dates[0]);
        int periodMonth = Integer.parseInt(dates[1]);
        int periodDay = Integer.parseInt(dates[2]);
        if (isValidCycle(periodYear, periodMonth, periodDay)) {
            calender.set(Calendar.YEAR, periodYear);
            calender.set(Calendar.MONTH, periodMonth);
            calender.set(Calendar.DATE, periodDay );
            calender.add(calender.DATE,14);
            month1 = Integer.parseInt(String.valueOf(calender.get(Calendar.MONTH)));
            if (month1 == 0){
                month1+=1;
            }
        }
        return calender.get(Calendar.YEAR) + " - " + periodMonths[month1-1] +
                " - " + calender.get(Calendar.DATE);


    }

    public void displayCaculatorInMainMethod() {
        Scanner scan = new Scanner(System.in);
        MenstrualCycleCalculator menses = new MenstrualCycleCalculator();

        System.out.println("what is the start date of your period pls enter in YY/MM/DD 0r YY-MM-DD format");
        String date = scan.next();

        System.out.println("what is the average cycle length of your menstrual cycle ?");
        int averageCycleLength = scan.nextInt();


        String[] dates  = menses.getLastPeriodDate(date);
        String estimatedEndOfPeriodDate = menses.getNextCycle(dates, averageCycleLength);
        String ovulationMinimumRange = menses.ovulationMinimumRange(dates);
        String ovulationMaximumRange = menses.ovulationMaximumRange(dates);


      System.out.printf("if your period starts%n%s%n%nif the average cycle length of your menstrual cycle is :%n%d%n%nyour estimated" +
                " fertile window is between : %n%s    ->      %s%n%nyour estimated ovulation date is:%n%s%n%nyour menstrual cycle should end by : %n%s", java.util.Arrays.toString(dates), averageCycleLength, ovulationMinimumRange, ovulationMaximumRange, ovulationMaximumRange,estimatedEndOfPeriodDate);

    }


     public static void main(String[] args) {
         MenstrualCycleCalculator menses = new MenstrualCycleCalculator();
         menses.displayCaculatorInMainMethod();

    }
}