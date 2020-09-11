package sortTests;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * The Tests class contains methods to test various implementations of
 * the QuickSort and InsertionSort algorithms, outputting the results
 * to a CSV file.
 * 
 * @author  Rufus R Mathew, Josiah R Lansford
 * @since   2020-09-11
 *  File:   Tests.java
 */
public class Tests {
  FileOutputStream fos;
  PrintWriter pw;
 
  /**
   * Run all tests in file, outputting performance data to CSV file
   */
  public void runTests() {
    // Open file
    try {
      fos = new FileOutputStream("AlgorithmsGraph.csv", true);
      pw = new PrintWriter(fos);
    }
    catch (FileNotFoundException e) {
      System.out.println("Unable to open file");
    }

    // Before running performance tests, ensure that each kind of test works properly on a small set of data
    System.out.println("test SinglePointerLast: " + (testSortAlgorithmSinglePointerLast() ? "ok" : "fail"));
    System.out.println("test SinglePointerMedian: " + (testSortAlgorithmSinglePointerMedian() ? "ok" : "fail"));
    System.out.println("test SinglePointerMedianThree: " + (testSortAlgorithmSinglePointerMedianThree() ? "ok" : "fail"));
    System.out.println("test DoublePointerLast: " + (testSortAlgorithmDoublePointerLast() ? "ok" : "fail"));
    System.out.println("test InsertionSort: " + (testSortAlgorithmInsertionSort() ? "ok" : "fail"));

    // 
    pw.println("n:," + mapIntArrayToCSVString(getNValues()));
    pw.println("QuickSort Single Pointer Last Random:," + mapLongArrayToCSVString(sortAlgorithmSinglePointerLastTest()));
    pw.println("QuickSort Single Pointer Last Asc:," + mapLongArrayToCSVString(sortAlgorithmSinglePointerLastAscTest())); 
    pw.println("QuickSort Single Pointer Last Desc:," + mapLongArrayToCSVString(sortAlgorithmSinglePointerLastDescTest())); 
    pw.println("QuickSort Single Pointer Median:," + mapLongArrayToCSVString(sortAlgorithmSinglePointerMedianTest()));
    pw.println("QuickSort Single Pointer Median Three:," + mapLongArrayToCSVString(sortAlgorithmSinglePointerMedianThreeTest()));
    pw.println("QuickSort Double Pointer Last:," + mapLongArrayToCSVString(sortAlgorithmDoublePointerLastTest()));
    pw.println("Insertion Sort Random:," + mapLongArrayToCSVString(sortAlgorithmInsertionSortRandomTest()));
    pw.println("Insertion Sort Asc:," + mapLongArrayToCSVString(sortAlgorithmInsertionSortAscTest()));
    pw.println("Insertion Sort Desc:," + mapLongArrayToCSVString(sortAlgorithmInsertionSortDescTest()));
    
    pw.close();
  }

  /**
   * Generate array of numbers specifying the N size for sorting.
   * Can be configured to support different ranges and granularity.
   */
  public int[] getNValues() {
    int[] result = new int[200];
    int resultIndex = 0;
    for (int i = 50; i <= 10000; i += 50) {
      result[resultIndex++] = i;
    }
    return result;
  }

  public String mapLongArrayToCSVString(long[] array) {
    // map result array to comma-separated string
    return LongStream.of(array)
        .mapToObj(Long::toString)
        .collect(Collectors.joining(", "));
  }

  // Test methods that verify that a given sort algorithm is working properly.

  public Boolean testSortAlgorithmSinglePointerLast() {
    int[] array = generateRandomArray(20);
    QuickSort.sortAlgorithmSinglePointerLast(array, 0, array.length - 1);
    return Utilities.isSortedNonDecreasing(array);
  }

  public Boolean testSortAlgorithmSinglePointerMedian() {
    int[] array = generateRandomArray(20);
    QuickSort.sortAlgorithmSinglePointerMedian(array, 0, array.length - 1);
    return Utilities.isSortedNonDecreasing(array);
  }
  
  public Boolean testSortAlgorithmSinglePointerMedianThree() {
    int[] array = generateRandomArray(20);
    QuickSort.sortAlgorithmSinglePointerMedianThree(array, 0, array.length - 1);
    return Utilities.isSortedNonDecreasing(array);
  }

