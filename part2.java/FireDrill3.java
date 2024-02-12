public class FireDrill3 {

    public static int[] task1(int... score) {
        int[] scores = new int[score.length];
        for (int index = 0; index < scores.length; index++) {
            scores[index] = score[index];

        }
        return scores;
    }

    public static String task2(int... score) {

        int[] scores = new int[score.length];

        for (int index = 0; index < score.length; index++) {
            scores[index] = score[index];

        }

        return scores[0] + " " + scores[1] + " " + scores[2] + " " + scores[3] + " " + scores[4] + " " + scores[5] + " " + scores[6] + " " + scores[7] + " " + scores[8] + " " + scores[9];

    }


    public static String task3(int... score) {

        int[] scores = new int[score.length];

        for (int index = 0; index < score.length; index++) {
            scores[index] = score[index];

        }

        return scores[0] + "\n" + scores[1] + "\n" + scores[2] + "\n" + scores[3] + "\n" + scores[4] + "\n" + scores[5] + "\n" + scores[6] + "\n" + scores[7] + "\n" + scores[8] + "\n" + scores[9];

    }

    public static int[] task4(int[] score) {

        int[] evenScores = new int[score.length / 2];

        for (int index = 0; index < (score.length / 2); index++) {

                 evenScores[index] = score[index * 2];
        }


        return evenScores;

    }


    public static int[] task5(int[] score) {

        int[] oddScores = new int[(score.length/2)];

        for (int index = 0; index < (score.length / 2); index++) {

                oddScores[index] = score[(index*2+1)];

        }
        return oddScores;
    }

    public static int task6(int[] score) {
        int evenSum = 0;
        int[] evenScores = new int[(score.length / 2 )];

        for (int index = 0; index < (score.length / 2); index++) {

            evenScores[index] = score[index * 2];
            evenSum += evenScores[index];
        }

        return evenSum;
    }

    public static int task7(int[] score) {
        int oddSum = 0;
        int[] oddScores = new int[(score.length / 2 )];


        for (int index = 0; index < (score.length / 2); index++) {

            oddScores[index] = score[index * 2 + 1];
            oddSum += oddScores[index];
        }


        return oddSum;
    }

    public static int task8(int[] score) {

        int[] evenScores = new int[score.length / 2];

        for (int index = 0; index < (score.length / 2); index++) {

            evenScores[index] = score[index * 2];

        }

        int evenMinimum = evenScores[0] ;
        for (int index = 0; index < evenScores.length; index++) {
            if(evenScores[index] < evenMinimum )
                evenMinimum = evenScores[index];
        }
        return evenMinimum;

    }



    public static int task9(int[] score) {

        int[] oddScores = new int[(score.length / 2 )];



        for (int index = 0; index < (score.length / 2); index++) {

            oddScores[index] = score[index * 2 + 1];


        }
        int oddMinimum  = oddScores[0];
            for (int index = 0; index < oddScores.length; index++) {
            if (oddScores[index] < oddMinimum)
                oddMinimum = oddScores[index];

        }

        return oddMinimum;
    }

    public static int task10(int[] score) {

        int[] evenScores = new int[score.length / 2];
        int evenMaximum = evenScores[0] ;
        for (int index = 0; index < (score.length / 2); index++) {

            evenScores[index] = score[index * 2];
            if(evenScores[index] > evenMaximum)
                evenMaximum = evenScores[index];
        }


        return evenMaximum;

    }

    public static int task11(int[] score) {

        int[] oddScores = new int[score.length / 2];
        int oddMaximum = oddScores[0] ;
        for (int index = 0; index < (score.length / 2); index++) {

            oddScores[index] = score[index * 2 + 1];
            if(oddScores[index] > oddMaximum)
                oddMaximum = oddScores[index];
        }


        return oddMaximum;

    }



    public static int[] task12(int[] score) {
        int temp = 0;
        int[] newScores = new int[score.length];
        for (int index = 0; index < score.length ; index+= 2) {
             int index2 = index + 1;

                temp = score[index];
                score[index] = score[index2];
                score[index2] = temp;


            }

        for (int index = 0; index < newScores.length ; index++) {
            newScores[index] = score[index];
        }
        return newScores;
    }


    public static int[] task13(int[] score) {
        int temp = 0;
        int[] newScores = new int[score.length];
        for (int index = 0; index < score.length ; index+= 2) {
            int index2 = index + 1;
            if (!(score[index] % 2 == 0 || score[index2] % 2 == 0)) {
                temp = score[index];
                score[index] = score[index2];
                score[index2] = temp;
            }

        }

        for (int index = 0; index < newScores.length ; index++) {
            newScores[index] = score[index];
        }
        return newScores;
    }

    public static int[] task14(int[] score) {
        int temp = 0;
        int[] newScores = new int[score.length];
        for (int index = 0; index < score.length ; index+= 2) {
            int index2 = index + 1;
            if (!(score[index] % 2 != 0 || score[index2] % 2 != 0)) {
                temp = score[index];
                score[index] = score[index2];
                score[index2] = temp;
            }
        }
        for (int index = 0; index < newScores.length ; index++) {
            newScores[index] = score[index];
        }
        return newScores;
    }

    public static int[] task15(int[] score) {
        int temp = 0;
        int[] newScores = new int[score.length];
        for (int index = 0; index < score.length ; index+= 2) {
            int index2 = index + 1;
            if (!(score[index] % 2 != 0 && score[index2] % 2 != 0)) {
                temp = score[index];
                score[index] = score[index2];
                score[index2] = temp;
            }
        }
        for (int index = 0; index < newScores.length ; index++) {
            newScores[index] = score[index];
        }
        return newScores;
    }


    public static int[] task16(int[] score) {
        int temp = 0;
        int[] newScores = new int[score.length];
        for (int index = 0; index < score.length ; index+= 2) {
            int index2 = index + 1;
            if (!(score[index] % 2 == 0 && score[index2] % 2 == 0)) {
                temp = score[index];
                score[index] = score[index2];
                score[index2] = temp;
            }
        }
        for (int index = 0; index < newScores.length ; index++) {
            newScores[index] = score[index];
        }
        return newScores;
    }

    public static void main(String[] args) {
        int [] numbers = {2,2,3,4,7,8,1,3};
        int [] even = task4(numbers);
        System.out.println(java.util.Arrays.toString(even));
        int [] odd = task5(numbers);
        System.out.println(java.util.Arrays.toString(odd));
        int num  = task8(numbers);
        System.out.println(num);
        int min = task9(numbers);
        System.out.println(min);
        int [] even1 = task16(numbers);
        System.out.println(java.util.Arrays.toString(even1));

    }







}


