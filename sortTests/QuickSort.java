package sortTests;
import java.util.Arrays;

//Implementing Quicksort
public class QuickSort {
  
  /**
   * Sort algorithm using single pointer partition on end of array.
   * @param array    The array contains the data to be sorted and analyzed
   * @param lowIndx  The lower index when we partition the array
   * @param highIndx The higher index when we partition the array
   */
  public static void sortAlgorithmSinglePointerLast(int array[], int lowIndx, int highIndx) {
    if (lowIndx < highIndx) { // ensuring the two indexes have not met

      // this function implements quick sort by rearranging the array
      // such that all the smaller values than pivot is on the left
      // side and all the larger values than pivot are on the right side of the pivot.
      int pivot = partitionSinglePointerLast(array, lowIndx, highIndx);

      sortAlgorithmSinglePointerLast(array, lowIndx, pivot - 1); // Recursively sorting all elements before the pivot point
      sortAlgorithmSinglePointerLast(array, pivot + 1, highIndx); // Recursively sorting all elements after the pivot point
    }
  }

  /**
   * Sort algorithm using single pointer partition on end of array.
   * @param array    The array contains the data to be sorted and analyzed
   * @param lowIndx  The lower index when we partition the array
   * @param highIndx The higher index when we partition the array
   */
  public static void sortAlgorithmSinglePointerMedian(int array[], int lowIndx, int highIndx) {
    if (lowIndx < highIndx) { // ensuring the two indexes have not met

      // this function implements quick sort by rearranging the array
      // such that all the smaller values than pivot is on the left
      // side and all the larger values than pivot are on the right side of the pivot.
      int pivot = partitionSinglePointerMedian(array, lowIndx, highIndx);

      sortAlgorithmSinglePointerMedian(array, lowIndx, pivot - 1); // Recursively sorting all elements before the pivot point
      sortAlgorithmSinglePointerMedian(array, pivot + 1, highIndx); // Recursively sorting all elements after the pivot point
    }
  }

  /**
   * Sort algorithm using single pointer partition on end of array.
   * @param array    The array contains the data to be sorted and analyzed
   * @param lowIndx  The lower index when we partition the array
   * @param highIndx The higher index when we partition the array
   */
  public static void sortAlgorithmSinglePointerMedianThree(int array[], int lowIndx, int highIndx) {
    if (lowIndx < highIndx) { // ensuring the two indexes have not met

      // this function implements quick sort by rearranging the array
      // such that all the smaller values than pivot is on the left
      // side and all the larger values than pivot are on the right side of the pivot.
      int pivot = partitionSinglePointerMedianThree(array, lowIndx, highIndx);

      sortAlgorithmSinglePointerMedianThree(array, lowIndx, pivot - 1); // Recursively sorting all elements before the pivot point
      sortAlgorithmSinglePointerMedianThree(array, pivot + 1, highIndx); // Recursively sorting all elements after the pivot point
    }
  }

  /**
   * Sort algorithm using single pointer partition on end of array.
   * @param array    The array contains the data to be sorted and analyzed
   * @param lowIndx  The lower index when we partition the array
   * @param highIndx The higher index when we partition the array
   */
  public static void sortAlgorithmDoublePointerLast(int array[], int lowIndx, int highIndx) {
    if (lowIndx < highIndx) { // ensuring the two indexes have not met

      // this function implements quick sort by rearranging the array
      // such that all the smaller values than pivot is on the left
      // side and all the larger values than pivot are on the right side of the pivot.
      int pivot = partitionDoublePointerLast(array, lowIndx, highIndx);

      sortAlgorithmDoublePointerLast(array, lowIndx, pivot - 1); // Recursively sorting all elements before the pivot point
      sortAlgorithmDoublePointerLast(array, pivot + 1, highIndx); // Recursively sorting all elements after the pivot point
    }
  }

