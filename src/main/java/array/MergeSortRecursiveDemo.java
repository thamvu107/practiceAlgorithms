package array;

import static utils.ArrayUtils.printArray;
import static utils.ArrayUtils.randomArrayInput;

public class MergeSortRecursiveDemo {
    public static void main(String[] args) {

        int[] arr = randomArrayInput(10);
        System.out.println("Before sorting");
        printArray(arr);

        mergeSort(arr);
        System.out.println("After sorting");
        printArray(arr);
    }

    private static void mergeSort(int[] arr) {

        int arrLength = arr.length;

        if (arrLength < 2) {
            return;
        }

        int midIndex = arrLength / 2;
        int[] left = new int[midIndex];
        int[] right = new int[arrLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            left[i] = arr[i];
        }

        for (int i = midIndex; i < arrLength; i++) {
            right[i - midIndex] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {

        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < leftLength) {
            arr[k++] = left[i++];
        }

        while (j < rightLength) {
            arr[k++] = right[j++];
        }

    }
}
