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
        boolean[] primeNumbers = new boolean[number + 1];
        for (int i =2 ; i*i <= number; i++)
            if(primeNumbers[i] == false)
                for (int j = i*i; j <= number; j += i)
                    primeNumbers[j] = true;

        return primeNumbers;
    }

    public static void sievePrintPrimeNumbers(int number) {
        System.out.println("\nSieve Print Prime Numbers");
        boolean[] primeNumbers = getPrimeNumbers(number);
        for (int i = 2; i <= number; i++) {
            if(primeNumbers[i]==false)
                System.out.print(i + " ");

        }
    }

    public static void main(String[] args) {

        printPrimeNumbers(100);
        sievePrintPrimeNumbers(100);
    }
}
