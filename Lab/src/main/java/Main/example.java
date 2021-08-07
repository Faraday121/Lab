package Main;

public class example {

//    public static void main(String[] args) {
//        int n =4;
//        int baseNUmber = (int)n/2;
//        //get the odd and even terms
//        if (n%2==0){
//            //even parts
//            double[] odd = new double[baseNUmber];
//            double[] even = new double[baseNUmber];
//            System.out.println(odd.length+" "+ even.length);
//            for (int i = 0; i <odd.length ; i++) {
//                odd[i]=2*i+1;
//                System.out.println(odd[i]);
//            }
//            for (int i = 0; i <even.length ; i++) {
//                even[i] = 2*i+2;
//                System.out.println(even[i]);
//            }
//        }else if (n%2!=0){
//            //odd parts
//            double[] odd = new double[baseNUmber+1];
//            double[] even = new double[baseNUmber];
//            for (int i = 0; i <odd.length ; i++) {
//                odd[i]=2*i+1;
//            }
//            for (int i = 0; i <even.length ; i++) {
//                even[i] =2*i+2;
//            }
//        }
//
//
//    }

    public static void main(String[] args) {
        double t = 9.5;
        double n = 4;
        double segment = t/n;
        double[] termsNumber = new double[(int)n];
        for (int i = 0; i <termsNumber.length ; i++) {
            termsNumber[i] = i+1;
            System.out.println(termsNumber[i]);
        }
        double[] terms = new double[(int)n];
        for (int i = 0; i <terms.length ; i++) {
            terms[i] = segment*(i+1);
            System.out.println(terms[i]);
        }
    }
}
