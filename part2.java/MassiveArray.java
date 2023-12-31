public class MassiveArray {
    private String CourseName;
    private int[][] grades;

    public MassiveArray(String CourseName, int[][] grades) {


        this.CourseName = CourseName;
        this.grades = grades;


    }

    public String getCourse() {
        return CourseName;
    }

    public int getTotal(int[] grades) {
        int tot = 0;

        for (int i = 0; i < grades.length; i++) {

            tot += grades[i];

        }

        return tot;

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
        for (int[] grum : grades) {
            for (int grade : grum) {
                if (grade < lowest) {

                    lowest = grade;
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
            System.out.printf("SUBJECT%d  ", i + 1);
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
            for (int june = 0; june < grades.length ; june++) {
                   if (total < getTotal(grades[june])) {
                       position++;} }



            System.out.printf("  %.2f      %d     %d     %n", average, total, position);

        }
        System.out.println("====================================================================");
    }
    
    public void subjectSummary(int ... grades) {
        int lowest = grades[0] ;
        int highest = grades[0];
        int total = 0;
        double average = 0;
        int passCount = 0;
        int failCount = 0;
        int stunum = 0;
        int stunum1 = 0;
        for (int i = 0; i
                < grades.length; i++) {

            total += grades[i] ;
            average = (double) total / grades.length;
            if (grades[i] < lowest) {

                lowest = grades[i];
                stunum1 = i ;
            }
            if (grades[i] > highest) {

                highest = grades[i];
                stunum = i ;
            }

            if (grades[i] > 40) {
                passCount += 1;
            } else {
                failCount += 1;
            }
         

        }
        System.out.printf("Subject
        System.out.printf("highest scoring student is : student %d scoring %d%n", stunum+ 1, highest);
        System.out.printf("lowest scoring student is : student %d scoring %d%n", stunum1 + 1, lowest);
        System.out.printf("total score  is : %d%n", total);
        System.out.printf("average score  is : %.2f%n", average);
        System.out.printf("No of passes : %d%n", passCount);
        System.out.printf("No of failure : %d%n%n ", failCount);


    }


    public void processGrade() {

        outputGrades();


        System.out.printf("%nthe highest Grade is : %d%n%n", getHighest());

        System.out.printf("%nthe lowest Grade is : %d%n%n", getLowest());
    
        

    }
}
