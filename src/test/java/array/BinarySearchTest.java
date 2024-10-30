package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
    @Test
    public void testBinarySearch_ElementPresent() {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        // Test cases where the element is present
        assertEquals(0, BinarySearchDemo.binarySearch(sortedArray, 1));
        assertEquals(4, BinarySearchDemo.binarySearch(sortedArray, 9));
        assertEquals(9, BinarySearchDemo.binarySearch(sortedArray, 19));
    }

    @Test
    public void testBinarySearch_ElementAbsent() {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        // Test cases where the element is not present
        assertEquals(-1, BinarySearchDemo.binarySearch(sortedArray, 2));
        assertEquals(-1, BinarySearchDemo.binarySearch(sortedArray, 6));
        assertEquals(-1, BinarySearchDemo.binarySearch(sortedArray, 20));
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        int[] emptyArray = {};

        // Test case for an empty array
        assertEquals(-1, BinarySearchDemo.binarySearch(emptyArray, 5));
    }

    @Test
    public void testBinarySearch_SingleElementArray() {
        int[] singleElementArray = {10};

        // Test case where the element matches the single element in the array
        assertEquals(0, BinarySearchDemo.binarySearch(singleElementArray, 10));

        // Test case where the element does not match the single element in the array
        assertEquals(-1, BinarySearchDemo.binarySearch(singleElementArray, 5));
    }

    @Test
    public void testLinearSearch_MultipleOccurrences() {
        int[] arrayWithDuplicates = {1, 2, 3, 3, 4, 5, 6};

        // Test case where there are multiple occurrences of the target
        assertEquals(2, LinearSearchDemo.linearSearch(arrayWithDuplicates, 3));
    }
}
