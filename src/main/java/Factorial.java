public class Factorial {

    private Factorial(){

    }
    public static long factorial(int n) {
        if( n < 0)
            throw new IllegalArgumentException("Negative number is invalid input value.");

        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }

        return res;
    }

}
