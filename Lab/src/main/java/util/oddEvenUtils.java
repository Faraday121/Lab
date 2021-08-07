package util;

public class oddEvenUtils {

    public static void filler(double n){
        int baseNUmber = (int)n/2;
        //get the odd and even terms
        if (n%2==0){
            //even parts
            double[] odd = new double[baseNUmber];
            double[] even = new double[baseNUmber];
            for (int i = 0; i <odd.length ; i++) {
                odd[i]=2*i+1;
            }
            for (int i = 0; i <even.length ; i++) {
                even[i] = 2*i+2;
            }
        }else if (n%2!=0){
            //odd parts
            double[] odd = new double[baseNUmber+1];
            double[] even = new double[baseNUmber];
            for (int i = 0; i <odd.length ; i++) {
                odd[i]=2*i+1;
            }
            for (int i = 0; i <even.length ; i++) {
                even[i] =2*i+2;
            }
        }
    }
}
