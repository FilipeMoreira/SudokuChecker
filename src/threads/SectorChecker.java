/*
 * Author: Filipe Moreira
 */

package threads;

import util.Verdict;

public class SectorChecker implements Runnable {
	int answer[][], sectorNumber;
	int aux[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public SectorChecker(int sectorNumber, int answer[][]) {
		this.answer = answer;
		this.sectorNumber = sectorNumber;
	}
	
	/*
	 * After receiving the matrix with the answers and the
	 * number of the sector to check, this class uses a quadratic
	 * loop, that maps the sector number to the line and row numbers
	 * with an injective function, to check it and, whenever it finds a mistake, prints
	 * it and inform the class Verdict about the mistake.
	 * 
	 * At the end of the loop this class increments the counter
	 * on the Verdict Class to inform it has finished its work.
	 */


	@Override
	public void run() {

		for (int i = (sectorNumber / 3) * 3; i < ((sectorNumber / 3) * 3) + 3; i++) {
			for (int j = (sectorNumber % 3) * 3; j < ((sectorNumber % 3) * 3) + 3; j++) {
				if (++aux[answer[i][j] - 1] > 1) {
					System.out.println(answer[i][j] + " repeated on sector " + sectorNumber);
					Verdict.mistakeFound();
				}
			}
		}
		
		Verdict.incrementCount();

	}
}
