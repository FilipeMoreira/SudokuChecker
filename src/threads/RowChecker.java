/*
 * Author: Filipe Moreira
 */

package threads;

import util.Verdict;

public class RowChecker implements Runnable {

	int answer[][], rowNumber;
	int aux[] = {0,0,0,0,0,0,0,0,0};

	public RowChecker(int rowNumber, int answer[][]) {
		this.answer = answer;
		this.rowNumber = rowNumber;
	}

	/*
	 * After receiving the matrix with the answers and the
	 * number of the row to check, this class uses a linear
	 * loop to check it and, whenever it finds a mistake, prints
	 * it and inform the class Verdict about the mistake.
	 * 
	 * At the end of the loop this class increments the counter
	 * on the Verdict Class to inform it has finished its work.
	 */

	
	@Override
	public void run() {

		for (int i = 0; i < 9; i++) {
			if (++aux[answer[rowNumber][i]-1] > 1){
				System.out.println(answer[rowNumber][i] + " repeated on row " + rowNumber);
				Verdict.mistakeFound();
			}
		}
		
		Verdict.incrementCount();

	}

}
