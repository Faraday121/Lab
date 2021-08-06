package Main;

import org.junit.Test;

import static Main.Lab2.*;
import static org.junit.Assert.*;

public class Lab2Test {

    @Test
    //1day =86400s,90s,45s
    public void q1() {
        double[] test = {86400,90,45};
        for (int i = 0; i <test.length ; i++) {
            System.out.println(Q1(test[i]));
        }
    }

    @Test
    public void q2() {
        double x =3.5;
        double h =0.2;
        double actualValue = Q2A(x,h);
        double expectedValue = Q2FunctionDiff(x);
        double lessError = Q2SmallestH(x);
        System.out.println("The actual value is:"+actualValue);
        System.out.println("The expected value is:"+ expectedValue);
        System.out.println("The percentage error is:"+ Q2Error(actualValue,expectedValue));
        System.out.println("To keep the error less than one percent, h is:" + Q2SmallestH(x));
    }
}