package com.metacube;

import java.util.Scanner;

public class ArrOperation {
	
	/**
	 * find the longest mirror length
	 * @param mirrorArray type: integer[]
	 * @return max type: integer
	 */
	public static int longestMirror( int[] mirrorArray){
		if(mirrorArray.length == 0) {
			try{
				throw new AssertionError();
			}
			catch (AssertionError e) {
				System.out.println("Array is Empty");
				return 0;
			}
		}
		
		int max = 0 ;
		for ( int loop1 = 0; loop1 < mirrorArray.length-1; loop1++ ) {
			int count = 0;
			for ( int loop2 = mirrorArray.length-1; (loop2 >= 0) && ( (loop1 + count) < mirrorArray.length); loop2-- ) {
				if ( mirrorArray[ loop1 + count ] == mirrorArray[ loop2 ] ) {
					count += 1;	
				}
				else {
					if( count > max ){
						max = count;
					}
					count = 0;
				}
			}
			if( count > max ){
				max = count;
			}
		}
		return max;
	}

	/**
	 * find the longest clump
	 * @param arr : type: integer[]
	 * @return clump type: int
	 */
	public static int clumps( int clumpArray[]){
		if(clumpArray.length == 0) {
			try {
				throw new AssertionError();
				}
			catch (AssertionError e) {
				System.out.println("Array is Empty");
				return 0;
			}
		}
		int clump = 0, count = 0;
		
		for(int i = 0; i < clumpArray.length-1; i++){
			for(int j = i+1; j < clumpArray.length; j++){
				if ( clumpArray[i] == clumpArray[j] ){
					count += 1;
				}
				
				if ( clumpArray[i] != clumpArray[j] || j == clumpArray.length-1 ) {
					if ( count > 0 ){
						clump += 1;
						count = 0;
					}
				}
				i = j;
			}
		}
		return clump;
	}
	
	/**
	 * find the index where split is possible
	 * @param arrayToSplit type: integer[]
	 * @return index type: integer
	 */
	public static int splitArray( int[] arrayToSplit ) {
		if(arrayToSplit.length == 0) {
			try {
				throw new AssertionError();
			}
			catch (AssertionError e) {
				System.out.println("Array is Empty");
				return 0;
			}
		}
		
		int totalSum = 0, loop1, loop2;
		
		for ( int loop = 0; loop < arrayToSplit.length; loop++) {
			totalSum += arrayToSplit[ loop ];
		}
		
		for ( loop1 = 0; loop1 < arrayToSplit.length; loop1++) {
			int sum = 0;
			for ( loop2 = 0; loop2 <= loop1; loop2++) {
				sum += arrayToSplit[ loop2 ];
			}
			
			if ( sum == ( totalSum - sum )) {
				return (loop1 + 1);
			}
		}
		return -1;
	}
	
	/**
	* Solve XY problem in array y should be just after x
	* @param arr type: integer[] 
	* @param x type: integer
	* @param y type: integer
	* @return array type: integer[]
	*/
	public static int[] fitXY(int arr[],int x,int y){

		if(arr.length == 0) {
			try{
				throw new AssertionError();
			}
			catch (AssertionError e) {
				System.out.println("Array is Empty");
				return new int[]{0};
			}
		}
				
		if (arr[arr.length - 1] == x) {
			throw new AssertionError("X cannot be at last index");
		}
		
		int countx = 0, county = 0;
		
		for(int loop = 0; loop <= arr.length - 1; loop++){
			if (arr[loop] == x) {
				countx++;
			}
			if (arr[loop] == y) {
				county++;
			}
		}
		
		if (countx != county) {
			throw new AssertionError("X and Y are unequal in number");
		}
		
		for(int loop = 0; loop < arr.length - 1; loop++){
			if (arr[loop] == x && arr[loop + 1] == x){
				throw new AssertionError("X cant be after X");
			}
		}
		
		int tempIndex, temp;
		
		for (int loop = 0; loop < arr.length - 1; loop++) {
			if(arr[loop] == x && arr[loop + 1] != y){
				tempIndex = getYIndex(arr, x, y);
				temp = arr[tempIndex];
				arr[tempIndex] = arr[loop+1];
				arr[loop + 1] = temp;
			}
		}
		return arr;
	}
	
	public static int getYIndex(int arr[], int x, int y){
		int lastIndex = arr.length - 1;
		if (arr[0] == y){
			return 0;
		}
			
		for (int loop = 1;loop <= lastIndex; loop++){
			if (arr[loop] == y && arr[loop - 1] != x){
				return loop;
			}
		}
		return 0;
	}

}