/*
 * Author: Filipe Moreira
 */

package util;

public class Verdict {
	
	private static boolean correct = true;
	private static int threadCount = 0;
	
	/*
	 * This class holds the verdict for the solution
	 * either it's a valid solution or not.
	 * 
	 * The synchronized modifiers ensure the threads
	 * will not access the methods at the same time
	 * so there will be no inconsistency in the counter.
	 * 
	 * The last method is called after all threads have
	 * finished their work to inform if the solution
	 * is valid or not.
	 */

	public static synchronized void mistakeFound(){
		correct = false;
	}
	
	public static synchronized void incrementCount(){
		if(++threadCount == 27)
			showVeredict();
	}
	
	private static void showVeredict(){
		if(correct){
			System.out.println("\n*** This is a valid Sudoku solution.");
		}else{
			System.out.println("\n*** This is not a valid Sudoku solution.");
		}
	}
	
}
