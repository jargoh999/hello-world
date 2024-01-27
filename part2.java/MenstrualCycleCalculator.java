
import java.util.Calendar;


public class MenstrualCycleCalculator {
   public  static final Calendar calender  = Calendar.getInstance();
    public  String[] getLastPeriodDate (String date) {
        String[] dates = new String[3];
        String year = "";
        String month = "";
        String day  = "";
        for (int i = 0; i < date.length(); i++) {
            if (i <= 3) {
                year += date.charAt(i);
            } else if (i > 4 && i <= 6) {
                month += date.charAt(i);
            } else if (i > 7) {
                day  += date.charAt(i);
            }


        }

        dates[0] = year;
        dates[1] = month;
        dates[2] = day;

        return dates;
    }

    public  String getNextCycle(String[] dates,int periodDayLength ){

                 int periodYear = Integer.parseInt(dates[0]);
                 int periodMonth = Integer.parseInt(dates[1]);
                 int periodDay = Integer.parseInt(dates[2]);
                if (isValidCycle(periodYear,periodMonth,periodDay)) {
                    if (periodMonth == 11) {
                        periodMonth += 1;
                        if (periodMonth == 1) {
                            periodMonth += 1;
                        }
                    }

                    calender.set(Calendar.YEAR, periodYear);
                    calender.set(Calendar.MONTH, periodMonth);
                    calender.set(Calendar.DATE, periodDay);
                    calender.add(Calendar.DATE, periodDayLength);
                }
                    return calender.get(Calendar.YEAR) + " - " + calender.get(Calendar.MONTH) +
                            " - " + calender.get(Calendar.DATE);

    }




  public  boolean isValidCycle (int year , int month , int day ){

        if (month <= 0 || month >= 13  || day <= 0 || day > 31 || month == 2 && day > 29 ) {
            throw new IllegalArgumentException("Date or / and month is out of range");
        }
        return true;
  }


  public  String ovulationMinimumRange(String[] dates){

      int periodYear = Integer.parseInt(dates[0]);
      int periodMonth = Integer.parseInt(dates[1]);
      int periodDay = Integer.parseInt(dates[2]);
      if (isValidCycle(periodYear,periodMonth,periodDay)) {
          if (periodMonth == 11) {
              periodMonth += 1;
              if (periodMonth == 1) {
                  periodMonth += 1;
              }
          }

          calender.set(Calendar.YEAR, periodYear);
          calender.set(Calendar.MONTH, periodMonth);
          calender.set(Calendar.DATE, periodDay);
          calender.add(Calendar.DATE, (14 - 5));
      }
      return calender.get(Calendar.YEAR) + " - " + calender.get(Calendar.MONTH) +
              " - " + calender.get(Calendar.DATE);


  }

    public  String ovulationMaximumRange(String[] dates){


        int periodYear = Integer.parseInt(dates[0]);
        int periodMonth = Integer.parseInt(dates[1]);
        int periodDay = Integer.parseInt(dates[2]);
        if (isValidCycle(periodYear,periodMonth,periodDay)) {
            if (periodMonth == 11) {
                periodMonth += 1;
                if (periodMonth == 1) {
                    periodMonth += 1;
                }
            }

            calender.set(Calendar.YEAR, periodYear);
            calender.set(Calendar.MONTH, periodMonth);
            calender.set(Calendar.DATE, periodDay);
            calender.add(Calendar.DATE, 14);
        }
        return calender.get(Calendar.YEAR) + " - " + calender.get(Calendar.MONTH) +
                " - " + calender.get(Calendar.DATE);




    }




}