  public static int partitionSinglePointerLast(int array[], int lowIndx, int highIndx) {
    // Choose the pivot point at the end of the array.
    // Partition array on left and right of pivot point.
    int pivot = array[highIndx]; // Our pivot point starts at the end of the array
    
    // Create pointer variable to keep track of pivot location
    int lowPointer = lowIndx - 1; // index of smaller element
    for (int i = lowIndx; i < highIndx; i++) {
      // If current element is smaller than the pivot, increment
      // the pointer and swap array values 
      if (array[i] <= pivot) {
        lowPointer++;
        Utilities.swap(array, lowPointer, i);
      }
    }

    // increment lowPointer
    lowPointer++;

    // To finish, swap pivot into pointer location
    Utilities.swap(array, lowPointer, highIndx);

    return lowPointer;
  }

  public static int partitionSinglePointerMedian(int array[], int lowIndx, int highIndx) {
    // Choose pivot at median index
    int pivot = array[(highIndx + lowIndx) / 2];

    // Swap pivot value to end of array
    Utilities.swap(array, (highIndx + lowIndx) / 2, highIndx);

    // Now that pivot is at end of array, partition array
    // Create pointer variable to keep track of pivot location
    int lowPointer = lowIndx - 1; // index of smaller element
    for (int i = lowIndx; i < highIndx; i++) {
      // If current element is smaller than the pivot, increment
      // the pointer and swap array values 
      if (array[i] <= pivot) {
        lowPointer++;
        Utilities.swap(array, lowPointer, i);
      }
    }

    // increment lowPointer
    lowPointer++;

    // To finish, swap pivot into pointer location
    Utilities.swap(array, lowPointer, highIndx);

    return lowPointer;
  }

  public static int partitionSinglePointerMedianThree(int array[], int lowIndx, int highIndx) {
    // Pivot at median value of first, middle, and last indices
    // Partition array on left and right of pivot point.
    int pivotIndex = findMedianIndexByValue(array, lowIndx, (highIndx + lowIndx) / 2, highIndx);
    int pivot = array[pivotIndex];

    // Swap pivot value to end of array
    Utilities.swap(array, pivotIndex, highIndx);
        
    // Now that pivot is at end of array, partition array
    // Create pointer variable to keep track of pivot location
    int lowPointer = lowIndx - 1; // index of smaller element
    for (int i = lowIndx; i < highIndx; i++) {
      // If current element is smaller than the pivot, increment
      // the pointer and swap array values 
      if (array[i] <= pivot) {
        lowPointer++;
        Utilities.swap(array, lowPointer, i);
      }
    }

    // increment lowPointer
    lowPointer++;

    // To finish, swap pivot into pointer location
    Utilities.swap(array, lowPointer, highIndx);

    return lowPointer;
  }

  /**
   * Partition algorithm using double pointers, pick last element in array to be pivot
   * @param array    the array to partition
   * @param lowIndx  the lowest index of the partition
   * @param highIndx the highest index of the partition
   */
  public static int partitionDoublePointerLast(int array[], int lowIndx, int highIndx) {
    int pivot = array[highIndx];
    int lowerPtr = lowIndx;
    int upperPtr = highIndx - 1;

    while (lowerPtr <= upperPtr) {
      // Iterate until find a value less than pivot
      while (lowerPtr <= upperPtr && array[upperPtr] >= pivot) {
        upperPtr--;
      }
      // Iterate until find a value more than pivot
      while (lowerPtr <= upperPtr && array[lowerPtr] <= pivot) {
        lowerPtr++;
      }
      // If indices have not crossed, swap values
      if (lowerPtr < upperPtr) {
        Utilities.swap(array, lowerPtr, upperPtr);
      }
    }

    Utilities.swap(array, lowerPtr, highIndx);
    return lowerPtr;
  }

  /**
   * Find the index corresponding to the median value in the array.
   * @param A the array to search
   * @param a first index
   * @param b second index
   * @param c third index
   */
  public static int findMedianIndexByValue(int[] A, int a, int b, int c) {
    // a is greater than b.
    if (A[a] > A[b]) {
      if (A[b] > A[c]) {
        return b;
      }
      else if (A[a] > A[c]) {
        return c;
      }
      else {
        return a;
      }
    }
    // a is not greater than b.
    else {
      if (A[a] > A[c]) {
        return a;
      }
      else if (A[b] > A[c]) {
        return c;
      }
      else {
        return b;
      }
    }
  }
}