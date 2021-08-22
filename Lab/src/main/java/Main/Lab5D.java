package Main;

import javafx.stage.Stage;

public class Lab5D{
    private final static double g = 9.8 ;
    private final static double height = 500;
    private final static double mass = 0.03;
    private final static double initialVelocity = 0;

    public static double Distance(double v ,double t){
        return height+initialVelocity*t-0.5*g*t*t;
    }

    public static double Velocity(double t){
        return initialVelocity-g*t;
    }

    public static double Diff(double t){
        return initialVelocity-g*t;
    }

    public static void main(String[] args) {
        int dataLength = 0;
        for (double i = 0; i <=15&&i>=0;i=i+0.1) {
            dataLength = dataLength+1;
        }
        double[] time = new double[dataLength];
        int index = 0;
        for (double i = 0; i <=15&&i>=0;i=i+0.1) {
            time[index] = i;
            index++;
        }

        double[] velocity = new double[time.length];
        for (int i = 0; i <time.length ; i++) {
            velocity[i] = Velocity(time[i]);
        }
        double[] distance = new double[time.length];
        for (int i = 0; i <time.length ; i++) {
            distance[i] = Distance(velocity[i],time[i]);
        }

        double[] fxy = new double[time.length];
        //f(x,y)=initialVelocity-g*t
        for (int i = 0; i <time.length ; i++) {
            fxy[i] = Diff(time[i]);
        }

        double[] estimateVelocity = new double[time.length];
        estimateVelocity[0]= 0;
        for (int i = 1; i <time.length ; i++) {
            estimateVelocity[i] = estimateVelocity[i-1]+fxy[i]*0.1;
        }

        for (int i = 0; i <time.length ; i++) {
//            System.out.println(velocity[i]);
//            System.out.println(distance[i]);
//            System.out.println(fxy[i]);
            if (-estimateVelocity[i]>height){
                System.out.println("height: "+estimateVelocity[i]);
                System.out.println("velocity: " +velocity[i] );
                System.out.println("time: "+time[i]);
                break;
            }

        }
    }

}
