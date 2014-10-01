package SortingAlgorithms;

public class QuickSort implements ISorter{

	public QuickSort(){}
	
	public int[] Sort(int[] inputArray){
		int[] sortedArray = inputArray;
		
		return quickSort(sortedArray, 0, sortedArray.length-1);
		
	}
	private int[] quickSort(int[] input, int start, int end){
		if(start<end){
			int pivot = partition(input, start, end);
			quickSort(input, start, pivot-1);
			quickSort(input, pivot+1, end);
		}
		return input;
	}
	private int partition(int[] input, int start, int end){
		int partitionLocation = start+((end-start)/2);
		int pivot = input[partitionLocation];
		swap(input, partitionLocation, end);
		int storeIndex = start;
		for(int i=start; i<end; i++){
			if(input[i]<pivot)
			{
				swap(input, i, storeIndex);
				storeIndex++;
			}
		}
		swap(input, storeIndex, end);
		return storeIndex;
	}
	private void swap(int[] input, int firstLocation, int lastLocation){
		int tempValue = input[firstLocation];
		input[firstLocation] = input[lastLocation];
		input[lastLocation] = tempValue;
		
	}
	
}
