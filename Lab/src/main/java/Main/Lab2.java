package Main;


import static java.lang.Math.*;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;
import util.ErrorUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Lab2 {

    final private static double G = 6.67E-11;//m3/kg*s
    final private static double M = 5.97E24;//kg
    final private static double R = 6371000;//m


    public static double Q1(double T){
        double power = (double)1/3;
        double GM = G*M;
        return pow(((GM*pow(T,2))/(4*pow(Math.PI,2))),power) - R;
    }

    public static double Q2Function(double x){
        return (pow(x,2))/(sqrt(1+sin(x)));
    }

    public static double Q2FunctionDiff(double x){
        //FIRST DERIVATIVE:
        double power = (double) 3/2;
        return (x*(4*sin(x)-x*cos(x)+4))/(2*pow(sin(x)+1,power));
    }

    public static double Q2A(double x, double h){
        return (Q2Function(x+h)-Q2Function(x-h))/(2*h);
    }

    public static double Q2Error(double actualValue,double expectedValue){
        return ErrorUtils.percentageError(actualValue,expectedValue);
    }

    public static double Q2SmallestH(double x){
        //decrease the value of 0.001 h each loop
        double h = 0.2;
        double percentageError = 1;

        while(percentageError>0.01){
            h=h-0.001;
            double actualValue = Q2A(x,h);
            double expectedValue = Q2FunctionDiff(x);
            percentageError = Q2Error(actualValue,expectedValue);
        }
        double h2;
        h2 = BigDecimal.valueOf(h)
                .setScale(4, RoundingMode.HALF_UP)
                .doubleValue();
        return h2;
    }

    public static double Q3(double actualValue,double expectedValue){
        return ErrorUtils.percentageError(actualValue,expectedValue);
    }


}
