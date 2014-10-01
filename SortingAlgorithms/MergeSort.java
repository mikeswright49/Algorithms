package SortingAlgorithms;

public class MergeSort implements ISorter{

	public MergeSort(){}
	
	public int[] Sort(int[] inputArray){
		return mergeSort(inputArray, 0, inputArray.length-1);
	}
	private int[] mergeSort(int[] input, int start, int end){
		if(input.length==1)
			return input;
		
		int middle = (end-start)/2;
		
		int[] left = splice(input, start, middle-1);
		int[] right = splice(input, middle, end);
		left = mergeSort(left, 0, left.length-1);
		right = mergeSort(right, 0, right.length-1);
		return merge(left, right);
		
	}
	private int[] splice(int[] input, int start, int end){
		if(input.length==1)
			return input;
		int[] tempArray;
		if(end-start<1||end<0){
			tempArray = new int[1];
			tempArray[0] = input[0];
		}
		else{
			tempArray = new int[end-start];
			for(int i=0;i<tempArray.length;i++)
				tempArray[i] = input[end--];
		}
	
		return tempArray;
	}
	private int[] merge(int[] left, int[] right){
		int[] merged = new int[left.length+right.length];
		int leftIndex =0;
		int rightIndex =0;
		for(int i=0; i<merged.length;i++){
			if(leftIndex>=left.length){
				merged[i]=right[rightIndex];
				rightIndex++;
			}
			else if(rightIndex>=right.length){
				merged[i]=left[leftIndex];
				leftIndex++;				
			}
			else if(right[rightIndex]>=left[leftIndex]){
				merged[i]=left[leftIndex];
				leftIndex++;
			}
			else{
				merged[i]=right[rightIndex];
				rightIndex++;
			}
		}
		return merged;
	}
}
