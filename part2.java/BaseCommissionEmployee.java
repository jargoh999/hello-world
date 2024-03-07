public class BaseCommissionEmployee {


    public static int calculateDelivery(int percentageToCalculate) {
        final int basePay = 5000;
        int amountPerParcel = 0;
        if (percentageToCalculate < 50) amountPerParcel = 160;
        if (percentageToCalculate >= 50 && percentageToCalculate < 60) amountPerParcel = 200;
        if (percentageToCalculate >= 60 && percentageToCalculate < 70) amountPerParcel = 250;
        if (percentageToCalculate >= 70) amountPerParcel = 500;
        if(percentageToCalculate < 0 || percentageToCalculate > 100)throw new IllegalArgumentException("invalid collection rate");
        return percentageToCalculate * amountPerParcel + basePay;
    }

}
