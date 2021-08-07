package Main;


import util.ErrorUtils;
import static java.lang.Math.*;
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

    //a = 0, b = 4 , n = 4 exact value =  23.9187
    public static double Q2Trapezoidal(double a ,double b, double n){
        return ((b-a)/(2*n))*((2*(Q2TrapezoidalTerms(b,n)))+Q2Function(b));
    }
    public static double Q2TrapezoidalTerms(double b, double n){
        double a = 2;
        double X1 = Q2Function(b-a/n-1);//2/3
        double X2 = Q2Function(b-a*2/n-1);//4/3
        double X3 = Q2Function(b-a*3/n-1);//6/3
        double X4 = Q2Function(b-a*4/n-1);//8/3
        double X5 = Q2Function(b-a*5/n-1);//10/3
        return X1+X2+X3+X4+X5;
    }

    public static double Q2Simpson(double a ,double b){
        double h = (b-a)/2;
        return (h/3)*(Q2Function(a)+(4*Q2Function((a+b)/2))+Q2Function(b));
    }

    final private static double L = 5;
    final private static double Radius = 1;
    final private static double height = 0.3;
    final private static double Length = Radius-height;

    public static double Q3Function(double x){
        return sqrt(1-x*x);
    }

    public static double Q3Trapezoidal(){
        double b = sqrt(pow(Radius,2)-pow(Length,2));
        double a = 0-b;
        double n = 6;
        double h = (b-a)/n;
        double X1 = Q3Function(a+h);
        double X2 = Q3Function(a+2*h);
        double X3 = Q3Function(a+3*h);
        double X4 = Q3Function(a+4*h);
        double X5 = Q3Function(a+5*h);
        double terms = X1+X2+X3+X4+X5;
        double trapezoidalResult = (h/2)*(Q3Function(abs(a))+2*(terms)+Q3Function(b));
        return (trapezoidalResult - Length*2*(b))*L;
    }

    public static double Q3Simpson(){
        double b = sqrt(pow(Radius,2)-pow(Length,2));
        double a = 0-b;
        double n = 2;
        double h = (b-a)/n;
        double simpsonResult = (h/3)*(Q3Function(a)+(4*Q3Function((a+b)/2))+Q3Function(b));
        return (simpsonResult - Length*2*(b))*L;
    }

//    public static double Q3(){
//        double horizontalLength = Radius-height;//0.7
//        double x = sqrt(pow(Radius,2)-pow(horizontalLength,2));
//        System.out.println(x);
//        double triangleArea =0.7*0.5*2*x;
//        double semicircleArea = ((double)152/360)*PI*pow(Radius,2);
//        double waterArea = semicircleArea - triangleArea;
//        return waterArea;
//    }


}
