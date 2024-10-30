package array;

import java.util.Scanner;

public class ArrayDeletionDemo {
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
        System.out.println("1. Deletion from beginning");
        System.out.println("2. Deletion from specified location");
        System.out.println("3. Deletion from end");
        System.out.println("Enter your choice:");
        int choice = scn.nextInt();
        if (n == 10) {
            System.out.println("Overflow error");
        } else {
            switch (choice) {
                case 1:
                    for (int i = 0; i < n - 1; i++) {
                        arr[i] = arr[i + 1];
                    }
                    printFinalArray(n - 1, arr);
                    break;
                case 2:
                    System.out.println(" Enter position");
                    int pos = scn.nextInt();
                    for (int i = pos - 1; i < n - 1; i++) {
                        arr[i] = arr[i + 1];
                    }
                    printFinalArray(n - 1, arr);
                    break;
                case 3:
                    printFinalArray(n-1, arr);
                    break;
                default:
                    System.out.println("Wrong Choice");
                    break;
            }
        }

    }

    private static void printFinalArray(int n, int[] arr) {
        System.out.println(" After deletion array is");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}

