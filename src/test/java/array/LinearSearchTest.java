package array;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearSearchTest {
    @Test
    public void testLinearSearch_ElementPresent() {
        int[] array = {2, 4, 6, 8, 10, 12, 14};

        // Test cases where the element is present
        assertEquals(0, LinearSearchDemo.linearSearch(array, 2));
        assertEquals(3, LinearSearchDemo.linearSearch(array, 8));
        assertEquals(6, LinearSearchDemo.linearSearch(array, 14));
    }

    @Test
    public void testLinearSearch_ElementAbsent() {
        int[] array = {2, 4, 6, 8, 10, 12, 14};

        // Test cases where the element is not present
        assertEquals(-1, LinearSearchDemo.linearSearch(array, 5));
        assertEquals(-1, LinearSearchDemo.linearSearch(array, 9));
        assertEquals(-1, LinearSearchDemo.linearSearch(array, 15));
    }

    @Test
    public void testLinearSearch_EmptyArray() {
        int[] emptyArray = {};

        // Test case for an empty array
        assertEquals(-1, LinearSearchDemo.linearSearch(emptyArray, 3));
    }

    @Test
    public void testLinearSearch_SingleElementArray() {
        int[] singleElementArray = {42};

        // Test case where the element matches the single element in the array
        assertEquals(0, LinearSearchDemo.linearSearch(singleElementArray, 42));

        // Test case where the element does not match the single element in the array
        assertEquals(-1, LinearSearchDemo.linearSearch(singleElementArray, 99));
    }

    @Test
    public void testLinearSearch_MultipleOccurrences() {
        int[] arrayWithDuplicates = {1, 2, 3, 4, 3, 5, 6};

        // Test case where there are multiple occurrences of the target
        assertEquals(2, LinearSearchDemo.linearSearch(arrayWithDuplicates, 3));
    }
}
