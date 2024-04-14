public class creditCard {


    public void Validator(long CreditNo) {

        int CredLength = (int) Math.log10(CreditNo) + 1;

        if (CredLength > 0 && CredLength == 13 ||
                CredLength > 0 && CredLength == 16) {

            long[] cardNo = new long[(int) CredLength];

            for (int i = 0; i < CredLength; i++) {

                cardNo[i] = CreditNo % 10l;
                CreditNo /= 10l;
            }

            System.out.println("*************************************************");


            if (cardNo[CredLength - 1] == 4)
                System.out.println("** Credit Card Type : VisaCard");
            if (cardNo[CredLength - 1] == 5)
                System.out.println("** Credit Card Type : MasterCard");
            if (cardNo[CredLength - 1] == 6)
                System.out.println("** Credit Card Type : DiscoverCard");
            if (cardNo[CredLength - 1] == 3 && cardNo[CredLength - 2] == 7)
                System.out.println("** Credit Card Type : American Express Cards");

            System.out.printf("** Credit card Number: ");
            for (int check2 = CredLength - 1; check2 >= 0; check2--) {
                System.out.printf("%d ", cardNo[check2]);
            }
            System.out.println();
            System.out.printf("** Credit Card Digit Length : %d%n", CredLength);


            BreakIt(cardNo);


        } else if (CredLength == 14 || CredLength == 15 || CredLength < 13 || CredLength > 16) {

            System.out.println("werey enter a valid number seh!!!");

        }

    }

    public void BreakIt(long[] Card) {

        int allSum = 0;
        int evenSum = 0;
        int oddSum = 0;
        int evenSumA = 0;
        for (int check2 = 0; check2 < Card.length; check2++) {

            if ((check2 + 1) % 2 == 0 && ((int) Card[check2] * 2) < 9) {

                evenSumA += ((int) Card[check2] * 2);
            } else if ((check2 + 1) % 2 == 0 && ((int) Card[check2] * 2) > 9) {

                evenSum = evenSum + (((int) Card[check2] * 2) - 9);
            }


            if ((check2 + 1) % 2 != 0) {

                oddSum += (int) Card[check2];
            }


        }

        evenSum += evenSumA;
        allSum = evenSum + oddSum;
        if (allSum % 10 != 0) {
            System.out.println("** Credit Card Validity Status: Invalid");
        } else if (allSum % 10 == 0) {
            System.out.println("** Credit Card Validity Status: Valid");
        }
        System.out.println("*************************************************");


       

    }


}


    

            