public class PrimeNumbers {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        if (number <= 3) {
            return true; // 2 and 3 are primes
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;

        }

        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printPrimeNumbers(int number) {
        System.out.println("Print Prime Numbers");
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean[] getPrimeNumbers(int number) {
        if(number<=1)
            return new boolean[0];

        boolean[] primeNumbers = new boolean[number + 1];
        for (int i =2 ; i*i <= number; i++)
            if(!primeNumbers[i])
                for (int j = i*i; j <= number; j += i)
                    primeNumbers[j] = true; // mark none prime numbers

        return primeNumbers;
    }

    public static void sievePrintPrimeNumbers(int number) {
        System.out.println("\nSieve Print Prime Numbers");
        boolean[] primeNumbers = getPrimeNumbers(number);

        if(primeNumbers.length==0)
            System.out.println("Please enter number greater than 1");

        for (int i = 2; i <= number; i++) {
            if(primeNumbers[i]==false)
                System.out.print(i + " ");

        }
    }

    public static void main(String[] args) {

        printPrimeNumbers(3);
        sievePrintPrimeNumbers(1);
        sievePrintPrimeNumbers(2);
    }
}
