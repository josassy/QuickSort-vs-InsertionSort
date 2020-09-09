package sortTests;

//Implementing Quicksort
public class QuickSort
{
	void sortAlgorithm(int array[], int lowIndx, int highIndx)
	{
		if (lowIndx < highIndx){ // ensuring the two indexes have not met

		 // this function implements quick sort by rearranging the array 
		 //	such that all the smaller values than pivot is on the left
		 // side and all the larger values than pivot are on the right side of the pivot.
			int pivot = partition (array, lowIndx, highIndx);

			sortAlgorithm (array, low, pivot-1) //Recursively sorting all elements before the pivot point
			sortAlgorithm (array, pivot+1, high) //Recursively sorting all elements after the pivot point
		}
	}

	int partition(int array [], int lowIndx, int highIndx)
	{ 
        int pivot = array[highIndx]; //Our pivot point starts at the end of the array  
        int i = (lowIndx-1); // index of smaller element 
        for (int j=lowIndx; j<highIndx; j++) 
        { 
            // If current element is smaller than the pivot 
            if (array[j] < pivot) 
            { 
                i++; 
  
                // swap array[i] and array[j] 
                int temp = array[i]; 
                array[i] = array[j]; 
                array[j] = temp; 
            } 
        } 
  
        // swap array[i+1] and array[highIndx] (or pivot) 
        int temp = array[i+1]; 
        array[i+1] = array[high]; 
        array[high] = temp; 
  
        return i+1; 
    } 
{