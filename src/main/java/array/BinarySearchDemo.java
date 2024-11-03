package array;


public class BinarySearchDemo {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int target = 5;
        int found = binarySearch(arr, target);

        if (found == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + found);
        }


        int[] sortedNumbers = {1, 3, 5, 7, 9, 11, 13, 15}; // sorted array
        int targetNumber = 4;

        boolean foundNumber = binarySearch(targetNumber, sortedNumbers, 0, sortedNumbers.length - 1);
        System.out.println("Target found: " + foundNumber);  // Should print true if target is in array
    }


    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static boolean binarySearch(int x, int[] sortedNumbers, int start, int end) {
        if (start <= end) {
            int mid = (end - start) / 2 + start;
            if (sortedNumbers[mid] == x) return true;
            if (sortedNumbers[mid] > x)
                return binarySearch(x, sortedNumbers, start, mid - 1);
            return binarySearch(x, sortedNumbers, mid + 1, end);
        }
        return false;
    }
}
