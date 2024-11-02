package array;

import java.util.Arrays;

public class BinarySearchInsertionDemo {
    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 6, 8};

        int target = 5;

        int insertionPoint = binarySearchInsertionSimple(nums, target);

        int[] newArray = insertAtPosition(nums, target, insertionPoint);

        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.println("Target to insert: " + target);
        System.out.println("Insertion point: " + insertionPoint);
        System.out.println("New array after insertion: " + Arrays.toString(newArray));


        int[] duplicatedNums = {1, 3, 4, 5, 5, 6, 8};
        int target2 = 5;

        int insertionPoint2 = binarySearchInsertion(duplicatedNums, target2);

        int[] newArray2 = insertAtPosition(duplicatedNums, target2, insertionPoint2);

        System.out.println("\nOriginal array: " + Arrays.toString(duplicatedNums));
        System.out.println("Target to insert: " + target2);
        System.out.println("Insertion point: " + insertionPoint2);
        System.out.println("New array after insertion: " + Arrays.toString(newArray2));
    }

    /* Binary search for insertion point (no duplicate elements) */
    public static int binarySearchInsertionSimple(int[] nums, int target) {
        int i = 0, j = nums.length - 1; // Initialize double closed interval [0, n-1]
        while (i <= j) {
            int m = i + (j - i) / 2; // Calculate midpoint index m
            if (nums[m] < target) {
                i = m + 1; // Target is in interval [m+1, j]
            } else if (nums[m] > target) {
                j = m - 1; // Target is in interval [i, m-1]
            } else {
                return m; // Found target, return insertion point m
            }
        }
        // Did not find target, return insertion point i
        return i;
    }


    /* Binary search for insertion point (with duplicate elements) */
    public static int binarySearchInsertion(int[] nums, int target) {
        int i = 0, j = nums.length - 1; // Initialize double closed interval [0, n-1]
        while (i <= j) {
            int m = i + (j - i) / 2; // Calculate midpoint index m
            if (nums[m] < target) {
                i = m + 1; // Target is in interval [m+1, j]
            } else if (nums[m] > target) {
                j = m - 1; // Target is in interval [i, m-1]
            } else {
                j = m - 1; // First element less than target is in interval [i, m-1]
            }
        }
        // Return insertion point i
        return i;
    }

    public static int[] insertAtPosition(int[] nums, int target, int index) {
        int[] result = new int[nums.length + 1];

        // Copy elements before insertion point
        for (int i = 0; i < index; i++) {
            result[i] = nums[i];
        }

        // Insert target at the specified index
        result[index] = target;

        // Copy remaining elements after the insertion point
        for (int i = index; i < nums.length; i++) {
            result[i + 1] = nums[i];
        }

        return result;
    }
}
