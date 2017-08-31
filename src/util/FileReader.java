/*
 * Author: Filipe Moreira
 */

package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {
	public int[][] readFile(String path) throws IOException{
		
		int answer[][] = new int[9][9];
		
		/*
		 * Creates a new BufferedReader instance with a new FileReader pointing to the path
		 * of the file acquired from the argument
		 */
		
		BufferedReader br = new BufferedReader(new java.io.FileReader(new File(path)));
		
		/*
		 * Reads each line of the file spliting them on the spaces lto store the values on the matrix
		 */
		
		String row = br.readLine();
		String rowSplited[];
		for(int rowNumber=0; row!=null && rowNumber<9; rowNumber++){
			rowSplited = row.split(" ");
			for(int i=0; i<9; i++){
				answer[rowNumber][i] = Integer.parseInt(rowSplited[i]);
			}
			row = br.readLine();
		}
		
		br.close();
		return answer;
	}
}
