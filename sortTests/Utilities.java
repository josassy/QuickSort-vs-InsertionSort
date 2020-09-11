package sortTests;

import java.util.Arrays;

public class Utilities {
  /**
   * @param array the integer array
   * @return if the array is sorted in non-decreasing order
   */
  public static Boolean isSortedNonDecreasing(int[] array) {
    System.out.println(Arrays.toString(array));
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] > array[i + 1]) {
        return false;
      }
    }
    return true;
  }
 
  /**
   * Swap the elements of the array in place.
   * @param array the array to swap on
   * @param low   the low index 
   * @param high  the high index
   */
  public static void swap(int array[], int low, int high) {
    int temp = array[low];
    array[low] = array[high];
    array[high] = temp;
  }
}
