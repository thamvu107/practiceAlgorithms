package array;

import java.util.Random;

import static utils.ArrayUtils.*;

public class QuickSortDemo {
    /*
        1. Pick the right most element of the array as the pivot.
        2. Start from the left and find the next element that is larger than the pivot.
        3. Swap this element with the next, which is smaller than pivot element.
        4. Repeat steps 2 and 3 until no more swapping is possible.
        5. Swap the first item which is larger than the pivot's value with the pivot itself.
     */

    public static void main(String[] args) {

        System.out.println("***QUICK SORT***");

        int[] numbers = randomArrayInput(10);
        System.out.println("Before sorting: ");
        printArray(numbers);

        quickSortWithRightPivot(numbers);
        System.out.println("After sorting");
        printArray(numbers);

        int[] numbers2 = randomArrayInput(10);
        System.out.println("\nBefore sorting: ");
        printArray(numbers);

        quickSortWithRandomPivot(numbers2);
        System.out.println("After sorting");
        printArray(numbers2);
    }

    public static void quickSortWithRightPivot(int[] numbers) {
        quickSortWithRightPivot(numbers, 0, numbers.length - 1);
    }

    public static void quickSortWithRandomPivot(int[] numbers) {
        quickSortWithRandomPivot(numbers, 0, numbers.length - 1);
    }

    private static void quickSortWithRandomPivot(int[] numbers, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = numbers[pivotIndex];
        swap(numbers, pivotIndex, highIndex);

        int leftPointer = partition(numbers, lowIndex, highIndex, pivot);

        quickSortWithRandomPivot(numbers, lowIndex, leftPointer - 1);
        quickSortWithRandomPivot(numbers, leftPointer + 1, highIndex);
    }

    private static void quickSortWithRightPivot(int[] numbers, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivot = numbers[highIndex];

        int leftPointer = partition(numbers, lowIndex, highIndex, pivot);

        quickSortWithRightPivot(numbers, lowIndex, leftPointer - 1);
        quickSortWithRightPivot(numbers, leftPointer + 1, highIndex);
    }

    private static int partition(int[] numbers, int lowIndex, int highIndex, int pivot) {

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {

            while (numbers[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (numbers[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(numbers, leftPointer, rightPointer);
        }

        swap(numbers, leftPointer, highIndex);

        // return the pivot's new index
        return leftPointer;
    }

}