  public Boolean testSortAlgorithmDoublePointerLast() {
    int[] array = generateRandomArray(20);
    QuickSort.sortAlgorithmDoublePointerLast(array, 0, array.length - 1);
    return Utilities.isSortedNonDecreasing(array);
  }

  public Boolean testSortAlgorithmInsertionSort() {
    int[] array = generateRandomArray(20);
    InsertionSort.sort(array);
    return Utilities.isSortedNonDecreasing(array);
  }

  // BEGIN SORT TEST METHODS

  public long[] sortAlgorithmSinglePointerLastTest(){
    int[] nVals = getNValues();
    long[] result = new long[nVals.length];
    // run 40 times
    for (int i = 0; i < nVals.length; i++) {
      System.out.println("Single Pointer Last Random at n " + nVals[i]);
      // If value less than 10,000, run sort 5 times and average
      if (nVals[i] < 10000) {
        int[] array0 = generateRandomArray(nVals[i]);
        int[] array1 = generateRandomArray(nVals[i]);
        int[] array2 = generateRandomArray(nVals[i]);
        int[] array3 = generateRandomArray(nVals[i]);
        int[] array4 = generateRandomArray(nVals[i]);
        long start = System.nanoTime();
        QuickSort.sortAlgorithmSinglePointerLast(array0, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerLast(array1, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerLast(array2, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerLast(array3, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerLast(array4, 0, array0.length - 1);  
        long end = System.nanoTime();
        result[i] = (end - start) / 5;
      }
      else {
        int[] array = generateRandomArray(nVals[i]);
        long start = System.nanoTime();
        QuickSort.sortAlgorithmSinglePointerLast(array, 0, array.length - 1);
        long end = System.nanoTime();
        result[i] = end - start;
      }
    }
    return result;
  }

  public long[] sortAlgorithmSinglePointerLastAscTest(){
    int[] nVals = getNValues();
    long[] result = new long[nVals.length];
    // run 40 times
    for (int i = 0; i < nVals.length; i++) {
      System.out.println("Single Pointer Last Ascending at n " + nVals[i]);
      // If value less than 10,000, run sort 5 times and average
      if (nVals[i] < 10000) {
        int[] array0 = generateSortedAscArray(nVals[i]);  
        int[] array1 = generateSortedAscArray(nVals[i]);  
        int[] array2 = generateSortedAscArray(nVals[i]);  
        int[] array3 = generateSortedAscArray(nVals[i]);  
        int[] array4 = generateSortedAscArray(nVals[i]);  
        long start = System.nanoTime();
        QuickSort.sortAlgorithmSinglePointerLast(array0, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerLast(array1, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerLast(array2, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerLast(array3, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerLast(array4, 0, array0.length - 1);  
        long end = System.nanoTime();
        result[i] = (end - start) / 5;
      }
      else {
        int[] array = generateSortedAscArray(nVals[i]);
        long start = System.nanoTime();
        QuickSort.sortAlgorithmSinglePointerLast(array, 0, array.length - 1);
        long end = System.nanoTime();
        result[i] = end - start;
      }
    }
    return result;
  }

  public long[] sortAlgorithmSinglePointerLastDescTest(){
    int[] nVals = getNValues();
    long[] result = new long[nVals.length];
    // run 40 times
    for (int i = 0; i < nVals.length; i++) {
      System.out.println("Single Pointer Last Desc at n " + nVals[i]);
      // If value less than 10,000, run sort 5 times and average
      if (nVals[i] < 10000) {
        int[] array0 = generateSortedDescArray(nVals[i]);  
        int[] array1 = generateSortedDescArray(nVals[i]);  
        int[] array2 = generateSortedDescArray(nVals[i]);  
        int[] array3 = generateSortedDescArray(nVals[i]);
        int[] array4 = generateSortedDescArray(nVals[i]);  
        long start = System.nanoTime();
        QuickSort.sortAlgorithmSinglePointerLast(array0, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerLast(array1, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerLast(array2, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerLast(array3, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerLast(array4, 0, array0.length - 1);  
        long end = System.nanoTime();
        result[i] = (end - start) / 5;
      }
      else {
        int[] array = generateSortedDescArray(nVals[i]);
        long start = System.nanoTime();
        QuickSort.sortAlgorithmSinglePointerLast(array, 0, array.length - 1);
        long end = System.nanoTime();
        result[i] = end - start;
      }
    }
    return result;
  }

  public long[] sortAlgorithmSinglePointerMedianTest(){
    int[] nVals = getNValues();
    long[] result = new long[nVals.length];
    // run 40 times
    for (int i = 0; i < nVals.length; i++) {
      System.out.println("Single Pointer Median at n " + nVals[i]);
      // If value less than 10,000, run sort 5 times and average
      if (nVals[i] < 10000) {
        int[] array0 = generateRandomArray(nVals[i]);  
        int[] array1 = generateRandomArray(nVals[i]);  
        int[] array2 = generateRandomArray(nVals[i]);  
        int[] array3 = generateRandomArray(nVals[i]);  
        int[] array4 = generateRandomArray(nVals[i]);  
        long start = System.nanoTime();
        QuickSort.sortAlgorithmSinglePointerMedian(array0, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerMedian(array1, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerMedian(array2, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerMedian(array3, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerMedian(array4, 0, array0.length - 1);  
        long end = System.nanoTime();
        result[i] = (end - start) / 5;
      }
      else {
        int[] array = generateRandomArray(nVals[i]);
        long start = System.nanoTime();
        QuickSort.sortAlgorithmSinglePointerMedian(array, 0, array.length - 1);
        long end = System.nanoTime();
        result[i] = end - start;
      }
    }
    return result;
  }

  public long[] sortAlgorithmSinglePointerMedianThreeTest(){
    int[] nVals = getNValues();
    long[] result = new long[nVals.length];
    // run 40 times
    for (int i = 0; i < nVals.length; i++) {
      System.out.println("Single Pointer Median Three at n " + nVals[i]);
      // If value less than 10,000, run sort 5 times and average
      if (nVals[i] < 10000) {
        int[] array0 = generateRandomArray(nVals[i]);  
        int[] array1 = generateRandomArray(nVals[i]);  
        int[] array2 = generateRandomArray(nVals[i]);  
        int[] array3 = generateRandomArray(nVals[i]);  
        int[] array4 = generateRandomArray(nVals[i]);  
        long start = System.nanoTime();
        QuickSort.sortAlgorithmSinglePointerMedianThree(array0, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerMedianThree(array1, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerMedianThree(array2, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerMedianThree(array3, 0, array0.length - 1);  
        QuickSort.sortAlgorithmSinglePointerMedianThree(array4, 0, array0.length - 1);  
        long end = System.nanoTime();
        result[i] = (end - start) / 5;
      }
      else {
        int[] array = generateRandomArray(nVals[i]);
        long start = System.nanoTime();
        QuickSort.sortAlgorithmSinglePointerMedianThree(array, 0, array.length - 1);
        long end = System.nanoTime();
        result[i] = end - start;
      }
    }
    return result;
  }

  public long[] sortAlgorithmDoublePointerLastTest(){
    int[] nVals = getNValues();
    long[] result = new long[nVals.length];
    // run 40 times
    for (int i = 0; i < nVals.length; i++) {
      System.out.println("Double Pointer Last at n " + nVals[i]);
      // If value less than 10,000, run sort 5 times and average
      if (nVals[i] < 10000) {
        int[] array0 = generateRandomArray(nVals[i]);  
        int[] array1 = generateRandomArray(nVals[i]);  
        int[] array2 = generateRandomArray(nVals[i]);  
        int[] array3 = generateRandomArray(nVals[i]);  
        int[] array4 = generateRandomArray(nVals[i]);  
        long start = System.nanoTime();
        QuickSort.sortAlgorithmDoublePointerLast(array0, 0, array0.length - 1);  
        QuickSort.sortAlgorithmDoublePointerLast(array1, 0, array0.length - 1);  
        QuickSort.sortAlgorithmDoublePointerLast(array2, 0, array0.length - 1);  
        QuickSort.sortAlgorithmDoublePointerLast(array3, 0, array0.length - 1);  
        QuickSort.sortAlgorithmDoublePointerLast(array4, 0, array0.length - 1);  
        long end = System.nanoTime();
        result[i] = (end - start) / 5;
      }
      else {
        int[] array = generateRandomArray(nVals[i]);
        long start = System.nanoTime();
        QuickSort.sortAlgorithmDoublePointerLast(array, 0, array.length - 1);
        long end = System.nanoTime();
        result[i] = end - start;
      }
    }
    return result;
  }

  public long[] sortAlgorithmInsertionSortRandomTest(){
    int[] nVals = getNValues();
    long[] result = new long[nVals.length];
    // run 40 times
    for (int i = 0; i < nVals.length; i++) {
      System.out.println("Insertion Sort Random at n " + nVals[i]);
      // If value less than 10,000, run sort 5 times and average
      if (nVals[i] < 10000) {
        int[] array0 = generateRandomArray(nVals[i]);  
        int[] array1 = generateRandomArray(nVals[i]);  
        int[] array2 = generateRandomArray(nVals[i]);  
        int[] array3 = generateRandomArray(nVals[i]);  
        int[] array4 = generateRandomArray(nVals[i]);  
        long start = System.nanoTime();
        InsertionSort.sort(array0);  
        InsertionSort.sort(array1);  
        InsertionSort.sort(array2);  
        InsertionSort.sort(array3);  
        InsertionSort.sort(array4);  
        long end = System.nanoTime();
        result[i] = (end - start) / 5;
      }
      else {
        int[] array = generateRandomArray(nVals[i]);
        long start = System.nanoTime();
        InsertionSort.sort(array); 
        long end = System.nanoTime();
        result[i] = end - start;
      }
    }
    return result;
  }

  public long[] sortAlgorithmInsertionSortAscTest(){
    int[] nVals = getNValues();
    long[] result = new long[nVals.length];
    // run 40 times
    for (int i = 0; i < nVals.length; i++) {
      System.out.println("Insertion Sort Asc at n " + nVals[i]);
      // If value less than 10,000, run sort 5 times and average
      if (nVals[i] < 10000) {
        int[] array0 = generateSortedAscArray(nVals[i]);  
        int[] array1 = generateSortedAscArray(nVals[i]);  
        int[] array2 = generateSortedAscArray(nVals[i]);  
        int[] array3 = generateSortedAscArray(nVals[i]);  
        int[] array4 = generateSortedAscArray(nVals[i]);  
        long start = System.nanoTime();
        InsertionSort.sort(array0);  
        InsertionSort.sort(array1);  
        InsertionSort.sort(array2);  
        InsertionSort.sort(array3);  
        InsertionSort.sort(array4);  
        long end = System.nanoTime();
        result[i] = (end - start) / 5;
      }
      else {
        int[] array = generateSortedAscArray(nVals[i]);
        long start = System.nanoTime();
        InsertionSort.sort(array); 
        long end = System.nanoTime();
        result[i] = end - start;
      }
    }
    return result;
  }

  public long[] sortAlgorithmInsertionSortDescTest(){
    int[] nVals = getNValues();
    long[] result = new long[nVals.length];
    // run 40 times
    for (int i = 0; i < nVals.length; i++) {
      System.out.println("Insertion Sort Desc at n " + nVals[i]);
      // If value less than 10,000, run sort 5 times and average
      if (nVals[i] < 10000) {
        int[] array0 = generateSortedDescArray(nVals[i]);  
        int[] array1 = generateSortedDescArray(nVals[i]);  
        int[] array2 = generateSortedDescArray(nVals[i]);  
        int[] array3 = generateSortedDescArray(nVals[i]);  
        int[] array4 = generateSortedDescArray(nVals[i]);  
        long start = System.nanoTime();
        InsertionSort.sort(array0);  
        InsertionSort.sort(array1);  
        InsertionSort.sort(array2);  
        InsertionSort.sort(array3);  
        InsertionSort.sort(array4);  
        long end = System.nanoTime();
        result[i] = (end - start) / 5;
      }
      else {
        int[] array = generateSortedDescArray(nVals[i]);
        long start = System.nanoTime();
        InsertionSort.sort(array); 
        long end = System.nanoTime();
        result[i] = end - start;
      }
    }
    return result;
  }

  /**
   * Generate int array filled with random numbers
   * @param n the size of the desired array
   */
  public int[] generateRandomArray(int n) {
    Random rand = new Random();
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = rand.nextInt(n);
    }
    return array;
  }

  /**
   * Generate int array filled with numbers in ascending order
   * @param n the size of the desired array
   */
  public int[] generateSortedAscArray(int n) {
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = i + 1;
    }
    return array;
  }

  /**
   * Generate int array filled with numbers in descending order
   * @param n the size of the desired array
   */
  public int[] generateSortedDescArray(int n) {
    int[] array = new int[n];
    for (int i = n-1; i < 0; i--) {
      array[i] = i + 1;
    }
    return array;
  }

  public String mapIntArrayToCSVString(int[] array) {
    return IntStream.of(array)
        .mapToObj(Integer::toString)
        .collect(Collectors.joining(", "));
  }
}
