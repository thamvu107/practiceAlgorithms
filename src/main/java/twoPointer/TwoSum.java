package twoPointer;

import java.util.Arrays;

public class TwoSum {
    static boolean twoSum(int[] inputArray, int target) {
        Arrays.sort(inputArray);

         int left = 0, right = inputArray.length - 1;
         while (left < right) {
             int sum = inputArray[left] + inputArray[right];
             if( sum == target) {
                 return true;
             } else if (sum < target) {
                 left++;
             } else {
                 right--;
             }
         }

         return false;
    }
}
