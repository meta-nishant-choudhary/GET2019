package com.meatcube;

import java.util.Scanner;

class JobScheduler{
	public static void main(String[] args) {
		int [][]FCFS = new int[10][10];
		Scanner input = new Scanner(System.in);	
		System.out.println("Enter the number of process: ");
		int numberOfProcess = input.nextInt();
		
		for(int loop = 0; loop < numberOfProcess; loop++){
			System.out.println("Arrival time: ");
			FCFS[loop][0] = input.nextInt();
			
			System.out.println("Burst time: ");
			FCFS[loop][1] = input.nextInt();
		}
		
		int []CT = completionTime(FCFS);
		int []TAT = turnAroundTime(CT,FCFS);
		int []WT = waitingTime(TAT,FCFS);
		
		for(int i=0;i<4;i++){
			System.out.println("Completion time of process " + (i + 1) + ": " + CT[i]);
			System.out.println("Turn Around Time of process " + (i + 1) + ": " + TAT[i]);
			System.out.println("Waiting Time of process " + (i + 1) + ": " + WT[i]);
			System.out.println("--------------------------------");
		}
		System.out.println("Average Waiting Time : " + averageWaitingTime(WT));

		int []max = maxWait(WT);
		System.out.println("longest waiting time for a process " + max[1] + "is : " + max[0]);
	}
	public static int[] completionTime(int [][]FCFS){
		int []CT = new int[10];

		for(int loop1 = 0; loop1 < 4; loop1++){
			for(int loop2 = 0; loop2 < 2; loop2++){
				if(FCFS[loop1][loop2] == 0 && CT[0] == 0){
					loop2 += 1;
					CT[loop1] = FCFS[loop1][loop2];
				}
				else if(FCFS[loop1][loop2] < CT[loop1-1]){
					loop2 += 1;
					CT[loop1] = CT[loop1-1] + FCFS[loop1][loop2];
				}
				else if(FCFS[loop1][loop2] > CT[loop1]){
					CT[loop1] = FCFS[loop1][loop2] + FCFS[loop1][loop2+1];
					loop2 = 1;
				}
			}
		}
		return CT;
	}
	
	public static int[] turnAroundTime(int []CT,int [][]FCFS){
		int[] TAT = new int[4];
		int col = 0;
		for(int row = 0; row < 4; row++){
			TAT[row] = CT[row] - FCFS[row][col];
		}
		return TAT;
	}

	public static int[] waitingTime(int []TAT,int [][]FCFS){
			int[] WT = new int[4];
			int col=1;
			for(int row = 0; row < 4; row++){
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

	public static int[] maxWait(int []WT){
		int []max = new int[2]; 
		max[0] = WT[0];
		for(int wt = 1; wt < WT.length; wt++){
			if(max[0] < WT[wt]){
				max[0] = WT[wt];
				max[1] = wt;
			}
		}
		return max;
	}
}