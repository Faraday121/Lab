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
    public static double simpson(double a, double b,double n ,double t){
        if (n==0){
            return 0;
        }
        double segment = t/n;
        double[] termsNumber = new double[(int)n];
        for (int i = 0; i <termsNumber.length ; i++) {
            termsNumber[i] = i+1;
        }
        double[] termsValue = new double[(int)n];
        for (int i = 0; i <termsValue.length ; i++) {
            termsValue[i] = segment*(i+1);
        }
        double[] termResult = new double[(int)n];
        for (int i = 0; i <termResult.length ; i++) {
            if (termsNumber[i]==1){
                //first term
                termResult[i] = (1/C)*current(termsValue[i]);
            }else if (termsNumber[i]==n){
                //last term
                termResult[i] = (1/C)*current(termsValue[i]);
            }else if ((termsNumber[i]%2==0)&&(termsNumber[i]!=n)){
                //even termsValue
                termResult[i] = 4*(1/C)*current(termsValue[i]);

            }else if((termsNumber[i]%2==1)&&(termsNumber[i]!=1)){
                //odd termsValue
                termResult[i] = 2*(1/C)*current(termsValue[i]);
            }
        }
        double finalResult1 = 0;
        for (double v : termResult) {
            finalResult1 = finalResult1 + v;
        }
        double finalResult2 = finalResult1*((b-a)/3*n);
        double finalResult3 = BigDecimal.valueOf(finalResult2)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        return finalResult3;
    }

}
