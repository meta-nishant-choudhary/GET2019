package search;

import java.util.Arrays;

public class Search {
	public static void main(String[] args) {
		int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int element = 2;
		System.out.println("index: " + binarySearch(inputArray, element));
	}
	
	/**
	 * performs linear search 
	 * @param inputArray
	 * @param element
	 * @return index such that inputArray[index] == element, else -1
	 */
	public static int linearSearch(int[] inputArray,int element) {
			if (inputArray.length <= 0) {
				return -1;
			}
			else if (inputArray[inputArray.length - 1] == element) {
				return inputArray.length-1;
			}
			int[] subArray = Arrays.copyOfRange(inputArray, 0, inputArray.length-1);
		return linearSearch(subArray,element);
	}
	
	/**
	 * performs binary search
	 * 
	 * @param inputArray sorted array
	 * @param element
	 * @return index such that inputArray[index] == element, else -1
	 */
	public static int binarySearch(int[] inputArray,int element){
		int length = inputArray.length;
		
		if (length <= 0) {
				return -1;
		}
		
		if (inputArray[ length - 1 ] < element || inputArray[ 0 ] > element) {
			throw new AssertionError("element not found");
		}
		
		int[] subArray;
		int mid = (inputArray.length - 1) / 2;
		
		if (inputArray[mid] == element) {
			return mid;
		}
		else if (inputArray[mid] > element) {
			subArray = Arrays.copyOfRange(inputArray, 0, mid);
			return binarySearch(subArray, element);   
		}
		else {
			subArray = Arrays.copyOfRange(inputArray, mid + 1, inputArray.length - 1);
			return binarySearch(subArray, element);
		}
	}
}
