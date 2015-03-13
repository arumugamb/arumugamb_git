package com.bala.puzzles.solution;

import java.util.Scanner;

/**
 * This is a Puzzle Program.
 * @author arumugamb
 *
 */
public class ChairSurvivor {

	public static int getSurvivorChair(int noOfChairs) {
		if(noOfChairs <= 0){
			System.out.println("Invalid chair count. Terminating.");
			return -1;
		}
		
		if (noOfChairs == 1) {			
			return 1;
		}
		
		String bitPattern = Integer.toBinaryString(noOfChairs);
		//System.out.println(Integer.toBinaryString(noOfChairs));
		
		int tempChairPos = (int) Math.pow(2, bitPattern.length()) - noOfChairs; 
		
		//case 1: 128-100 = 28 or case 2: like 32-16=16
		int surChairPos = noOfChairs - tempChairPos; //100-28 = 72		
		if (surChairPos == 0) {// 2 power n cases i.e edge cases 16 - 16 = 0
			return tempChairPos;
		}else{
			return surChairPos;
		}		
	}

	public static void main(String[] args) {
		while(true){
			System.out.println("Enter no of chairs:");
			Scanner scan = new Scanner(System.in);
			int noOfChairs = scan.nextInt();
			if(noOfChairs <= 0){
				System.out.println("Invalid chair count. Terminating.");
				return;
			}
			System.out.println("Position of the Survivor chair/number is "+ getSurvivorChair(noOfChairs));
		}
	}
}
