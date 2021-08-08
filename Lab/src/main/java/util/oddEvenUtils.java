package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class oddEvenUtils {

    public static void filler(double n){
        int baseNUmber = (int)n/2;
        //get the odd and even terms
        if (n%2==0){
            //even parts
            double[] odd = new double[baseNUmber];
            double[] even = new double[baseNUmber];
            for (int i = 0; i <odd.length ; i++) {
                odd[i]=2*i+1;
            }
            for (int i = 0; i <even.length ; i++) {
                even[i] = 2*i+2;
            }
        }else if (n%2!=0){
            //odd parts
            double[] odd = new double[baseNUmber+1];
            double[] even = new double[baseNUmber];
            for (int i = 0; i <odd.length ; i++) {
                odd[i]=2*i+1;
            }
            for (int i = 0; i <even.length ; i++) {
                even[i] =2*i+2;
            }
        }
    }


//    public static double simpson(double a, double b,double n ,double t){
//        if (n==0){
//            return 0;
//        }
//        double segment = t/n;
//        double[] termsNumber = new double[(int)n];
//        for (int i = 0; i <termsNumber.length ; i++) {
//            termsNumber[i] = i+1;
//        }
//        double[] termsValue = new double[(int)n];
//        for (int i = 0; i <termsValue.length ; i++) {
//            termsValue[i] = segment*(i+1);
//        }
//        double[] termResult = new double[(int)n];
//        for (int i = 0; i <termResult.length ; i++) {
//            if (termsNumber[i]==1){
//                //first term
//                termResult[i] = (1/C)*current(termsValue[i]);
//            }else if (termsNumber[i]==n){
//                //last term
//                termResult[i] = (1/C)*current(termsValue[i]);
//            }else if ((termsNumber[i]%2==0)&&(termsNumber[i]!=n)){
//                //even termsValue
//                termResult[i] = 4*(1/C)*current(termsValue[i]);
//
//            }else if((termsNumber[i]%2==1)&&(termsNumber[i]!=1)){
//                //odd termsValue
//                termResult[i] = 2*(1/C)*current(termsValue[i]);
//            }
//        }
//        double finalResult1 = 0;
//        for (double v : termResult) {
//            finalResult1 = finalResult1 + v;
//        }
//        double finalResult2 = finalResult1*((b-a)/3*n);
//        double finalResult3 = BigDecimal.valueOf(finalResult2)
//                .setScale(2, RoundingMode.HALF_UP)
//                .doubleValue();
//        return finalResult3;
//    }
}
