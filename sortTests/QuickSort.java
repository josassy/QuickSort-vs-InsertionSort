package sortTests;

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
    int pivot = array[(highIndx - lowIndx) / 2];
    System.out.println("pivot value: " + pivot);
    System.out.println("pivot index: " + (highIndx - lowIndx) / 2);
    // Swap pivot value to end of array
    System.out.println(array.toString())
    Utilities.swap(array, (highIndx - lowIndx) / 2, highIndx);
    System.out.println(array.toString())

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
    int first = array[lowIndx];
    int middle = array[(highIndx - lowIndx)/2]; 
    int last = array[highIndx];

    // find median value of first, middle, last
    int pivot = findMedianValue(first, middle, last);
    
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
    int lower = lowIndx;
    int upper = highIndx - 1;

    while (lower <= upper) {
      // Iterate until find a value less than pivot
      while (lower <= upper && array[upper] >= pivot) {
        upper--;
      }
      // Iterate until find a value more than pivot
      while (lower <= upper && array[lower] <= pivot) {
        lower++;
      }
      // If if indices have not crossed, swap values
      if (lower < upper) {
        Utilities.swap(array, lower, upper);
      }
    }

    Utilities.swap(array, lower, upper);
    return lower;
  }

  /**
   * Find median value of three values
   */
  public static int findMedianValue(int a, int b, int c) {
    // a is greater than b.
    if (a > b) {
      if (b > c) {
        return b;
      }
      else if (a > c) {
        return c;
      }
      else {
        return a;
      }
    }
    // a is not greater than b.
    else {
      if (a > c) {
        return a;
      }
      else if (b > c) {
        return c;
      }
      else {
        return b;
      }
    }
  }
}