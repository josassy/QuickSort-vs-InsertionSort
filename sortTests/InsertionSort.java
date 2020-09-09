package sortTests;

public class InsertionSort {
	void sort (int array[])
	{
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
