package array;

import org.junit.jupiter.api.Test;

import static array.SearchBitonicDemo.searchBitonic;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchBitonicTest {
    @Test
    public void testTargetInAscendingPart() {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int bIndex = 3; // peak is 12 at index 3
        int target = 8;
        int result = searchBitonic(arr, target, bIndex);
        assertEquals(2, result, "The target should be found in the ascending part at index 2.");
    }

    @Test
    public void testTargetInDescendingPart() {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int bIndex = 3; // peak is 12 at index 3
        int target = 4;
        int result = searchBitonic(arr, target, bIndex);
        assertEquals(4, result, "The target should be found in the descending part at index 4.");
    }

    @Test
    public void testTargetIsPeak() {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int bIndex = 3; // peak is 12 at index 3
        int target = 12;
        int result = searchBitonic(arr, target, bIndex);
        assertEquals(3, result, "The target is the peak and should be found at index 3.");
    }

    @Test
    public void testTargetNotPresent() {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int bIndex = 3; // peak is 12 at index 3
        int target = 10;
        int result = searchBitonic(arr, target, bIndex);
        assertEquals(-1, result, "The target is not present in the array, should return -1.");
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = {5};
        int bIndex = 0; // only one element, which is also the peak
        int target = 5;
        int result = searchBitonic(arr, target, bIndex);
        assertEquals(0, result, "The single element array should return index 0 if target matches.");
    }

    @Test
    public void testTwoElementArray() {
        int[] arr = {3, 1};
        int bIndex = 0; // peak is 3 at index 0
        int target = 1;
        int result = searchBitonic(arr, target, bIndex);
        assertEquals(1, result, "For a two-element array, the target should be found at index 1.");
    }
}
