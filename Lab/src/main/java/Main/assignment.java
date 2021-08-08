package Main;
import java.math.BigDecimal;
import java.math.RoundingMode;
import static java.lang.Math.*;
public class assignment {
    final static private double R = 100;//ohm
    final static private double C = 0.1;//F
    public static double current(double t){
        double power = -t/(R*C);
        return 0.5*pow(E,power);
    }
    public static double simpson2(double a, double b,double n ,double t){
        if (n==0){
            return 0;
        }
        double segment = t/n;
        double[] termsNumber = new double[(int)n+1];
        for (int i = 0; i <termsNumber.length ; i++) {
            termsNumber[i] = i;
        }
        double[] termsValue = new double[(int)n+1];
        for (int i = 0; i <termsValue.length ; i++) {
            termsValue[i] = segment*i;
        }
        double[] termResult = new double[(int)n+1];
        for (int i = 0; i <termResult.length ; i++) {
            if (termsNumber[i]==0){
                //first term
                termResult[i] = (1/C)*current(termsValue[i]);
            }else if (termsNumber[i]==n){
                //last term
                termResult[i] = (1/C)*current(termsValue[i]);
            }else if (termsNumber[i]%2==0){
                //even termsValue
                termResult[i] = 2*(1/C)*current(termsValue[i]);
            }else if(termsNumber[i]%2==1){
                //odd termsValue
                termResult[i] = 4*(1/C)*current(termsValue[i]);
            }
            String x = "This is :" + termsNumber[i] + " term" + " The input: " + termsValue[i] + " The output: " + termResult[i];
            System.out.println(x);
        }
        double finalResult1 = 0;
        for (double v : termResult) {
            finalResult1 = finalResult1 + v;
        }
        double finalResult2 = finalResult1*((b-a)/3*n);
        double finalResult3 = BigDecimal.valueOf(finalResult2)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        System.out.println("The final result is: " + finalResult3);
        return finalResult3;
    }

//    public static double simpson(double a, double b,double n ,double t){
//        if (n==0){
//            return 0;
//        }
//        double h = (b-a)/n;
//
//        double[] termsValue = new double[5];
//        for (int i = 0; i <termsValue.length ; i++) {
//            termsValue[i] = h*i;
//        }
//        double termResult0 = (1/C)*current(0);
//        System.out.println("termResult0"+termResult0);
//        double termResult1 = 4*(1/C)*current(2.375);
//        System.out.println("termResult1"+termResult1);
//        double termResult2 = 2*(1/C)*current(4.75);
//        System.out.println("termResult2"+termResult2);
//        double termResult3 = 4*(1/C)*current(7.125);
//        System.out.println("termResult3"+termResult3);
//        double termResult4 = (1/C)*current(9.5);
//        System.out.println("termResult4"+termResult4);
//        double finalResult1 = termResult0+termResult1+termResult2+termResult3+termResult4;
//        System.out.println("finalResult1"+finalResult1);
//        double finalResult2 = finalResult1*((b-a)/3*n);
//        System.out.println("finalResult2"+finalResult2);
//        double finalResult3 = BigDecimal.valueOf(finalResult2)
//                .setScale(2, RoundingMode.HALF_UP)
//                .doubleValue();
//        return finalResult3;
//    }


}
