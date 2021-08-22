package Main;

public class Lab3 {
    //T(t) = C1*e^(-kt)+Ts
    //Ts is the surrounding temperature

    //0.11607	30.0587845	25	1	23
    //about 23 minutes

    public static final double C1 = 73;
    public static final double Ts = 25;
    public static final double k = 0.11607;

    public static double Function(double t){
        return  C1*Math.exp(-k*t)+Ts;
    }

    //Eula
    public static double Eula(){
        //x=time
        //f(x,y)=-k(T-25)
        //h=1(min)
        //y=Temp

        //to 30 degree
        double T = 98;
        double t = 0;
        while(T>30){
            t = t+1;
            double power = -k*t;
            T=C1*Math.exp(power)+25;
            System.out.println(T);
        }

        return  t;
    }

}
