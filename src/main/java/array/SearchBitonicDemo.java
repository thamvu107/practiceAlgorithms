package array;

public class SearchBitonicDemo {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 9, 10, 2, 1};
        int bIndex = findBitonicPoint(arr);
        int target = 8;
        int res = searchBitonic(arr, target, bIndex);
        if (res != -1) {
            System.out.println("Element " + target + " found at index " + res);
        } else {
            System.out.println("Element not found");
        }

    }

    public static int searchBitonic(int[] arr, int target, int bIndex) {

        if (target > arr[bIndex]) {
            return -1;
        }

        if (target == arr[bIndex]) {
            return bIndex;
        }

        int res1 = ascendingBinarySearch(arr, target, bIndex);
        if (res1 != -1) {
            return res1;
        }

        int res2 = descendingBinarySearch(arr, target, bIndex);
        if (res2 != -1) {
            return res2;
        }

        return -1;
    }

    public static int findBitonicPoint(int[] arr) {
        int left = 0, right = arr.length - 1, mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public static int ascendingBinarySearch(int[] arr, int target, int bIndex) {

        int low = 0, high = bIndex - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int descendingBinarySearch(int[] arr, int target, int bIndex) {

        int low = bIndex + 1, high = arr.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
