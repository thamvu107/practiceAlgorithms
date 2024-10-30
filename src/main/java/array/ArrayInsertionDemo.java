package array;

import java.util.Scanner;

public class ArrayInsertionDemo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter the number of elements in array:");
        int n = scn.nextInt();
        System.out.println("Enter the elements of array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("***MENU***");
        System.out.println("1. Insertion from beginning");
        System.out.println("2. Insertion from specified location");
        System.out.println("3. Insertion from end");
        System.out.println("Enter your choice:");
        int choice = scn.nextInt();
        int value = 0;
        if (n == 10) {
            System.out.println("Overflow error");
        } else {
            switch (choice) {
                case 1:
                    for (int i = n - 1; i >= 0; i--) {
                        arr[i + 1] = arr[i];
                    }

                    value = getNewElementValue(scn);
                    arr[0] = value;

                    printFinalArray(n, arr);
                    break;
                case 2:
                    int pos = getPos(scn);
                    for (int i = n - 1; i >= pos - 1; i--) {
                        arr[i + 1] = arr[i];
                    }

                    value = getNewElementValue(scn);
                    arr[pos - 1] = value;
                    printFinalArray(n, arr);
                    break;
                case 3:
                    value = getNewElementValue(scn);
                    arr[n] = value;
                    printFinalArray(n, arr);
                    break;
                default:
                    System.out.println("Wrong Choice");
                    break;
            }
        }
    }

    private static int getPos(Scanner scn) {
        System.out.println("Enter position");
        return scn.nextInt();
    }

    private static int getNewElementValue(Scanner scn) {
        System.out.println("Enter new value:");
        return scn.nextInt();
    }

    private static void printFinalArray(int n, int[] arr) {
        System.out.println("After insertion array is");
        for (int i = 0; i <= n; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

}
