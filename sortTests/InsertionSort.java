package sortTests;

/**
 * The InsertionSort class contains a single sort algorithm to perform an
 * insertion sort in place on an integer array.
 * 
 * @author  Rufus R Mathew, Josiah R Lansford
 * @since   2020-09-11
 *  File:   InsertionSort.java
 */
public class InsertionSort {
	
	/**
	 * Perform an in-place insertion sort.
	 * @param array This array contains the data to be sorted
	 */
	public static void sort(int array[]) {
		// The sorting function will loop through the array and then compare 
	  // itself to the next value and it is smaller, then it will swap. 
		for(int i = 1; i < array.length; i++){ 
			int key = array[i]; 
			int j = i - 1;

			// Move all the elements greater than key by one increment
			while (j>=0 && array[j] > key){
			//swapping the array values
				array[j+1] = array[j];
				j = j - 1; 
			}
			array[j+1] = key; //Placing the key by 1 increment
		}
	}
}
