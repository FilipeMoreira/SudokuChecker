/*
 * Author: Filipe Moreira
 * 
 */

package main;

import java.io.IOException;
import java.util.ArrayList;

import threads.ColumnChecker;
import threads.RowChecker;
import threads.SectorChecker;
import util.FileReader;

public class Main {

	static ArrayList<Thread> at = new ArrayList<Thread>();
	
	/*
	 * To alternate between input files comment the active line
	 * and uncomment the desired one
	 */
	
	static final String file = "src/files/input1.txt";
	//static final String file = "src/files/input2.txt";
	//static final String file = "src/files/input3.txt";

	public static void main(String args[]) {

		int answer[][] = null;
		
		try {
			
			/*
			 * Reads the file using the FileReader class;
			 * Prints the solution that was on the file
			 */
			
			answer = new FileReader().readFile(file);
			
			for(int i=0; i<9; i++){
				for(int j=0; j<9; j++)
					System.out.print(answer[i][j]+" ");
				System.out.print("\n");
			}
			
			/*
			 * Creates all the Threads to check the rows, columns and sectors
			 * of the solution for mistakes
			 */

			for (int i = 0; i < 9; i++) {
				System.out.println("Creating and starting Thread to row " + i);
				at.add(new Thread(new RowChecker(i, answer)));
				at.get(at.size() - 1).start();
				System.out.println("Creating and starting Thread to column " + i);
				at.add(new Thread(new ColumnChecker(i, answer)));
				at.get(at.size() - 1).start();
				System.out.println("Creating and starting Thread to sector " + i);
				at.add(new Thread(new SectorChecker(i, answer)));
				at.get(at.size() - 1).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
