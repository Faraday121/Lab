package Main;

import static java.lang.Math.*;
import org.apache.commons.math3.*;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;

public class Lab1 {

    final static double pai = 3.14;
    final static double g = 9.8;

    public static double Q1A(double x ){
        return 4.3+3.2*x+8*(pow(x,2));
    }

    public static double Q1B(double x ){
        return 6*pai+1/(sqrt(4+3*x));
    }

    public static double Q1C(double v, double g ,double o){
        //o = 15,30,45,60,75...
        return (2*pow(v,2)*sin(o)*cos(o))/g;
    }

    public static double Q2(double x ){
        //initial velocity(m/s)
        double v = 80;
        //initial height(m)
        double y0 = 50;
        //angle(degree)
        double o =40;
        return y0+ tan(o)*x -(g)/(2*pow(v,2)*pow(cos(o),2))*(pow(x,2));
    }

    public static double Q3A(double t){
        //velocity by time
        return (2*t)/(sqrt(1+pow(t,2)));
    }

    public static double Q3B(double t){
        //acceleration(dv/dt)
        //t = 5.0,v=
        return (2)/((1+pow(t,2))*(sqrt(1+pow(t,2))));
    }

    public static double Q3C(double t, double h){
        //central difference formula
        //difference in the y-values / difference in the x-values

        //assume h = 0.2
        return (Q3A(t+h)-Q3A(t))/h;
    }

    public static double[] Q4A(){
        double[] f = {1.49,1.82,2.23,2.72,3.32,4.06,5.95};
        double[] x = {0.2,0.3,0.4,0.5,0.6,0.7,0.8};

        double[] diff = new double[7];
        for (int i = 0; i <diff.length-1 ; i++) {
            diff[i]=f[i+1]-f[i];
        }
        double result1 = PolynomialFunctionLagrangeForm.evaluate(x,f,0.4);
        double result2 = PolynomialFunctionLagrangeForm.evaluate(x,f,0.6);

        //guess the function is F(x) = AX^2+Bx+C
        double[] result = {result1,result2};
        return result;
    }



}
