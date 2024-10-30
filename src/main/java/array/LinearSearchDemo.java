package array;

import java.util.Scanner;

public class LinearSearchDemo {
    public static void main(String[] args) {
        System.out.println("***LINEAR SEARCH***");

        System.out.println("Enter number of elements in array:");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println("Enter the elements of array:");
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println("Enter the element to be searched:");
        int target = scn.nextInt();

        int index = linearSearch(arr, target);

        if(index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + index);
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Linear Search efficient when:
    // 1. The list is small
    // 2. The list is unordered
    // 3. Sequential memory access
    // 4. Stream or real time data

    // Time Complexity: O(n)
}
