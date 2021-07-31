package Main;

public class Lab1Test {

    @org.junit.Test
    public void q1A() {
        System.out.println(Lab1.Q1A(3.6));
    }

    @org.junit.Test
    public void q1B() {
        System.out.println(Lab1.Q1B(19.4));
    }

    @org.junit.Test
    public void q1C() {
        double v = 10;
        double g =9.81;
        double[] o = {15,30,45,60,75};
        for (double value : o) {
            double result = Lab1.Q1C(v, g, value);
            System.out.println("o is " + value + ", result is" + result);
        }
    }

    @org.junit.Test
    public void q2() {
        //take x from 1 to 10;
        double[] x = {1,2,3,4,5,6,7,8,9,10};
        for (double v : x) {
            double result = Lab1.Q2(v);
            System.out.println(result);
        }
    }

    @org.junit.Test
    public void q3() {

        double result1 = Lab1.Q3B(5.0);
        System.out.println("using the t = 5.0s , the acceleration is :"+result1);

        double result2 = Lab1.Q3C(5.0,0.2);
        System.out.println("using the h = 0.2 , the acceleration is :"+result2);

    }

    @org.junit.Test
    public void Q4(){
        double[] result = Lab1.Q4A();
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }

    }


}