package array;

import static utils.ArrayUtils.printArray;
import static utils.ArrayUtils.swap;

public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 6, 8};
        System.out.println("Before sorting");
        printArray(arr);

        System.out.println("After sorting");
        selectionSort(arr);
        printArray(arr);
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }



}
