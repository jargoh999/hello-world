import java.util.Scanner;
import java.util.InputMismatchException;

public class MassiveArray {

    private int[][] grades;
    private static Scanner input = new Scanner(System.in);


    public void CollectGrade() {

        System.out.println("How many students do you have?");
        int StudentNumber = input.nextInt();

        System.out.println("How many subject do they offer? ");
        int SubjectNumber = input.nextInt();
        System.out.println("saving >>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Saved successfully\n\n");

        grades = new int[StudentNumber][SubjectNumber];

        for (int student = 0; student < grades.length; student++) {
            for (int subject = 0; subject < grades[student].length; subject++) {

                System.out.printf("Entering score for student %d %n", student + 1);
                System.out.printf("Entering score for subject %d%n", subject + 1);


                    int theRealGrade = input.nextInt();

                    if (theRealGrade >= 0 && theRealGrade <= 100)
                        grades[student][subject] = theRealGrade;



                
    while (!(theRealGrade >= 0 && theRealGrade <= 100)) {
        System.out.println(" try again , enter a grade between 0 - 100  ");
        System.out.printf("Entering score for student %d %n", student + 1);
        System.out.printf("Entering score for subject %d%n", subject + 1);
        theRealGrade = input.nextInt();


}

                System.out.println("saving >>>>>>>>>>>>>>>>>>>>>>>>>>>");
                System.out.println("Saved successfully\n\n");
            }
        }
    }

    public int getTotal(int[] grades) {
        int total = 0;

        for (int i = 0; i < grades.length; i++) {

            total += grades[i];

        }

        return total;

    }

    public double getAverage(int[] grade) {

        int total = 0;

        for (int i = 0; i < grade.length; i++) {

            total += grade[i];
        }

        double average = (double) total / grade.length;

        return average;
    }


    public int getLowest() {
        int lowest = grades[0][0];
        for (int grade = 0; grade < grades.length - 1; grade++) {
            for (int grad = 0; grad < grades[grade].length; grad++) {
                if (grades[grade][grad] < lowest) {
                    lowest = grades[grad][grade];
                }
            }

        }


        return lowest;

    }

    public int getHighest() {
        int highest = grades[0][0];
        for (int[] grum : grades) {
            for (int grade : grum) {
                if (grade > highest) {

                    highest = grade;
                }
            }
        }
        return highest;

    }


    public void outputGrades() {

        System.out.println("here is the grades");
        System.out.println("=====================================================================");
        System.out.print(" Student  ");

        for (int i = 0; i < grades[0].length; i++) {
            System.out.printf("SUB%d  ", i + 1);
        }
        System.out.println("AVERAGE  TOTAL   POS");
        System.out.println("=====================================================================");

        for (int i = 0; i < grades.length; i++) {
            System.out.printf(" student%d  ", i + 1);


            for (int j = 0; j < grades[i].length; j++) {

                System.out.printf("%d    ", grades[i][j]);
            }


            double average = getAverage(grades[i]);

            int total = getTotal(grades[i]);
            int position = 1;
            for (int june = 0; june < grades.length; june++) {
                if (total < getTotal(grades[june])) {
                    position++;


                }
            }


            System.out.printf("  %.2f      %d     %d     %n", average, total, position);


        }
        System.out.println("====================================================================");
    }


