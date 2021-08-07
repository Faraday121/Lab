package Main;

import org.junit.Test;

import static Main.Lab2.*;
import util.ErrorUtils;

import static java.lang.Math.*;
import static org.junit.Assert.*;

public class Lab2Test {

    @Test
    public void q1() {
        double[] test = {86400,5400,2700};
        for (int i = 0; i <test.length ; i++) {
            System.out.println(Q1(test[i]));
        }
        System.out.println("last case is impossible");
    }

    @Test
    public void q2A() {
        double x =3.5;
        double h =0.2;
        double actualValue = Q2A(x,h);
        double expectedValue = Q2FunctionDiff(x);
        double lessError = Q2SmallestH(x);
        System.out.println("The actual value is:"+actualValue);
        System.out.println("The expected value is:"+ expectedValue);
        System.out.println("The percentage error is:"+ Q2Error(actualValue,expectedValue));
        System.out.println("To keep the error less than one percent, h is:" + lessError);
    }

    @Test
    //a = 0, b = 4 , n = 4 exact value =  23.9187
    public void Q2B(){
        double a = 0;
        double b = 4;
        double n = 4;
        double expectedValue = 23.9187;
        System.out.println("Trapezoidal result is:"+Q2Trapezoidal(a,b,n));
        System.out.println("percentageError is:" + ErrorUtils.percentageError(Q2Trapezoidal(a,b,n),expectedValue));
        System.out.println("Simpson result is:"+Q2Simpson(a,b));
        System.out.println("percentageError is:" + ErrorUtils.percentageError(Q2Simpson(a,b),expectedValue));
    }

    @Test
    public void q3(){
        System.out.println("Trapezoidal result is:"+Q3Trapezoidal());
        System.out.println("Simpson result is:"+ Q3Simpson());
    }
}