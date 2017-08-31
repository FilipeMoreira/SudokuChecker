/*
 * Author: Filipe Moreira
 */

package threads;

import util.Verdict;

public class ColumnChecker implements Runnable{
	
	int answer[][], columnNumber;
	int aux[] = {0,0,0,0,0,0,0,0,0};

	public ColumnChecker(int columnNumber, int answer[][]) {
		this.answer = answer;
		this.columnNumber = columnNumber;
	}
	
	/*
	 * After receiving the matrix with the answers and the
	 * number of the column to check, this class uses a linear
	 * loop to check it and, whenever it finds a mistake, prints
	 * it and inform the class Verdict about the mistake.
	 * 
	 * At the end of the loop this class increments the counter
	 * on the Verdict Class to inform it has finished its work.
	 */

	@Override
	public void run() {

		for (int i = 0; i < 9; i++) {
			if (++aux[answer[i][columnNumber]-1] > 1){
				System.out.println(answer[i][columnNumber] + " repeated on column " + columnNumber);
				Verdict.mistakeFound();
			}
		}
		
		Verdict.incrementCount();

	}
}
