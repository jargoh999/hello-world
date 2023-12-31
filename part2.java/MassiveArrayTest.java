import java.util.Scanner;


public class MassiveArrayTest {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("How many students do you have?");
        int theLength = input.nextInt();


        System.out.println("How many subject do they offer? ");
        int LengthB = input.nextInt();
        System.out.println("saving >>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Saved successfully\n\n");

        int[][] grades = new int[theLength][LengthB];



        for (int i = 0; i < grades[0].length; i++) {
            System.out.printf("Entering score for student %d %n",1);
            System.out.printf("Entering score for subject %d%n", i + 1);
            int a = input.nextInt();
            if (a >= 0 && a <= 100)
                grades[1][i] = a;
            else {
                System.out.println("oloshi try again , unto the next sha ");
                continue;
            }

            System.out.println("saving >>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Saved successfully\n\n");
        }


        for (int i = 0; i < grades[1].length; i++) {
            System.out.printf("Entering score for student 2 %n");
            System.out.printf("Entering score for subject %d%n", i + 1);
            int a = input.nextInt();
            if (a >= 0 && a <= 100)
                grades[2][i] = a;
            else {
                System.out.println("oloshi try again , unto the next sha ");
                continue;
            }

            System.out.println("saving >>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Saved successfully\n\n");
        }


        for (int i = 0; i < grades[2].length; i++) {
            System.out.printf("Entering score for student 3 %n");
            System.out.printf("Entering score for subject %d%n", i + 1);
            int a = input.nextInt();
            if (a >= 0 && a <= 100)
                grades[0][i] = a;
            else {
                System.out.println("oloshi try again , unto the next sha \n");
                continue;
            }

            System.out.println("saving >>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Saved successfully\n\n");
        }

        for (int i = 0; i < grades[3].length; i++) {
            System.out.printf("Entering score for student 4 %n");
            System.out.printf("Entering score for subject %d%n", i + 1);
            int a = input.nextInt();
            if (a >= 0 && a <= 100)
                grades[3][i] = a;
            else {
                System.out.println("oloshi try again , unto the next sha \n");
                continue;
            }

            System.out.println("saving >>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Saved successfully\n\n");
        }

        System.out.println(java.util.Arrays.deepToString(grades));

        MassiveArray merry = new MassiveArray("com 111", grades);

        merry.processGrade();
        System.out.println("Subject Summary\n\n");


        System.out.println("Subject 1");
        merry.subjectSummary(grades[0][0],grades[1][0],grades[2][0],grades[3][0]);

        System.out.println("Subject 2");

        merry.subjectSummary(grades[0][1],grades[1][1],grades[2][1],grades[3][1]);

        System.out.println("Subject 3");

        merry.subjectSummary(grades[0][2],grades[1][2],grades[2][2],grades[3][2]);

        System.out.println("Subject 4");

        merry.subjectSummary(grades[0][3],grades[1][3],grades[2][3],grades[3][3]);

    }


}
