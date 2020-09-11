package sortTests;

public class InsertionSort {
	/**
	 * 
	 * @param array This array contains the data to be sorted 
	 * The sorting function will loop through the array and then compare 
	 * itself to the next value and it is smaller, then it will swap. 
	 */
	
	public static void sort (int array[]) {
		int n = array.length; //getting the length of the array to be sorted
		for(int i = 1; 1 < n; i++){ //starting the loop 
			int key = array[i]; 
			int j = i - 1;

			//Moving all the elements greater than key by one increment

			while (j>=0 && array[j] > key){
			//swapping the array values
				array[j+1] = array[j];
				j = j - 1; 
			}
			array[j+1] = key; //Placing the key by 1 increment
		}
	}
}