    public void subjectSummary() {

        int[] subFail = new int[grades.length];
        int[] subPass = new int[grades.length];
        for (int subject = 0; subject < grades.length; subject++) {
            int lowest = grades[0][subject];
            int highest = grades[0][subject];
            int total = 0;
            double average = 0;
            int passCount = 0;
            int failCount = 0;
            int stunum = 1;
            int stunum1 = 1;
            for (int student = 0; student < grades[subject].length; student++) {

                total += grades[student][subject];

                average = (double) total / grades.length;
                if (grades[student][subject] < lowest) {
                    lowest = grades[student][subject];
                    stunum1 = student;
                }
                if (grades[student][subject] > highest) {
                    highest = grades[student][subject];
                    stunum = student;
                }

                if (grades[student][subject] > 49) {
                    passCount++;
                } else {
                    failCount++;
                }


            }

            System.out.printf("Subject Summary %d%n", subject + 1);
            System.out.printf("highest scoring student is : student %d scoring %d%n", stunum + 1, highest);
            System.out.printf("lowest scoring student is : student %d scoring %d%n", stunum1 + 1, lowest);
            System.out.printf("total score  is : %d%n", total);
            System.out.printf("average score  is : %.2f%n", average);
            System.out.printf("No of passes : %d%n", passCount);
            System.out.printf("No of failure : %d%n%n ", failCount);
            subFail[subject] = failCount;
            subPass[subject] = passCount;
        }

        int MostPf = subFail[0];
        int Failorpassindex = 1;
        for (int check = 0; check < grades.length; check++) {
            if (subFail[check] > MostPf)
                MostPf = subFail[check];
        }
        for (int i = 0; i < grades.length; i++) {
            if (subFail[i] == MostPf) {
                Failorpassindex = i;
            }

        }
        System.out.printf("the hardest subject is subject %d with %d failures %n", Failorpassindex + 1, MostPf);

        int MostP = subPass[0];
        int passindex = 1;
        for (int check1 = 0; check1 < grades.length; check1++) {
            if (subPass[check1] > MostP)
                MostP = subPass[check1];

        }
        for (int i = 0; i < grades.length; i++) {
            if (subPass[i] == MostP) {
                passindex = i;
            }
        }
        System.out.printf("the easiest  subject is subject %d with %d passes %n", passindex + 1, MostP);
    }

    public void getHighScorer() {
        int[] total = new int[grades.length];
        int highest = grades[0][0];
        int lowest = grades[0][0];
        int studNum = 1;
        int Subnum = 1;
        int studNum1 = 1;
        int Subnum1 = 1;
        for (int student = 0; student < grades.length; student++) {
            for (int subject = 0; subject < grades[student].length; subject++) {
                if (grades[student][subject] > highest) {
                    highest = grades[student][subject];
                    studNum = student + 1;
                    Subnum = subject + 1;
                }
                if (grades[student][subject] < lowest) {
                    lowest = grades[student][subject];
                    studNum1 = student + 1;
                    Subnum1 = Subnum1 + 1;
                }
            }
        }
        System.out.printf("the highest  score is scored by student %d in subject  %d scoring %d %n", studNum, Subnum, highest);
        System.out.printf("the highest  score is scored by student %d in subject  %d scoring %d %n", studNum1, Subnum1, lowest);
        System.out.println("======================================================================");

        for (int student = 0; student < grades.length; student++) {
            int totalIt = 0;
            for (int subject = 0; subject < grades[student].length; subject++) {
                totalIt += grades[student][subject];
            }
            total[student] = totalIt;
        }
        int totalOverAll = 0;
        int bestGradNo = 0;
        int worstGradNo = 0;
        int bestGrad = total[0];
        int worstGrad = total[0];
        for (int checkT = 0; checkT < total.length; checkT++) {
            totalOverAll += total[checkT];
            if (total[checkT] > bestGrad) {
                bestGrad = total[checkT];
            }
        }
        for (int checkT = 0; checkT < total.length; checkT++) {
            if (total[checkT] == bestGrad) {
                bestGradNo = checkT;
            }
        }

        for (int checkT = 0; checkT < total.length; checkT++) {
            if (total[checkT] < worstGrad) {
                worstGrad = total[checkT];
            }
        }
        for (int checkT = 0; checkT < total.length; checkT++) {
            if (total[checkT] == worstGrad) {
                worstGradNo = checkT;
            }
        }
        double classAverage = (double) totalOverAll / total.length;


        System.out.println("CLASS SUMMARY");
        System.out.println("======================================================================");
        System.out.printf("Best Graduating  student is : student  %d  scoring  %d%n", bestGradNo + 1, bestGrad);
        System.out.println("======================================================================");

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.printf("Worst Graduating  student is : student  %d  scoring  %d%n", worstGradNo + 1, worstGrad);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        System.out.println("======================================================================");
        System.out.printf("Class total  is :   %d%n", totalOverAll);
        System.out.printf("Class Average  is :   %.2f%n", classAverage);
        System.out.println("======================================================================");
    }

    public void processGrade() {

        outputGrades();
        System.out.printf("%nthe highest Grade is : %d%n%n", getHighest());
        System.out.printf("%nthe lowest Grade is : %d%n%n", getLowest());
        subjectSummary();
        getHighScorer();
    }
}
