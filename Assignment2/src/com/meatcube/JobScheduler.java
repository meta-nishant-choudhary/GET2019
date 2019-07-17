package com.meatcube;

import java.util.Scanner;

class JobScheduler{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		int [][]FCFS = null;
		int flag = 0, numberOfProcess = 0;
		do{
			try {
				System.out.println("Enter the number of process: ");
				numberOfProcess = input.nextInt();
				FCFS = new int[numberOfProcess][2];
				
				for(int loop = 0; loop < numberOfProcess; loop++){
					System.out.println("Arrival time: ");
					FCFS[loop][0] = input.nextInt();
				
					System.out.println("Burst time: ");
					FCFS[loop][1] = input.nextInt();
				}
				flag = 1;
			}
			catch (Exception e){
				System.out.println("error: invalid input");
				flag = 0;
				input.next();
			}
		} while(flag == 0);
		
		int []CT = completionTime(FCFS);
		int []TAT = turnAroundTime(CT,FCFS);
		int []WT = waitingTime(TAT,FCFS);
		
		for(int i = 0; i < numberOfProcess; i++){
			System.out.println("Completion time of process " + (i + 1) + ": " + CT[i]);
			System.out.println("Turn Around Time of process " + (i + 1) + ": " + TAT[i]);
			System.out.println("Waiting Time of process " + (i + 1) + ": " + WT[i]);
			System.out.println("--------------------------------");
		}
		System.out.println("Average Waiting Time : " + averageWaitingTime(WT));

		int max = maxWait(WT);
		System.out.println("longest waiting time for a process is " + max);
	}
	
	public static int[] turnAroundTime(int []CT,int [][]FCFS){
		int size = FCFS.length;
		int[] TAT = new int[size];
		int col = 0;
		for(int row = 0; row < FCFS.length; row++){
			TAT[row] = CT[row] - FCFS[row][col];
		}
		return TAT;
	}

	public static int[] waitingTime(int []TAT,int [][]FCFS){
		int size = FCFS.length;
		int[] WT = new int[size];
		int col=1;
		for(int row = 0; row < WT.length; row++){
			WT[row] = TAT[row] - FCFS[row][col];
		}
		return WT;
	}

	public static int averageWaitingTime(int []WT){
		int totalWaitingTime = 0;
		for(int wt = 0; wt < WT.length; wt++){
			totalWaitingTime += WT[wt];
		}
		return totalWaitingTime/WT.length;
	}

	public static int maxWait(int []WT){
		int max = WT[0];
		for(int wt = 1; wt < WT.length; wt++){
			if(max < WT[wt]){
				max = WT[wt];
			}
		}
		return max;
	}

	public static int[] completionTime(int [][]FCFS){
		int []CT = new int[10];
		int col;
		for(int row = 0; row < FCFS.length; row++){
			col = 0;
			if (FCFS[row][0] >= 0 && CT[0] == 0){
				CT[row] = FCFS[row][1];
			}
			else if (FCFS[row][0] < CT[0]){
				CT[row] = CT[row-1] + FCFS[row][1];
			}
			else if (FCFS[row][0] > CT[0]){
				CT[row] = FCFS[row][0] + FCFS[row][1];
			}
		}
		return CT;
	}
}
